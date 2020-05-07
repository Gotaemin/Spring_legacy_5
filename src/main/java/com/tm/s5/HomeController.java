package com.tm.s5;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.s5.transfer.Transfer;

@Controller
public class HomeController {
	
	@Autowired
	private Transfer transfer;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		transfer.bus(1000);
		
		transfer.subway(2000,"2호선");
		
		transfer.texi();
		
		return "index";
	}
	
}
