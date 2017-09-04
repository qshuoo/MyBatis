package com.qys.test;


import java.io.InputStream;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.qys.entity.User;

public class MyTest {

	@Test
	public void query() {
		String resource = "conf.xml";
		InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		// Reader reader = Resources.getResourceAsReader(resource);
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String statement = "getUser";
		User user = session.selectOne(statement, 1);
		System.out.println(user);

	}
	
	@Test
	public void update() {
		String resource = "conf.xml";
		InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String statement = "updateUser";
		User user = new User(2,"Áõ¹úÍ¨");
		session.update(statement, user);
	}
	
	@Test
	public void add() {
		String resource = "conf.xml";
		InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		User user = new User(3,"¶þ·É");
		session.insert("addUser", user);	
		session.commit();
	}
	
	@Test
	public void delete() {
		String resource = "conf.xml";
		InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		session.delete("deleteUser", 3);
		session.commit();
		
	}

}
