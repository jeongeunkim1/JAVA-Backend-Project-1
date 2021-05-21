  
package com.avengers.user.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.avengers.user.dto.Product;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.ProductService;

@Controller
public class ProductInsertController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/product_insert_page")
	public String product_insert(Model model, HttpSession session) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String time=simpleDateFormat.format(date);
		if (session.getAttribute("user")==null || session.getAttribute("user")=="") {
			return "main";
		}
		UserInfo userInfo=(UserInfo)session.getAttribute("user");
		String user_name=userInfo.getUser_name();
		
		model.addAttribute("user_name", user_name);
		model.addAttribute("time", time);
		
		return "product_insert"; 
	}
	
	@ResponseBody
	@RequestMapping(value="/product_insert_ajax" , produces = "text/plain; charset=utf-8")
	public String product_insert_ajax(
			@ModelAttribute Product product,
			@RequestParam(value="category") String category,
			@RequestParam(value="menCategory") String menCategory,
			@RequestParam(value="womenCategory") String womenCategory,
			@RequestParam(value="fileSelect") MultipartFile file) throws Exception {
			String SAVE_PATH="C:/JAVA_BACKEND/spring_project/final-project-team1-avengers/src/main/webapp/images/productImage/";
			List<Product> productList = productService.findProductsAll();
			
			//파일 이름 저장
			String fileName = file.getOriginalFilename();
			String safeFile = SAVE_PATH+fileName;
			
			file.transferTo(new File(safeFile));
			
			int count=0;
			for (Product product2 : productList) {
				if(product.getProduct_name().equals(product2.getProduct_name())) {
					count=1;
				}
			}
			if ( count == 0 ) {
				String product_category="";
				if (category.equals("남성")) {
					product_category=category + menCategory;
				}
				if (category.equals("여성")) {
					product_category=category + womenCategory;
				}
				product.setProduct_no(0);
				product.setProduct_image(fileName);
				product.setProduct_category(product_category);
				productService.insertProduct(product);
			}
		
		return String.valueOf(count);			
	}
	
}