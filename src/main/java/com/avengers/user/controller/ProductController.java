package com.avengers.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avengers.user.dto.Product;
import com.avengers.user.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/product_info")
	public String product_info(@RequestParam("product_no") int product_no,@RequestParam("type") String type,Model model) {
		String findpath="main";
		
		try {
			model.addAttribute("products",productService.findProductCategory(type));
			model.addAttribute("product",productService.findByProductNo(product_no));
			findpath="product-info";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findpath; 
	}

	@RequestMapping(value ="/product_list")
	public String product_list(@RequestParam("type") String type,Model model,@RequestParam(value="pageno") String pageno) {
		String findpath="main";
		 if(pageno == null || pageno.equals("")) {
	         pageno = "1";
	      }
		try {
			//model.addAttribute("product",productService.findProductCategory(type));
			model.addAttribute("product",productService.findProductList(Integer.parseInt(pageno), type));
			model.addAttribute("type", type);
			model.addAttribute("count",productService.findAllCountByType(type));
			findpath="product-list";
		} catch (Exception e) {
			
		}
		return findpath;
	}
	
	@ResponseBody
	@RequestMapping(value = "/product_list_json", produces = "application/json;charset=UTF-8")
	public List<Product> product_list_json(@RequestParam("type") String type,@RequestParam("state") int state) throws Exception{
		if(state==0) {
			return productService.findByLowPrice(type);
		}else if(state==1) {
			return productService.findByHighPrice(type);
		}else if(state==2) {
			return productService.findNameAsc(type);
		}else if(state==3) {
			return productService.findNameDesc(type);
		}
		
		return productService.findByLowPrice(type);
	}
	
	@RequestMapping(value ="/product_search")
	public String product_search(@RequestParam(value = "search") String search,Model model,@RequestParam(value="pageno") String pageno) {
		String findpath="main";
		 if(pageno == null || pageno.equals("")) {
	         pageno = "1";
	      }
		try {
			model.addAttribute("product",productService.findProductByCategory(Integer.parseInt(pageno), search));
			model.addAttribute("search", search);
			model.addAttribute("serchCount",productService.findAllCountByType(search));
			findpath="product-search";
		} catch (Exception e) {
			
		}
		return findpath;

	}
}
