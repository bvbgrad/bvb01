package org.ll4.test.bvb01.controllers;

import java.sql.SQLException;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class bvb01Controller {
	private static final Logger logger = LogManager.getLogger();

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(Locale locale, ModelMap model) {

    	String sGreet = "Hello from bvb01. Client locale = '" + locale.toString() + "'";
    	logger.info("sayHello: {}", sGreet);

    	model.addAttribute("greeting", sGreet);

        return "welcome";
    }
 
    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
    	logger.info("sayHelloAgain");
    	
        model.addAttribute("greeting", "Hello again, from Spring 4 MVC");
        return "welcome";
    }
    
    @RequestMapping(value = "/null")
    public void nullPointerError() {
    	throw new NullPointerException();
    }
 
    @RequestMapping(value = "/sql")
    public void dataError() throws SQLException {
    	throw new SQLException();
    }
    
}
