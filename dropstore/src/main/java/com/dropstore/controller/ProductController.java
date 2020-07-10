package com.dropstore.controller;

import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.dropstore.dao.CategoryDAO;
import com.dropstore.dao.ProductDAO;
//import com.dropstore.entity.Category;
import com.dropstore.entity.Product;
import com.dropstore.service.CookieService;
@Controller
public class ProductController {
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	CookieService cookie;
	
	@RequestMapping("/product/list-by-category/{cid}")
	public String listByCategory(Model model,@PathVariable("cid") Integer categoryId ) {
	    System.out.println("## chay list san pham="+ categoryId ); 
	    List<Product> list = pdao.findByCategoryId(categoryId);
	   // model.addAllAttribute ("list",list);
	   model.addAttribute("list", list);
	    return "product/list";
	}
	///product/detail/1002
	@RequestMapping("/product/list-by-keywords")
	public String listBykeywords(Model model,@RequestParam("keywords") String keywords ) {
	    System.out.println("## chay list san pham="+ keywords ); 
	    List<Product> list = pdao.findByKeywords(keywords);
	   // model.addAllAttribute ("list",list);
	   model.addAttribute("list", list);
	    return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id ) {
	    System.out.println("## chay list san pham="+ id ); 
	    Product prod = pdao.findByID(id);
	    model.addAttribute("prod", prod);
	    //set viewcount
	    prod.setViewCount(prod.getViewCount()+1);
	    pdao.update(prod);
	    //set hàng cùng loại
	    List<Product> list = pdao.findByCategoryId(prod.getCategory().getId());
	    model.addAttribute("list", list);
	   
	   // set hàng yêu thích
	   Cookie favo=cookie.read("favo");
	   if(favo!=null) {
		   String ids =favo.getValue();
		   List<Product> favo_list = pdao.findByIds(ids);
		   model.addAttribute("favo", favo_list);
		  
		   
	   					} 
	   //set hàng đã xem
	   Cookie viewed= cookie.read("viewed");
	   String value= id.toString();
	   if(viewed!=null) {
		   value=viewed.getValue();
		   if (!value.contains(id.toString()) )
		   value +=","+id.toString(); 
	   }
	    cookie.create("viewed",value,10);
	    List<Product> viewed_list = pdao.findByIds(value);
		model.addAttribute("viewed", viewed_list);
	   
	    return "product/detail";
	}
	@ResponseBody
	@RequestMapping("/product/add-to-favo/{id}")
	public boolean addToIds(Model model,@PathVariable("id") Integer id ) {
	    System.out.println("## add san pham vao fav ="+ id ); 

	    Cookie favo= cookie.read("favo");
	    String value =id.toString();
	    if (favo!=null) {
	    	 value= favo.getValue();
	    	if(!value.contains(id.toString())) {
	    		value +=","+id.toString();
//test
	    		
	  		
	    		}
		    									
	    else return false;
	    
	    
	}	cookie.create("favo", value, 30);
		
//code demo	
		System.out.println("check tai value:"+value);
		if(favo!=null) System.out.println("check tai product "+favo.getValue());
		
	    return true;
//code demo1111
}
	@RequestMapping("/product/list-by-special/{id}")
	public String listBySpecial(Model model,@PathVariable("id") Integer id ) {
	    System.out.println("## chay list san pham="+ id ); 
	    List<Product> list = pdao.findBySpecial(id);
	   // model.addAllAttribute ("list",list);
	   model.addAttribute("list", list);
	    return "product/list";
	}

}
