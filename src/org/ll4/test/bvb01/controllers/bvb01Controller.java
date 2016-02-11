package org.ll4.test.bvb01.controllers;

import java.text.DateFormat;
import java.util.Date;
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
		logger.info("sayHello {}", locale);

    	String sGreet = "Hello from bvb01. The client locale is '" + locale.toString() + "'";
        model.addAttribute("greeting", sGreet);
        
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		logger.info("sayHello: {}", sGreet);

        return "welcome";
    }
 
    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
    	logger.info("sayHelloAgain");
    	
        model.addAttribute("greeting", "Hello from bvb01 Again, from Spring 4 MVC");
        return "welcome";
    }
 
}
