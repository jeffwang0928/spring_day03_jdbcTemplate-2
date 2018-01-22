package com.jd.jdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo2 {

	@Test
	public void create(){
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		//����sql���
		String sql = "insert into user values(?,?)";
		int rows = jdbcTemplate.update(sql,"Lucy","250");
		System.out.println(rows);
	}
	
	@Test
	public void update(){
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		//����sql���
		String sql = "update user set password=? where username=?";
		int rows = jdbcTemplate.update(sql,"111111","Lucy");
		System.out.println(rows);
	}
	
	
	@Test
	public void delete(){
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����jdbcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		//����sql���
		String sql = "delete from user where username=?";
		int rows = jdbcTemplate.update(sql,"Lucy");
		System.out.println(rows);
	}
	
}
