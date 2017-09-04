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

}
