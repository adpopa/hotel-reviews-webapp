/**
 * MainInitialiser.java
 */
package group14.app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import group14.app.config.RootConfig;

/**
 * @author Alex Daniel Popa
 *
 */
public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer { //implements WebApplicationInitializer {

	// ROOT
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	// Map all requests ("/") to Spring via the DispacherServlet
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
