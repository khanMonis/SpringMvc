package springmvc.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.management.monitor.MonitorSettingException;

import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.http.server.reactive.AbstractListenerWriteFlushProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class HomeController {

	@RequestMapping(path="/home",method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("this is home url");

		model.addAttribute("name", "Talha Siddiqui");
		model.addAttribute("id", 101);

		List<String> friends = new ArrayList<String>();
		friends.add("Rohit");
		friends.add("Nikhil");
		friends.add("Rishi");
		model.addAttribute("f", friends);

		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		System.out.println("this is about controller ");
		return "about";
	}

	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("this is help controller");

		/* creating model & view object */
		ModelAndView modelAndView = new ModelAndView();

		// setting the data
		modelAndView.addObject("name", "Talha Khan");
		modelAndView.addObject("rollno", 1001);
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("time", now);

		// marks
		List<Integer> list = new ArrayList<Integer>();
		list.add(121);
		list.add(122);
		list.add(123);
		list.add(1234);
		list.add(12345);

		modelAndView.addObject("marks", list);

		// setting the view name
		modelAndView.setViewName("help");

		return modelAndView;
	}
}
