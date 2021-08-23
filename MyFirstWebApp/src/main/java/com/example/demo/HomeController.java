package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
@RequestMapping("home")
public ModelAndView home(Alien alien) {
//	HttpSession session=req.getSession();
//	String name=req.getParameter("name");
//	System.out.println("hey" +name);
//	session.setAttribute("name", name);
//	return "home";
	
	//When using ModelAndView ,we can avoid using HttpServlet and session objects
	ModelAndView mv=new ModelAndView();
	mv.addObject("obj",alien);
	mv.setViewName("home");
	return mv;
}

}
