package com.jd.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

	@Test
	public void testCount(){
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//���÷����õ���¼��
		String sql = "SELECT COUNT(*) FROM user";
		int count = jdbcTemplate.queryForObject(sql,Integer.class);
		System.out.println(count);
	}
	
	
	@Test
	public void testObject(){
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//���÷����õ�����
		String sql = "SELECT * FROM user WHERE username=?";
		
		//����jdbcTemplate�ķ���ʵ�֣��ڶ��������ǽӿ�RowMapper����Ҫ�Լ�д��ʵ�ֽӿڣ��Լ������ݷ�װ
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "lucy");
		System.out.println(user.toString());
	}
	
	
	
	
	
	@Test
	public void testList(){
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//���÷����õ�����
		String sql = "SELECT * FROM user;";
		
		//����jdbcTemplate�ķ���ʵ�֣��ڶ��������ǽӿ�RowMapper����Ҫ�Լ�д��ʵ�ֽӿڣ��Լ������ݷ�װ
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(list.toString());
	}
} 



class MyRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int n) throws SQLException {
		// 1 �ӽ������������ݵõ�
		String username = rs.getString("username");
		String password = rs.getString("password");
		//2�ѵõ����ݷ�װ��������
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
	
}







