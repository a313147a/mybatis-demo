package service;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.UserMapper;
import po.User;

public class Main {

	public static void main(String[] args) throws Exception{
		//1.��ȡSqlSessionFactory������
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		//2��ͨ��SqlSessionFactory�õ�SqlSession
		SqlSession ss = sf.openSession();
		//3������mapper����
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user); 
		ss.close();
	}
}
