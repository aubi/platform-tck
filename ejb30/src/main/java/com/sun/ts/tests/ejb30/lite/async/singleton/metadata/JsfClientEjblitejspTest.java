package com.sun.ts.tests.ejb30.lite.async.singleton.metadata;

import com.sun.ts.tests.ejb30.lite.async.singleton.metadata.JsfClient;
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
public class JsfClientEjblitejspTest extends com.sun.ts.tests.ejb30.lite.async.singleton.metadata.JsfClient {
    static final String VEHICLE_ARCHIVE = "ejblite_async_singleton_metadata_ejblitejsp_vehicle";

        /**
        EE10 Deployment Descriptors:
        ejblite_async_singleton_metadata_ejblitejsf_vehicle_web: WEB-INF/beans.xml,WEB-INF/faces-config.xml,WEB-INF/web.xml,war.sun-ejb-jar.xml
        ejblite_async_singleton_metadata_ejblitejsp_vehicle_web: war.sun-ejb-jar.xml
        ejblite_async_singleton_metadata_ejbliteservlet_vehicle_web: WEB-INF/web.xml,war.sun-ejb-jar.xml
        ejblite_async_singleton_metadata_ejbliteservlet2_vehicle_web: WEB-INF/web.xml,war.sun-ejb-jar.xml

        Found Descriptors:
        War:

        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static WebArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {

        // War
            // the war with the correct archive name
            WebArchive ejblite_async_singleton_metadata_ejblitejsp_vehicle_web = ShrinkWrap.create(WebArchive.class, "ejblite_async_singleton_metadata_ejblitejsp_vehicle_web.war");
            // The class files
            ejblite_async_singleton_metadata_ejblitejsp_vehicle_web.addClasses(
            com.sun.ts.tests.ejb30.lite.async.common.metadata.MetadataClientBase.class,
            com.sun.ts.tests.ejb30.lite.async.common.metadata.InterfaceTypeLevelBeanBase.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.ejb30.lite.async.singleton.metadata.HttpServletDelegate.class,
            com.sun.ts.tests.ejb30.lite.async.common.metadata.BeanClassLevel1BeanBase.class,
            com.sun.ts.tests.ejb30.lite.async.common.metadata.MetadataJsfClientBase.class,
            com.sun.ts.tests.ejb30.lite.async.common.AsyncJsfClientBase.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.ejb30.common.helper.Helper.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteClientBase.class,
            com.sun.ts.tests.ejb30.lite.async.singleton.metadata.EJBLiteJSPTag.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.tests.ejb30.lite.async.common.metadata.PlainInterfaceTypeLevelIF.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.ejb30.common.calc.CalculatorException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.ejb30.lite.async.common.metadata.BeanClassLevel3BeanBase.class,
            com.sun.ts.tests.ejb30.common.lite.NumberIF.class,
            com.sun.ts.tests.common.vehicle.ejbliteshare.EJBLiteClientIF.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.ejb30.lite.async.common.metadata.BeanClassLevel2BeanBase.class,
            com.sun.ts.tests.ejb30.lite.async.singleton.metadata.JsfClient.class,
            com.sun.ts.tests.common.vehicle.ejbliteshare.ReasonableStatus.class,
            com.sun.ts.tests.ejb30.lite.async.common.metadata.BeanClassLevel0BeanBase.class,
            com.sun.ts.tests.ejb30.lite.async.common.AsyncClientBase.class,
            com.sun.ts.tests.ejb30.common.lite.NumberEnum.class,
            com.sun.ts.tests.ejb30.lite.async.singleton.metadata.Client.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteJsfClientBase.class,
            com.sun.ts.tests.ejb30.common.statussingleton.StatusSingletonBean.class,
            com.sun.ts.tests.ejb30.lite.async.singleton.metadata.BeanClassLevelBean.class,
            com.sun.ts.tests.ejb30.common.helper.ServiceLocator.class,
            com.sun.ts.lib.harness.EETest.SetupException.class
            );

            // The web.xml descriptor
            URL warResURL = JsfClient.class.getResource("/vehicle/ejblitejsp/ejblitejsp_vehicle_web.xml");
            if(warResURL != null) {
              ejblite_async_singleton_metadata_ejblitejsp_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = JsfClient.class.getResource("//vehicle/ejblitejsp/ejblitejsp_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              ejblite_async_singleton_metadata_ejblitejsp_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }

            // Any libraries added to the war

            // Web content
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/ejb30/lite/async/singleton/metadata/ejblitejsp.tld");
            if(warResURL != null) {
              ejblite_async_singleton_metadata_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/tlds/ejblitejsp.tld");
            }
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/common/vehicle/ejblitejsp/ejblitejsp.tld");
            if(warResURL != null) {
              ejblite_async_singleton_metadata_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/ejblitejsp.tld");
            }
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/common/vehicle/ejblitejsp/ejblitejsp_vehicle.jsp");
            if(warResURL != null) {
              ejblite_async_singleton_metadata_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/ejblitejsp_vehicle.jsp");
            }

           // Call the archive processor
           archiveProcessor.processWebArchive(ejblite_async_singleton_metadata_ejblitejsp_vehicle_web, JsfClient.class, warResURL);

        return ejblite_async_singleton_metadata_ejblitejsp_vehicle_web;
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void beanClassLevelReturnType() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
            super.beanClassLevelReturnType();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void beanClassLevelRuntimeException() throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
            super.beanClassLevelRuntimeException();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void customFutureImpl() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
            super.customFutureImpl();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void beanClassLevelSyncMethod() {
            super.beanClassLevelSyncMethod();
        }


}