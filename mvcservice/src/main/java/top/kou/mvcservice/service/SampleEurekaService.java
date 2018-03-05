package top.kou.mvcservice.service;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

public class SampleEurekaService implements ServletContextListener{
//    private static final DynamicPropertyFactory configInstance = DynamicPropertyFactory
//            .getInstance();


    private static final Logger logger = LoggerFactory
            .getLogger(SampleEurekaService.class);


    public void registerWithEureka() {
        // Register with Eureka
        DiscoveryManager.getInstance().initComponent(
                new MyInstanceConfig(),
                new DefaultEurekaClientConfig());
        ApplicationInfoManager.getInstance().setInstanceStatus(
                InstanceStatus.UP);
//        String vipAddress = configInstance.getStringProperty(
//                "eureka.vipAddress", "hmc-web.mydomain.net").get();
//        InstanceInfo nextServerInfo = null;
//        while (nextServerInfo == null) {
//            try {
//                nextServerInfo = DiscoveryManager.getInstance()
//                        .getDiscoveryClient()
//                        .getNextServerFromEureka(vipAddress, false);
//            } catch (Throwable e) {
//                System.out
//                        .println("Waiting for service to register with eureka..");
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                }
//            }
//        }
//        System.out.println("Service started and ready to process requests..");
//        System.out.println("Found an instance of example service to talk to from eureka: "
//                + nextServerInfo.getVIPAddress() + ":" + nextServerInfo.getPort());
//
//        System.out.println("healthCheckUrl: " + nextServerInfo.getHealthCheckUrl());
//        System.out.println("override: " + nextServerInfo.getOverriddenStatus());
//
//        System.out.println("Server Host Name "+ nextServerInfo.getHostName() + " at port " + nextServerInfo.getPort() );

//                try {
//                    ServerSocket serverSocket = new ServerSocket(configInstance
//                            .getIntProperty("eureka.port", 8010).get());
//                    final Socket s = serverSocket.accept();
//                    System.out
//                    .println("Client got connected..Processing request from the client");
//                    processRequest(s);
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                this.unRegisterWithEureka();
//                System.out.println("Shutting down server.Demo over.");


    }


    public void unRegisterWithEureka() {
        // Un register from eureka.
        DiscoveryManager.getInstance().shutdownComponent();
    }


    private void processRequest(final Socket s) {
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    s.getInputStream()));
            String line = rd.readLine();
            if (line != null) {
                System.out.println("Received the request from the client.");
            }
            PrintStream out = new PrintStream(s.getOutputStream());
            System.out.println("Sending the response to the client...");


            out.println("Reponse at " + new Date());


        } catch (Throwable e) {
            System.err.println("Error processing requests");
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


    }


    public static void main(String args[]) {
        SampleEurekaService sampleEurekaService = new SampleEurekaService();
        sampleEurekaService.registerWithEureka();
    }


    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        registerWithEureka();
    }


    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        unRegisterWithEureka();
    }

}