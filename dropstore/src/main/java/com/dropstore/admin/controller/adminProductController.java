package com.dropstore.admin.controller;


import java.io.File;
import java.io.IOException;

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

import com.dropstore.dao.ProductDAO;
import com.dropstore.entity.Product;

@Controller
public class adminProductController {
	@Autowired	
	ProductDAO pdao;
	@Autowired
	ServletContext app;
	@RequestMapping("admin/product/index")
	public String index(Model model) {
		Product entity = new Product();
		model.addAttribute("entity",entity);
		model.addAttribute("list",pdao.findAll());
	    System.out.println("## chay index admin" );
	    
		//model.addAttribute("message1","true");
		return "admin/product/index";
	}
	@RequestMapping("admin/product/edit/{id}")
	public String edit(Model model,@PathVariable("id") Integer id) {
		
		Product entity=pdao.findByID(id);
		model.addAttribute("list",pdao.findAll()); 
		model.addAttribute("entity",entity);
		//model.addAttribute("message1","true");
		
	    System.out.println("## chay edit admin" );
	    if (entity.getId()!=null)  System.out.println("entity edit: "+entity.getId());
		return "admin/product/index";
	}
	@RequestMapping("admin/product/create")
	public String create(RedirectAttributes model,
						@ModelAttribute("entity") Product entity,
						@RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
		if(file.isEmpty()) {
			entity.setImage("/static/anh/lights.jpg");
							}
		else {
			
			//entity.setImage(file.getOriginalFilename());
			String path =app.getRealPath("/static/anh/"+file.getOriginalFilename());
		
			System.out.println("duong dan moi: "+path);
			file.transferTo(new File(path));
			entity.setImage("/static/anh/"+file.getOriginalFilename());
			
			}
	    pdao.create(entity);
		
		//model.addAttribute("message1","false");
	    model.addAttribute("message","Thêm mới thành công");
	    
		return "redirect:/admin/product/index";
	}
	@RequestMapping("admin/product/update")
	public String update(RedirectAttributes model,@ModelAttribute("entity") Product entity,
			@RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
		
		if(!file.isEmpty()) {
			String path =app.getRealPath("/static/anh/"+file.getOriginalFilename());
			
			System.out.println("duong dan moi: "+path);
			file.transferTo(new File(path));
			entity.setImage("/static/anh/"+file.getOriginalFilename());
							}
		
		
	    pdao.update(entity);
	    model.addAttribute("message","Cập nhập thành công");
	  	return "redirect:/admin/product/edit/"+entity.getId();
	}
	@RequestMapping(value ={"/admin/product/delete","/admin/product/delete/{id2}"})//,RedirectAttributes model,
	//public String delete(@RequestParam(value ="id" ,required = false) Integer id1,
	//					 @PathVariable(value ="id2",required = false) Integer id2) {
		
	public String delete(@ModelAttribute(value ="entity") Product entity,
				 @PathVariable(value ="id2",required = false) Integer id2,
				 RedirectAttributes model) {	
		Integer id=(entity.getId()!=null)?entity.getId():id2;
		pdao.delete(id);
	    model.addAttribute("message","Xoá thành công");
		return "redirect:/admin/product/index";
	}
	
	
	
}
