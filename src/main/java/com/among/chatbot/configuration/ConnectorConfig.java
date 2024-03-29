package com.among.chatbot.configuration;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class ConnectorConfig {
//    @Value("${server.port.http}")
//    private int serverPortHttp;
//
//    @Value("${server.port}")
//    private int serverPortHttps;

//    @Bean
//    public ServletWebServerFactory servletWebServerFactory() {
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection securityCollection = new SecurityCollection();
//                securityCollection.addPattern("/*");
//                securityConstraint.addCollection(securityCollection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        factory.addAdditionalTomcatConnectors(redirectConnector());
//        factory.setPort(serverPortHttps);
//        return factory;
//    }
//
//    private Connector redirectConnector() {
//        Connector connector = new Connector(Http11NioProtocol.class.getName());
//        connector.setScheme("http");
//        connector.setPort(serverPortHttp);
//        connector.setSecure(false);
//        connector.setRedirectPort(serverPortHttps);
//        return connector;
//    }



//}
