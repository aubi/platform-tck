package com.sun.ts.tests.ejb30.lite.async.stateless.descriptor;

import com.sun.ts.tests.ejb30.lite.async.stateless.descriptor.JsfClient;
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
@Tag("platform")
@Tag("ejb_web")
@Tag("web")
@Tag("tck-javatest")

@TestMethodOrder(MethodOrderer.MethodName.class)
public class JsfClientEjbliteservletTest extends com.sun.ts.tests.ejb30.lite.async.stateless.descriptor.JsfClient {
    static final String VEHICLE_ARCHIVE = "ejblite_async_stateless_descriptor_ejbliteservlet_vehicle";

        /**
        EE10 Deployment Descriptors:
        ejblite_async_stateless_descriptor_ejblitejsf_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/beans.xml,WEB-INF/faces-config.xml,WEB-INF/web.xml
        ejblite_async_stateless_descriptor_ejblitejsp_vehicle_web: WEB-INF/ejb-jar.xml
        ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/web.xml
        ejblite_async_stateless_descriptor_ejbliteservlet2_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/web.xml

        Found Descriptors:
        War:

        /com/sun/ts/tests/common/vehicle/ejbliteservlet/ejbliteservlet_vehicle_web.xml
        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static WebArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {

        // War
            // the war with the correct archive name
            WebArchive ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web = ShrinkWrap.create(WebArchive.class, "ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web.war");
            // The class files
            ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web.addClasses(
            com.sun.ts.tests.common.vehicle.ejbliteshare.EJBLiteClientIF.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.ejb30.lite.async.common.descriptor.TimeoutDescriptorBeanBase.class,
            com.sun.ts.tests.ejb30.lite.async.common.descriptor.DescriptorClientBase.class,
            com.sun.ts.tests.common.vehicle.ejbliteshare.ReasonableStatus.class,
            com.sun.ts.tests.ejb30.lite.async.stateless.descriptor.HttpServletDelegate.class,
            com.sun.ts.tests.ejb30.lite.async.common.descriptor.DescriptorBean.class,
            com.sun.ts.tests.ejb30.lite.async.common.descriptor.DescriptorJsfClientBase.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.ejb30.lite.async.stateless.descriptor.Client.class,
            com.sun.ts.tests.ejb30.common.lite.NumberEnum.class,
            com.sun.ts.tests.ejb30.lite.async.common.descriptor.Descriptor2IF.class,
            com.sun.ts.tests.ejb30.common.helper.Helper.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteClientBase.class,
            com.sun.ts.tests.ejb30.lite.async.stateless.descriptor.EJBLiteServletVehicle.class,
            com.sun.ts.tests.ejb30.lite.async.stateless.descriptor.JsfClient.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteJsfClientBase.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.ejb30.lite.async.common.descriptor.DescriptorIF.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.ejb30.common.lite.NumberIF.class
            );
            // The web.xml descriptor
            URL warResURL = JsfClient.class.getResource("ejbliteservlet_vehicle_web.xml");
            if(warResURL != null) {
              ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = JsfClient.class.getResource("/ejbliteservlet_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }

            // Any libraries added to the war

            // Web content
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/ejb30/lite/async/stateless/descriptor/ejb-jar.xml");
            if(warResURL != null) {
              ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/ejb-jar.xml");
            }
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/common/vehicle/ejbliteservlet/ejbliteservlet_vehicle_web.xml");
            if(warResURL != null) {
              ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/ejbliteservlet_vehicle_web.xml");
            }

           // Call the archive processor
           archiveProcessor.processWebArchive(ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web, JsfClient.class, warResURL);

        return ejblite_async_stateless_descriptor_ejbliteservlet_vehicle_web;
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void allViews() {
            super.allViews();
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void localViews() {
            super.localViews();
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void allParams() {
            super.allParams();
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void noParams() {
            super.noParams();
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void intParams() {
            super.intParams();
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void intParamsLocalViews() {
            super.intParamsLocalViews();
        }


}