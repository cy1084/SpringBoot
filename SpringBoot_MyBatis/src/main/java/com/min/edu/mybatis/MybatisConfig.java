package com.min.edu.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//3번째 방법) xml을 자바로 바꿔놓은 것!! 
@Configuration
@MapperScan(value="com.min.edu.model")
public class MybatisConfig {
	
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.url("jdbc:oracle:thin:@localhost:1521:xe")
				.driverClassName("oracle.jdbc.driver.OracleDriver")
				.username("EDU")
				.password("EDU")
				.build();
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		
		Resource[] res =new PathMatchingResourcePatternResolver().getResources("classpath:sqls/*.xml");
		
		sessionFactoryBean.setMapperLocations(res);
		return sessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
