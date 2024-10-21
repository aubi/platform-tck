package com.sun.ts.tests.jms.ee.ejb.sessionQtests;

import com.sun.ts.tests.jms.ee.ejb.sessionQtests.Client;
import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import tck.arquillian.porting.lib.spi.TestArchiveProcessor;
import tck.arquillian.protocol.common.TargetVehicle;



@ExtendWith(ArquillianExtension.class)
@Tag("jms")
@Tag("platform")
@Tag("jms_web")
@Tag("web_optional")
@Tag("tck-appclient")

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ClientTest extends com.sun.ts.tests.jms.ee.ejb.sessionQtests.Client {
    /**
        EE10 Deployment Descriptors:
        jms_ejb_sessionQtests: 
        jms_ejb_sessionQtests_client: META-INF/application-client.xml,jar.sun-application-client.xml
        jms_ejb_sessionQtests_ejb: META-INF/ejb-jar.xml,jar.sun-ejb-jar.xml

        Found Descriptors:
        Client:

        /com/sun/ts/tests/jms/ee/ejb/sessionQtests/jms_ejb_sessionQtests_client.xml
        /com/sun/ts/tests/jms/ee/ejb/sessionQtests/jms_ejb_sessionQtests_client.jar.sun-application-client.xml
        Ejb:

        /com/sun/ts/tests/jms/ee/ejb/sessionQtests/jms_ejb_sessionQtests_ejb.xml
        /com/sun/ts/tests/jms/ee/ejb/sessionQtests/jms_ejb_sessionQtests_ejb.jar.sun-ejb-jar.xml
        Ear:

        */
        @TargetsContainer("tck-appclient")
        @OverProtocol("appclient")
        @Deployment(name = "jms_ejb_sessionQtests", order = 2)
        public static EnterpriseArchive createDeployment(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // Client
            // the jar with the correct archive name
            JavaArchive jms_ejb_sessionQtests_client = ShrinkWrap.create(JavaArchive.class, "jms_ejb_sessionQtests_client.jar");
            // The class files
            jms_ejb_sessionQtests_client.addClasses(
            com.sun.ts.tests.jms.common.JmsTool.class,
            com.sun.ts.tests.jms.ee.ejb.sessionQtests.Client.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.jms.commonee.Tests.class
            );
            // The application-client.xml descriptor
            URL resURL = Client.class.getResource("jms_ejb_sessionQtests_client.xml");
            if(resURL != null) {
              jms_ejb_sessionQtests_client.addAsManifestResource(resURL, "application-client.xml");
            }
            // The sun-application-client.xml file need to be added or should this be in in the vendor Arquillian extension?
            resURL = Client.class.getResource("/com/sun/ts/tests/jms/ee/ejb/sessionQtests/jms_ejb_sessionQtests_client.jar.sun-application-client.xml");
            if(resURL != null) {
              jms_ejb_sessionQtests_client.addAsManifestResource(resURL, "sun-application-client.xml");
            }
            jms_ejb_sessionQtests_client.addAsManifestResource(new StringAsset("Main-Class: " + Client.class.getName() + "\n"), "MANIFEST.MF");
            // Call the archive processor
            archiveProcessor.processClientArchive(jms_ejb_sessionQtests_client, Client.class, resURL);

        // Ejb
            // the jar with the correct archive name
            JavaArchive jms_ejb_sessionQtests_ejb = ShrinkWrap.create(JavaArchive.class, "jms_ejb_sessionQtests_ejb.jar");
            // The class files
            jms_ejb_sessionQtests_ejb.addClasses(
                com.sun.ts.tests.jms.commonee.TestsEJB.class,
                com.sun.ts.tests.jms.commonee.Tests.class
            );
            // The ejb-jar.xml descriptor
            URL ejbResURL = Client.class.getResource("/com/sun/ts/tests/jms/ee/ejb/sessionQtests/jms_ejb_sessionQtests_ejb.xml");
            if(ejbResURL != null) {
              jms_ejb_sessionQtests_ejb.addAsManifestResource(ejbResURL, "ejb-jar.xml");
            }
            // The sun-ejb-jar.xml file
            ejbResURL = Client.class.getResource("/com/sun/ts/tests/jms/ee/ejb/sessionQtests/jms_ejb_sessionQtests_ejb.jar.sun-ejb-jar.xml");
            if(ejbResURL != null) {
              jms_ejb_sessionQtests_ejb.addAsManifestResource(ejbResURL, "sun-ejb-jar.xml");
            }
            // Call the archive processor
            archiveProcessor.processEjbArchive(jms_ejb_sessionQtests_ejb, Client.class, ejbResURL);

        // Ear
            EnterpriseArchive jms_ejb_sessionQtests_ear = ShrinkWrap.create(EnterpriseArchive.class, "jms_ejb_sessionQtests.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            jms_ejb_sessionQtests_ear.addAsModule(jms_ejb_sessionQtests_ejb);
            jms_ejb_sessionQtests_ear.addAsModule(jms_ejb_sessionQtests_client);



        return jms_ejb_sessionQtests_ear;
        }

        @Test
        @Override
        public void simpleSendReceiveQueueTest() throws java.lang.Exception {
            super.simpleSendReceiveQueueTest();
        }

        @Test
        @Override
        public void selectorAndBrowserTests() throws java.lang.Exception {
            super.selectorAndBrowserTests();
        }


}