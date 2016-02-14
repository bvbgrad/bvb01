package org.ll4.test.bvb01.configuration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class bvb01Initializer extends 
	AbstractAnnotationConfigDispatcherServletInitializer {
	private static final Logger logger = LogManager.getLogger();
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
		logger.info("Initializing configuration classes");
        return new Class[] { bvb01Configuration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
}
