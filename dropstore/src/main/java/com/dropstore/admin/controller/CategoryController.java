package com.dropstore.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dropstore.dao.CategoryDAO;
import com.dropstore.entity.Category;

@Controller
public class CategoryController {
	@Autowired	
	CategoryDAO cdao;
	@RequestMapping("admin/category/index")
	public String index(Model model) {
		Category entity = new Category();
		model.addAttribute("entity",entity);
		model.addAttribute("list",cdao.findAll());
	    System.out.println("## chay index admin" );

		//model.addAttribute("message1","true");
		return "admin/category/index";
	}
	@RequestMapping("admin/category/edit/{id}")
	public String edit(Model model,@PathVariable("id") Integer id) {
		
		Category entity=cdao.findByID(id);
		model.addAttribute("list",cdao.findAll()); 
		model.addAttribute("entity",entity);
		//model.addAttribute("message1","true");
		
	    System.out.println("## chay edit admin" );
	    if (entity.getId()!=null)  System.out.println("entity edit: "+entity.getId());
		return "admin/category/index";
	}
	@RequestMapping("admin/category/create")
	public String create(RedirectAttributes model,@ModelAttribute("entity") Category entity) {
	    System.out.println("## chay index" );
	    cdao.create(entity);
		
		//model.addAttribute("message1","false");
	    model.addAttribute("message","Thêm mới thành công");
	    
		return "redirect:/admin/category/index";
	}
	@RequestMapping("admin/category/update")
	public String update(RedirectAttributes model,@ModelAttribute("entity") Category entity) {
	    cdao.update(entity);
	    model.addAttribute("message","Cập nhập thành công");
	  	return "redirect:/admin/category/edit/"+entity.getId();
	}
	@RequestMapping(value ={"/admin/category/delete","/admin/category/delete/{id2}"})//,RedirectAttributes model,
	//public String delete(@RequestParam(value ="id" ,required = false) Integer id1,
	//					 @PathVariable(value ="id2",required = false) Integer id2) {
		
	public String delete(@ModelAttribute(value ="entity") Category entity,
				 @PathVariable(value ="id2",required = false) Integer id2,
				 RedirectAttributes model) {	
		Integer id=(entity.getId()!=null)?entity.getId():id2;
		cdao.delete(id);
	    model.addAttribute("message","Xoá thành công");
		return "redirect:/admin/category/index";
	}
	
	
	
}
