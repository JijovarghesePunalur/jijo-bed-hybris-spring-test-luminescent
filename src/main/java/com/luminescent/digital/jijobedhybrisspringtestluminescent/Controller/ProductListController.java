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
public class ProductListController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/product/list")
	public String home(Model model, HttpSession session	) {
		Iterable<Product> item =  productService.getProducts();
		model.addAttribute("products", item);
		
		setCurrency("EUR", item, session);
		return "productlist";
	}
	
	@RequestMapping("/product/list/getCurrency/{key}")
	public String changeSession(@PathVariable("key")String key, Model model, HttpSession session) {
		Iterable<Product> items =  productService.getProducts();
		model.addAttribute("products", items);
		setCurrency(key, items, session);
		return "productlist";
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
