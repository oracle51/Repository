package com.necares.liutl.mybatis.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.necares.liutl.mybatis.inter.IUserOperation;
import com.necares.liutl.mybatis.model.Article;
import com.necares.liutl.mybatis.model.User;

public class MybatisSpringTest {

	private static ApplicationContext ctx;

	static {
		ctx = new ClassPathXmlApplicationContext(
				"config/applicationContext.xml");
	}

	public static void main(String[] args) {
		IUserOperation mapper = (IUserOperation) ctx
				.getBean("userMapper");
		
		User user=mapper.selectUserByID(2);
		
		System.out.println(user.getUserAddress());
		
		
		List<Article> articles=mapper.getUserArticles(2);
		
		for (Article article : articles) {
			System.out.println(article.getTitle()+"--"+article.getContent());
		}
	}

}
