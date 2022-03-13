package com.luminescent.digital.jijobedhybrisspringtestluminescent.Controller;

import java.util.Currency;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luminescent.digital.jijobedhybrisspringtestluminescent.model.Product;
import com.luminescent.digital.jijobedhybrisspringtestluminescent.service.ProductService;

@Controller
public class ProductListEditController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/product/list/edit")
	public String edit(Model model, HttpSession session	) {
		Iterable<Product> items =  productService.getProducts();
		model.addAttribute("products", items);
		setCurrency("EUR", items, session);
		
		return "productlistedit";
	}
	
	@RequestMapping("/product/list/edit/{key}")
	public String changeSession(@PathVariable("key")String key, Model model, HttpSession session) {
		Iterable<Product> items =  productService.getProducts();
		model.addAttribute("products", items);
		setCurrency(key, items, session);
		return "productlistedit";
	}
	
	@RequestMapping("/product/list/edit/submit")
	public String submit(Model model, HttpSession session	) {
		Iterable<Product> items =  productService.getProducts();
		model.addAttribute("products", items);
		setCurrency("EUR", items, session);
		
		return "productlistedit";
	}
	
	
	private void setCurrency(String currency, Iterable<Product> item, HttpSession session	) {
		session.setAttribute("currency", currency);
		Iterator<Product> iter = item.iterator();
		while(iter.hasNext()) {
			Product pdt = iter.next();
			session.setAttribute("currency"+pdt.getId(), pdt.getPrices().get(Currency.getInstance(currency)).getAmount());
		}
	}
}
