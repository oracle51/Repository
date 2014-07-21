package com.necares.liutl.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.necares.liutl.mybatis.inter.IUserOperation;
import com.necares.liutl.mybatis.model.Article;

public class GetUserArticles {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("config/Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void getUserArticle(int userid) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			IUserOperation userOperaton=session.getMapper(IUserOperation.class);
			List<Article> articles=userOperaton.getUserArticles(userid);
			
			for (Article article : articles) {
				System.out.println(article.getTitle()+":"+article.getContent()+":作者是"+article.getUser().getUserName()+":地址："+article.getUser().getUserAddress());
			}
		}

		finally{
			session.close();
		}
	}

	public static void main(String[] args) {
		
		getUserArticle(2);

	}

}
