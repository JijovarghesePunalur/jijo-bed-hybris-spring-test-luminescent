package com.luminescent.digital.jijobedhybrisspringtestluminescent.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("exampleAttribute", "Luminescent Digital");
		return "home";
	}

}

