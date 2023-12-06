package Neon.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Neon.DTO.CartDTO;
import Neon.Entity.Bills;
import Neon.Entity.Users;
import Neon.Service.User.BillsServiceImpl;
import Neon.Service.User.CartServiceImpl;
import Neon.Service.User.HomeImpl;
import Neon.Service.User.iHome;

@Controller
public class CartController {
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private HomeImpl iHome;
	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
	
	@RequestMapping(value = "gio-hang")
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("slides", iHome.GetDataSlide());
		mv.addObject("categorys", iHome.GetDataCategory());
		mv.addObject("products", iHome.GetDataProduct(false,false));
		mv.setViewName("user/cart/list_cart");
		return mv;
	}	
	
@RequestMapping(value="AddCart/{id}")
public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable int id) {
		HashMap<Integer,CartDTO> cart = (HashMap<Integer,CartDTO>)session.getAttribute("Cart");
		
		if (cart == null)
			cart = new HashMap<Integer,CartDTO>();
		
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
@RequestMapping(value = "EditCart/{id}/{quanty}")
public String EditCart(HttpServletRequest request ,HttpSession session, @PathVariable Integer id, @PathVariable Integer quanty) {
	HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>)session.getAttribute("Cart");
	if(cart == null) {
		cart = new HashMap<Integer, CartDTO>();
	}
	cart = cartService.EditCart(id, quanty, cart);
	session.setAttribute("Cart", cart);
	session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
	session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
	return "redirect:"+request.getHeader("Referer");
}


@RequestMapping(value = "DeleteCart/{id}")
public String DeleteCart(HttpServletRequest request ,HttpSession session, @PathVariable Integer id) {
	HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>)session.getAttribute("Cart");
	if(cart == null) {
		cart = new HashMap<Integer, CartDTO>();
	}
	cart = cartService.DeleteCart(id, cart);
	session.setAttribute("Cart", cart);
	session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
	session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
	return "redirect:"+request.getHeader("Referer");
}
@RequestMapping(value = "checkout", method = RequestMethod.GET)
public ModelAndView CheckOut(HttpServletRequest request ,HttpSession session) {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("user/bills/checkout");
	Bills bills = new Bills();
	Users loginInfo = (Users)session.getAttribute("LoginInfo");
	if (loginInfo!=null) {
		bills.setAddress(loginInfo.getAddress());
		bills.setDisplay_name(loginInfo.getDisplay_name());
		bills.setUser(loginInfo.getUser());
	}
	mv.addObject("bills",bills);
	return mv;
}
@RequestMapping(value = "checkout", method = RequestMethod.POST)
public String CheckOutBill(HttpServletRequest request ,HttpSession session, @ModelAttribute("bills") Bills bill) {
	bill.setQuanty((Integer.parseInt((String)session.getAttribute("TotalQuantyCart"))));
	bill.setTotal((Double.parseDouble((String)session.getAttribute("TotalPriceCart"))));
	if (billsService.AddBills(bill) > 0) {
		HashMap<Long, CartDTO> carts = (HashMap<Long,CartDTO>)session.getAttribute("Cart");
		billsService.AddBillsDetail(carts);
	}
	session.removeAttribute("Cart");
	session.removeAttribute("TotalPriceCart");
	session.removeAttribute("TotalQuantyCart");
	return "redirect:gio-hang";
}
}
