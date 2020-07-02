package com.dropstore;

import java.io.IOException;
//
import java.util.Properties;
//
import javax.sql.DataSource;
//
import org.hibernate.SessionFactory;
//
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//
import org.springframework.core.env.Environment;
//
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
import org.springframework.orm.hibernate5.HibernateTransactionManager;
//
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

//import java.io.IOException;
//import java.util.Properties;

//import javax.sql.DataSource;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource; 
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:datasource.properties" )
public class HibernateConfig {
	@Autowired
	Environment env;
	
	@Bean
	public DataSource dataSource() {

	    DriverManagerDataSource dataSource = new DriverManagerDataSource();

	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/dropstore");
	    dataSource.setUsername("root");
	    dataSource.setPassword("truongan123");
	    System.out.println("## getDataSource: " + dataSource);
	    return dataSource;

	}
	
	@Bean
	@Autowired
	public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan(new String[] {"com.dropstore.entity"} );
		factoryBean.setDataSource(dataSource);
		Properties props = factoryBean.getHibernateProperties();
		props.put("hibernate.dialect",env.getProperty("hd.dialect"));
		props.put("hibernate.show_sql",env.getProperty("hb.show-sql"));
		props.put("current_session_context_class",env.getProperty("hb.session"));
		factoryBean.afterPropertiesSet();
		SessionFactory sessionFactory= factoryBean.getObject();

        System.out.println("## getSessionFactory: " + sessionFactory);
		return sessionFactory;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
   
}
