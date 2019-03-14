package com.bookrental.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bookrental.entity.Book;
import com.bookrental.entity.Client;
import com.bookrental.service.BookAndClientService;

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
	
	@ControllerAdvice
	class GlobalDefaultExceptionHandler {
	  public static final String DEFAULT_ERROR_VIEW = "error";

	  @ExceptionHandler(value = Exception.class)
	  public String
	  defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	    // If the exception is annotated with @ResponseStatus rethrow it and let
	    // the framework handle it - like the OrderNotFoundException example
	    // at the start of this post.
	    // AnnotationUtils is a Spring Framework utility class.
	    if (AnnotationUtils.findAnnotation
	                (e.getClass(), ResponseStatus.class) != null)
	      throw e;

	    // Otherwise setup and send the user to a default error-view.
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", e);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName(DEFAULT_ERROR_VIEW);
	    return "home-page";
	  }
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
		
		try {
			bookService.deleteClient(theId);
		}
		catch (Exception e) {
			
		}
		
				
		return "redirect:/client/list-clients";
	}
}
