package com.necares.liutl.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.necares.liutl.mybatis.inter.IUserOperation;
import com.necares.liutl.mybatis.model.User;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
//		 getOneUser();

//		getUserList("%");

		addUser();

		// updateUser();
		
//		deleteUser();
	}

	public static void deleteUser() {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);

			userOperation.deleteUser(1);

			session.commit();

		} finally {
			session.close();
		}
	}

	public static void updateUser() {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);

			User user = userOperation.selectUserByID(1);
			user.setUserAddress("沈阳");
			userOperation.updateUser(user);
			session.commit();

		} finally {
			session.close();
		}
	}

	public static void addUser() {
		User user = new User();

		user.setUserAddress("鞍山");
		user.setUserAge("27");
		user.setUserName("刘天龙");

		SqlSession session = sqlSessionFactory.openSession();

		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);

			userOperation.addUser(user);

			session.commit();

			System.out.println("当前添加的用户是：" + user.getUserName() + "  id 为："
					+ user.getId());
		} finally {
			session.close();
		}
	}

	public static void getUserList(String userName) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			List<User> users = userOperation.selectUsers(userName);
			for (User user : users) {
				System.out.println(user.getUserName() + ":"
						+ user.getUserAddress());
			}

		} finally {
			session.close();
		}
	}

	public static void getOneUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			// old
			/*
			 * User user = (User) session .selectOne(
			 * "com.necares.liutl.mybatis.model.UserMapper.selectUserByID", 1);
			 */

			// new
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);

			User user = userOperation.selectUserByID(2);

			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
			System.out.println(user.getUserAge());

			// userOperation.selectUsers(userName)

		} finally {
			session.close();
		}
	}
}