package com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton;

import com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.JsfClient;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tck.arquillian.porting.lib.spi.TestArchiveProcessor;
import tck.arquillian.protocol.common.TargetVehicle;



@ExtendWith(ArquillianExtension.class)
@Tag("platform")
@Tag("ejb_web_profile")
@Tag("web")
@Tag("tck-javatest")

public class JsfClientEjbliteservletTest extends com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.JsfClient {
    static final String VEHICLE_ARCHIVE = "ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle";

        /**
        EE10 Deployment Descriptors:
        ejb32_lite_timer_interceptor_lifecycle_singleton_ejblitejsf_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/beans.xml,WEB-INF/faces-config.xml,WEB-INF/web.xml
        ejb32_lite_timer_interceptor_lifecycle_singleton_ejblitejsp_vehicle_web: WEB-INF/ejb-jar.xml
        ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/web.xml
        ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet2_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/web.xml

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
            WebArchive ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web = ShrinkWrap.create(WebArchive.class, "ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web.war");
            // The class files
            ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web.addClasses(
            com.sun.ts.tests.common.vehicle.ejbliteshare.EJBLiteClientIF.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.Client.class,
            com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.EJBLiteServletVehicle.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.HttpServletDelegate.class,
            com.sun.ts.tests.common.vehicle.ejbliteshare.ReasonableStatus.class,
            com.sun.ts.tests.ejb30.timer.common.JsfClientBase.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.ejb30.common.lite.NumberEnum.class,
            com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.JsfClient.class,
            com.sun.ts.tests.ejb30.common.helper.Helper.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteClientBase.class,
            com.sun.ts.tests.ejb30.timer.common.ClientBase.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteJsfClientBase.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.ejb30.common.lite.NumberIF.class
            );
            // The web.xml descriptor
            URL warResURL = JsfClient.class.getResource("ejbliteservlet_vehicle_web.xml");
            if(warResURL != null) {
              ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = JsfClient.class.getResource("/ejbliteservlet_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }
            // Web content
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/ejb32/lite/timer/interceptor/lifecycle/singleton/ejb-jar.xml");
            if(warResURL != null) {
              ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/ejb-jar.xml");
            }
            // ejb.jar lib
            JavaArchive ejbJar = ShrinkWrap.create(JavaArchive.class, "ejb.jar");
            ejbJar.addClasses(
                    com.sun.ts.tests.ejb30.timer.common.TimerInfo.class,
                    com.sun.ts.tests.ejb30.timer.common.TimerUtil.class,
                    com.sun.ts.tests.ejb30.timer.common.TimeoutStatusBean.class,
                    com.sun.ts.tests.ejb30.timer.common.TimerBeanBaseWithoutTimeOutMethod.class,
                    com.sun.ts.tests.ejb30.timer.common.TimerBeanBase.class,
                    com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.Interceptor1.class,
                    com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.Interceptor2.class,
                    com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.Interceptor10.class,
                    com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.InterceptorBase.class,
                    com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.LifecycleTimerBean.class,
                    com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.LifecycleAroundConstructTimerBean.class,
                    com.sun.ts.tests.ejb32.lite.timer.interceptor.lifecycle.singleton.LifecycleTimerBeanBase.class
            );
            ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web.addAsLibrary(ejbJar);

           // Call the archive processor
           archiveProcessor.processWebArchive(ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web, JsfClient.class, warResURL);

        return ejb32_lite_timer_interceptor_lifecycle_singleton_ejbliteservlet_vehicle_web;
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void postConstructInBeanClass() {
            super.postConstructInBeanClass();
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void postConstructInInterceptorClasses() {
            super.postConstructInInterceptorClasses();
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void aroundConstructInBeanClass() {
            super.aroundConstructInBeanClass();
        }


}