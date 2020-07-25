package com.dropstore.admin.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dropstore.dao.CustomerDAO;
import com.dropstore.entity.Customer;

@Controller
public class AdminCustomerController {
	@Autowired	
	CustomerDAO cdao;
	@Autowired
	ServletContext app;
	@RequestMapping("admin/customer/index")
	public String index(Model model) {
		Customer entity = new Customer();
		model.addAttribute("entity",entity);
		model.addAttribute("list",cdao.findAll());
	    System.out.println("## chay index admin" );
	    
		//model.addAttribute("message1","true");
		return "admin/customer/index";
	}
	@RequestMapping("admin/customer/edit/{id}")
	public String edit(Model model,@PathVariable("id") String id) {
		
		Customer entity=cdao.findByID(id);
		model.addAttribute("list",cdao.findAll()); 
		model.addAttribute("entity",entity);
		//model.addAttribute("message1","true");
		
	    System.out.println("## chay edit admin" );
		return "admin/customer/index";
	}
	@RequestMapping("admin/customer/create")
	public String create(RedirectAttributes model,
						@ModelAttribute("entity") Customer entity,
						@RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
		if(file.isEmpty()) {
			entity.setPhoto("/static/customeravatar/yellow.jpg");
							}
		else {
			
			//entity.setImage(file.getOriginalFilename());
			String path =app.getRealPath("/static/customer_avatar/"+file.getOriginalFilename());
		
			System.out.println("duong dan moi: "+path);
			file.transferTo(new File(path));
			entity.setPhoto("/static/customeravatar/"+file.getOriginalFilename());
			
			}
	    cdao.create(entity);
		
		//model.addAttribute("message1","false");
	    model.addAttribute("message","Thêm mới thành công");
	    
		return "redirect:/admin/customer/index";
	}
	@RequestMapping("admin/customer/update")
	public String update(RedirectAttributes model,@ModelAttribute("entity") Customer entity,
			@RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
		
		if(!file.isEmpty()) {
			//String path =app.getRealPath("/static/anh/"+file.getOriginalFilename());
			String path =app.getRealPath("/static/customeravatar/"+entity.getId()+".jpg");
			System.out.println("duong dan moi: "+path);
			file.transferTo(new File(path));
			entity.setPhoto("/static/customeravatar/"+entity.getId()+".jpg");
			//entity.setImage("/static/anh/"+file.getOriginalFilename());
							}
		
		
	    cdao.update(entity);
	    model.addAttribute("message","Cập nhập thành công");
	  	return "redirect:/admin/customer/edit/"+entity.getId();
	}
	@RequestMapping(value ={"/admin/customer/delete","/admin/customer/delete/{id2}"})//,RedirectAttributes model,
	//public String delete(@RequestParam(value ="id" ,required = false) Integer id1,
	//					 @PathVariable(value ="id2",required = false) Integer id2) {
		
	public String delete(@ModelAttribute(value ="entity") Customer entity,
				 @PathVariable(value ="id2",required = false) String id2,
				 RedirectAttributes model) {	
		String id=(entity.getId()!=null)?entity.getId():id2;
		cdao.delete(id);
	    model.addAttribute("message","Xoá thành công");
		return "redirect:/admin/customer/index";
	}
	@RequestMapping("admin/customer/list-by-keywords")
	public String listBykeywords(Model model,@RequestParam("keywords") String keywords ) {
	   
		List<Customer> list = cdao.findByKeywords(keywords);
	
	   model.addAttribute("list", list);
	  
	   return "admin/customer/_table2";
	}
	
	
	
}
