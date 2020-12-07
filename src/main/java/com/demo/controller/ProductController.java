package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.bean.Product;
import com.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/viewproduct")
	public ModelAndView DisplayProduct()
	{
		List<Product> plist=productService.getallProduct();
		return new ModelAndView("displayProduct", "plist",plist);
	}
	
	@RequestMapping("/editproduct/{id}")
	public ModelAndView updateProduct(@PathVariable("id") int pid)
	{
		Product p=productService.getProductById(pid);
		return new ModelAndView("editProduct","prod",p);
	}
	
	@RequestMapping(value="/updateproduct",method=RequestMethod.POST)
	public ModelAndView updateProduct(@RequestParam("pid") int pid,@RequestParam("pname") String pname,@RequestParam("price") double price)
	{
		Product p=new Product(pid,pname,price);
		productService.updateProduct(p);
		
		return new ModelAndView("redirect:/viewproduct");
		
		
	}
	@RequestMapping(value="/deleteproduct/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") int pid)
	{
			productService.deletebyId(pid);
		return new ModelAndView("redirect:/viewproduct");
	}
	@RequestMapping("/showform")
	public ModelAndView showform() 
	{
		return new ModelAndView("addProduct");
	}
	
	@RequestMapping(value="/addproduct")
	public ModelAndView addproduct(@RequestParam("pid")int pid,@RequestParam("pname")String pname,@RequestParam("price") double price)
	{
		int p=productService.addproduct(pid,pname,price);
		return new ModelAndView("redirect:/viewproduct");
		
	}
	
}
