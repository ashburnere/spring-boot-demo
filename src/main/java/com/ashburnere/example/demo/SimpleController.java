package com.ashburnere.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Next, we'll define a simple controller and a basic home page – with a welcome message:
 *
 */
@Controller
public class SimpleController {
	// note how we used a property we defined in our properties – and then injected that so that we can show it on our home page.
    @Value("${spring.application.name}")
    String appName;
 
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}
