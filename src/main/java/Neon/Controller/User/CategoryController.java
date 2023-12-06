package Neon.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Neon.DTO.PaginatesDTO;
import Neon.Service.User.CategoryServiceImpl;
import Neon.Service.User.PaginateServiceImpl;
@Controller
public class CategoryController {
	@Autowired
	private CategoryServiceImpl cateService;
	@Autowired
	private PaginateServiceImpl pagiService;
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		ModelAndView mv = new ModelAndView("user/products/category");
		mv.addObject("AllProductsByID", cateService.GetAllDataProductsByID(Integer.parseInt(id)));
		return mv;
	}
	
}