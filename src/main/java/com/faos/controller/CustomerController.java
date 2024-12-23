package com.faos.controller;

import com.faos.model.Customer;
import com.faos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String home() {
		return "redirect:/register";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "register";
	}

	@PostMapping("/register")
	public String registerCustomer(@ModelAttribute Customer customer) {
		customerService.registerCustomer(customer);
		return "redirect:/register?success";
	}
}