package org.activemq.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "org.activemq")
@Import({MessagingConfiguration.class})
public class AppConfig {
}
