/**
 * RootConfig.java
 */
package group14.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * @author Alex Daniel Popa
 *
 */
@Configuration
// SCan all of the classes  without controllers , which are scanned in the WebConFig file
		//Scan all components, but dont scan (i.e. filter out) the classes that are annotated as @Controllers. This is scanned separatelly in WebConfig
@ComponentScan(value = {"group14.app"}, excludeFilters = {@ComponentScan.Filter(Controller.class)})
@Import({AppProperties.class} )
public class RootConfig {

}