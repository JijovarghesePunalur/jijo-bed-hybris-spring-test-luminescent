package com.luminescent.digital.jijobedhybrisspringtestluminescent.Controller;

import java.util.Currency;
import java.util.Iterator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luminescent.digital.jijobedhybrisspringtestluminescent.model.Price;
import com.luminescent.digital.jijobedhybrisspringtestluminescent.model.Product;
import com.luminescent.digital.jijobedhybrisspringtestluminescent.model.ProductBean;
import com.luminescent.digital.jijobedhybrisspringtestluminescent.service.ProductService;

@Controller
public class ProductListEditController {

	@Autowired
	ProductService productService;

	@RequestMapping("/product/list/edit")
	public String edit(Model model, HttpSession session) {
		Iterable<Product> items = productService.getProducts();
		model.addAttribute("products", items);
		setCurrency("EUR", items, session);

		return "productlistedit";
	}

	@RequestMapping("/product/list/edit/{key}")
	public String changeSession(@PathVariable("key") String key, Model model, HttpSession session) {
		Iterable<Product> items = productService.getProducts();
		model.addAttribute("products", items);
		setCurrency(key, items, session);
		return "productlistedit";
	}

	@RequestMapping("/product/list/edit/{id}/{key}")
	public String getProduct(@PathVariable("id") String id, @PathVariable("key") String key, Model model,
			HttpSession session) {
		Product item = productService.getProductForId(Long.parseLong(id));
		model.addAttribute("products", item);
		
		ProductBean productBean = new ProductBean();
		productBean.setProductname(item.getName());
		productBean.setId(item.getId());
		productBean.setPrice(item.getPrices().get(Currency.getInstance(key)).getAmount());
		
		model.addAttribute("productBean", productBean);
		
		setCurrency(key, item, session);
		return "productlistedit1";
	}

	@RequestMapping(value = "/product/list/edit/submit", method = RequestMethod.POST)
	public String submit(@Valid ProductBean productBean,  final BindingResult bindingResult, Model model, HttpSession session) {
		
		if(bindingResult.hasErrors()) {
			Product item = productService.getProductForId(productBean.getId());
			model.addAttribute("products", item);
			setCurrency(productBean.getCurrency(), item, session);
			return "productlistedit1";
		}else {
			
		
		Product product = productService.getProductForId(productBean.getId());
		product.setName(productBean.getProductname());
		
		Price price = product.getPrices().get(Currency.getInstance(productBean.getCurrency()));
		
		price.setAmount(productBean.getPrice());
		
		product.getPrices().put(Currency.getInstance(productBean.getCurrency()), price);
		
		productService.save(product);
		
		return "redirect:/product/list";
		}
	}

	private void setCurrency(String currency, Iterable<Product> item, HttpSession session) {
		session.setAttribute("currency", currency);
		Iterator<Product> iter = item.iterator();
		while (iter.hasNext()) {
			Product pdt = iter.next();
			session.setAttribute("currency" + pdt.getId(),
					pdt.getPrices().get(Currency.getInstance(currency)).getAmount());
		}
	}

	private void setCurrency(String currency, Product pdt, HttpSession session) {
		session.setAttribute("currency", currency);
		session.setAttribute("currency" + pdt.getId(), pdt.getPrices().get(Currency.getInstance(currency)).getAmount());
	}
}
