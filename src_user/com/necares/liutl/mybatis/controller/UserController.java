package com.necares.liutl.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.necares.liutl.mybatis.inter.IUserOperation;
import com.necares.liutl.mybatis.model.Article;

@Controller
@RequestMapping("/article")
public class UserController {

	@Autowired
	IUserOperation userMapper;

	public ModelAndView listAll(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Article> articles = userMapper.getUserArticles(2);
		ModelAndView mav = new ModelAndView("list");

		mav.addObject("articles", articles);
		return mav;
	}

}
