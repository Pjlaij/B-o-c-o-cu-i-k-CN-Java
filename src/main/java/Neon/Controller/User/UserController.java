package Neon.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Neon.Entity.Users;
import Neon.Service.User.AccountServiceImpl;

@Controller
public class UserController{
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView("user/account/register");
		mv.addObject("user", new Users());
		return mv;

	}
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAccount(@ModelAttribute("user") Users user) {
		ModelAndView mv = new ModelAndView("user/account/register");
		Users user_check = accountService.CheckAccount(user);
		if (user_check==null) {
			int count = accountService.AddAccount(user);
			if (count>0) {
				mv.addObject("status","Đăng ký tài khoản thành công");
			}
			else {
				mv.addObject("status","Đăng ký tài khoản thất bại");
			}
		}
		else {
			mv.addObject("status","Đã tồn tại tài khoản trong hệ thống!");
		}
		return mv;

	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") Users user) {
		ModelAndView mv = new ModelAndView("user/account/register");
		user = accountService.CheckAccount(user);
		if (user!=null) {
			session.setAttribute("LoginInfo",user);
			mv.setViewName("redirect:/");
		}
		else {
			mv.addObject("statusLogin","Đăng nhập thất bại");
		}
		return mv;
	}
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:"+request.getHeader("Referer");
	}
	
}
