package sc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import sc.constants.Const;

/**
 * Spring web and servlet initialization
 * The app an be deployed either in Tomcat web container
 * or in JBoss EE application container
 * 
 * @author marina
 *
 */
public class ShopCartInit implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(ShopCartConfig.class);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet(
				"dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		if (Const.DEPLOY_TOMCAT) {
			servlet.addMapping("/");
		} else {
			servlet.addMapping("/*"); // jboss eap
		}
	}

}
