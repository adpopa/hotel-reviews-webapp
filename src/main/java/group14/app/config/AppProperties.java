/**
 * AppProperties.java
 */
package group14.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Alex Daniel Popa
 *
 */
@Configuration
@PropertySource("classpath:config/application.properties")
class AppProperties {

	// this bean binds the application.properties within the resources folder
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}