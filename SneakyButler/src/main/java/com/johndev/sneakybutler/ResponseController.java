package com.johndev.sneakybutler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.johndev.sneakybutler.shells.Shell;

@Controller
public class ResponseController {
	
	@Autowired
	private Shell shell;

	@RequestMapping(value = "/response", method = RequestMethod.GET)
	public String response(Locale locale, Model model){
		
		String output = shell.executeCommand("nslookup www.google.com");
		
		model.addAttribute(output, output);
		
		return "response";
	}
	
}
