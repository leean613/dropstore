package com.dropstore.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dropstore.dao.CustomerDAO;
import com.dropstore.entity.Customer;
import com.dropstore.service.CookieService;
@Controller
public class AccountController {
	@Autowired
	CustomerDAO cdao;
	@Autowired
	HttpSession session;
	@Autowired
	CookieService cookie;
	@Autowired
	ServletContext app;
	
	
	@RequestMapping("/account/logoff")
	public String logoff(Model model) {
		session.removeAttribute("user");
		return "redirect:/home/index";
	}
	
	@PostMapping("/account/register")
	public String register(Model model,
			@ModelAttribute("form") Customer user,
			@RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
		if(file.isEmpty()) {
			user.setPhoto("user.jpg");
			
		}
		else {
		String dir=app.getRealPath("/static/images_customer");
		File f= new File(dir, file.getOriginalFilename());
		file.transferTo(f);
		user.setPhoto(f.getName());
		}
		user.setActivated(true);
		user.setAdmin(false);
		cdao.create(user);
		model.addAttribute("message","Register successfully!");
		return "account/register";
	}
	@GetMapping("/account/register")
	public String register(Model model) {
		Customer user=new Customer();
		model.addAttribute("form",user);
		return "account/register";
	}
	@GetMapping("/account/change")
	public String change(Model model) {
		Customer  user=new Customer();
		model.addAttribute("form",user);
		return "account/change";
	}
	@PostMapping("/account/change")
	public String change(Model model, 
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("pw1") String pw1,
			@RequestParam("pw2") String pw2
			) {
		if(!pw1.equals(pw2)) {
			model.addAttribute("message","Passwords not match!!");
		}	
		else {

			Customer user=cdao.findByID(id);
			if(user==null) {
				model.addAttribute("message","Invalid username");
			}
			else if(!pw.equals(user.getPassword())) {
				model.addAttribute("message","Invalid password");
			}
			else {
				user.setPassword(pw1);
				cdao.update(user);
				model.addAttribute("message","Changed password successfully!!");
				
			}
				
			
		}	
						
			
		return "account/change";
	}
	
 
	
	
	@GetMapping("/account/login")
	public String login(Model model) {
		Cookie ckid=cookie.read("userid");
		Cookie ckpw=cookie.read("pass");
		if(ckid!=null) {
			String uid=ckid.getValue();

			String pwd=ckpw.getValue();
			model.addAttribute("uid",uid);
			model.addAttribute("pwd",pwd);
		}
		return "account/login";
	}
	@PostMapping("/account/login")
	public String login(Model model,
						@RequestParam("id") String id,
						@RequestParam("pw") String pw,
	 					@RequestParam(value = "rm",defaultValue = "false") Boolean rm) {
	 
		Customer user =cdao.findByID(id);
	//	System.out.println("id la= "+id );
		if(user==null) { 
			model.addAttribute("message","Invaid username ");
		
		}
		else if (!pw.equals(user.getPassword())){
			model.addAttribute("message","Invaid password");
		}
		else if (!user.getActivated()){
			model.addAttribute("message","Not activated");
		}
		else 
		{
			model.addAttribute("message","Login successfully!");
			session.setAttribute("user", user);
			//ghi nho tai khoan bang cookie
			if(rm==true) {
				cookie.create("userid", user.getId(), 30);

				cookie.create("pass", user.getPassword(), 30);
			}
			else {
				cookie.delete("userid");

				cookie.delete("pass");
			}
		}
		return "account/login";
		
	 
	}
}
