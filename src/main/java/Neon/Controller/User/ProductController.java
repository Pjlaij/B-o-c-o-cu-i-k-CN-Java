package Neon.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import Neon.Service.User.iProductsService;


@Controller
public class ProductController{
	
	@Autowired
	private iProductsService productService;
	
	@RequestMapping(value={"/chi-tiet-san-pham/{id}"}	)
	public ModelAndView Index(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/products/product");
		mv.addObject("product",productService.GetProductByID(id));
		return mv;
}
}
