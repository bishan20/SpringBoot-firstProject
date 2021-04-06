package com.example.FirstProject.contollers;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.FirstProject.dao.UserRepository;


@Controller
public class ShoppingListController {
	
	@GetMapping("/index")
	public String name()
	{
		return "login";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
		@PostMapping("/logincheck")
	public String loginCheck (HttpServletRequest req,Model model)
	{
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		
		if(name.equals("ram") && pass.equals("ram")) {
			List<Student> lst=new ArrayList<Student>();
			Student st= new Student();
			st.setName("Ram Thapa");
			st.setRoll("100");
			st.setEmail("ram@gmail.com");
            lst.add(st);
			
			Student st1=new Student();
			st1.setName("Hari Thapa");
			st1.setRoll("200");
			st1.setEmail("Hari@gmail.com");
            lst.add(st1);
			model.addAttribute("DATA",lst);
			return "home";
		} else {
			return "login";
		}
		
	}
		@Autowired
		private UserRepository userRepository;

	@GetMapping("/adduser")
	public String adduser()
	{
		return "adduser";
	}

		@PostMapping("/adduserdb")
		public String addUserdb(HttpServletRequest req,Model model) {
		User u=new User();
		u.setName(req.getParameter("name"));
		u.setEmail(req.getParameter("email"));
		userRepository.save(u);
		System.out.println("Data base updated...");
		return "adduser";
		}
		
		@GetMapping("/getuser")
		public String getUser(HttpServletRequest req,Model model) {
		User user=userRepository.findById(Integer.parseInt(req.getParameter("id"))).get();
		model.addAttribute("USER",user);
		return "showuser";
		}
		
		@GetMapping("/users")
		public String getUsers(HttpServletRequest req,Model model) {
		Iterable<User> users=userRepository.findAll();
		model.addAttribute("USERS",users);
		return "viewusers";
		}
		
		@GetMapping("/getusername")
		public String getUserName(HttpServletRequest req,Model model) {
		User user=userRepository.findByName(req.getParameter("name"));
		model.addAttribute("USER",user);
		return "showusername";
		}



}
