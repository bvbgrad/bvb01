package org.ll4.test.bvb01.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvice {
	private static final Logger logger = LogManager.getLogger();
	
	@ModelAttribute("currentDate")
	public String getCurrentDate(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		return formattedDate;
	}
	
	@ExceptionHandler(Exception.class)
	public String handleNullPointerError(HttpServletRequest req, Model model, Exception e) {
		
		logger.error("Exception error: full stack trace follows:", e );
		
		model.addAttribute("sErrorMsg", e.toString());
		model.addAttribute("url", req.getRequestURL().toString());
		return "errorView";
	}

}
