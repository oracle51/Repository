package com.necares.liutl.mybatis.inter;

import java.util.List;

import com.necares.liutl.mybatis.model.Article;
import com.necares.liutl.mybatis.model.User;

public interface IUserOperation {
	//查一条
	public User selectUserByID(int id);
	
	//查多条
	public List<User> selectUsers(String userName);
	
	//添加
	public void addUser(User user);
	
	//更新
	public void updateUser(User user);
	
	//删除
	public void deleteUser(int id);
	
	//关联查询demo
	public List<Article> getUserArticles(int id);
}
