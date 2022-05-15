package springmvc.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	@RequestMapping("/contact")
	public String showForm() {
		return "contact";
	}

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(
			@RequestParam(name="email", required = false) String userEmail, 
			@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword,Model model)
	{
		System.out.println("user email" + userEmail);
		System.out.println("user Name" + userName);
		System.out.println("user Password" + userPassword);

		//process
		model.addAttribute("name",userName);
		model.addAttribute("email",userEmail);
		model.addAttribute("password",userPassword);
		return "success ";
	}
}
