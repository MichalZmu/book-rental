package com.luv2code.bookrental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.bookrental.entity.Book;
import com.luv2code.bookrental.entity.Client;
import com.luv2code.bookrental.service.BookAndClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private BookAndClientService bookService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String showHomePage() {
		
		return "home-page";
	}
	
	@GetMapping("/list-clients")
	public String listClients(Model theModel) {
		
		List<Client> theClients = bookService.getClients();
		
		theModel.addAttribute("clients", theClients);
		
		return "list-clients";
	}
	
	@RequestMapping("/showFormForAddClient")
	public String showFormForAddClient(Model theModel) {
		
		Client theClient = new Client();
		
		theModel.addAttribute("client", theClient);
		
		return "client-form";
	}
		
	@PostMapping("/saveClient")
	public String saveClient(@Valid @ModelAttribute("client") Client theClient, BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors())
		{
			return "client-form";
		}
		else {
			bookService.saveClient(theClient);
			return "redirect:/client/list-clients";
		}
		
	}
	

	@GetMapping("/showFormForUpdateClient")
	public String showFormForUpdateClient(@RequestParam("clientId") int theId, Model theModel) {
		
		Client theClient = bookService.getClient(theId);
		
		theModel.addAttribute("client", theClient);
		
		return "client-form";
	}
	
	
	@GetMapping("/deleteClient")
	public String deleteClient(@RequestParam("clientId") int theId) {
		
		bookService.deleteClient(theId);
		
		return "redirect:/client/list-clients";
	}
}
