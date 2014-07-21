package com.necares.liutl.mybatis.inter;

import java.util.List;

import com.necares.liutl.mybatis.model.Article;
import com.necares.liutl.mybatis.model.User;

public interface IUserOperation {
	//��һ��
	public User selectUserByID(int id);
	
	//�����
	public List<User> selectUsers(String userName);
	
	//���
	public void addUser(User user);
	
	//����
	public void updateUser(User user);
	
	//ɾ��
	public void deleteUser(int id);
	
	//������ѯdemo
	public List<Article> getUserArticles(int id);
}
