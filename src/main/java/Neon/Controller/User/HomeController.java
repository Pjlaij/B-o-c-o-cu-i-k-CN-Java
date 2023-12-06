package Neon.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Neon.Service.User.HomeImpl;

@Controller
public class HomeController {
	@Autowired
	HomeImpl homeService;
	@RequestMapping(value={"/","/trang-chu/"})
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView("user/index");
		mv.addObject("slides", homeService.GetDataSlide());
		mv.addObject("category", homeService.GetDataCategory());
		mv.addObject("new_products", homeService.GetDataProduct(true,false));
		mv.addObject("highlight_products", homeService.GetDataProduct(false,true));
		mv.setViewName("user/index");
		return mv;
}
	@RequestMapping(value="/product")
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/product");
		return mv;
}
}