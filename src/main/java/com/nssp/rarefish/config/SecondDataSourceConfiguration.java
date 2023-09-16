package com.nssp.rarefish.config;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef = "secondEntityManager",
	transactionManagerRef = "secondTransactionManager",
	basePackages = {"com.nssp.rarefish.model.shipping"})
public class SecondDataSourceConfiguration {
	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean secondEntityManager() {
		LocalContainerEntityManagerFactoryBean em = 
			new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(secondDataSource());
		em.setPackagesToScan(
				new String[] {"com.nssp.rarefish.model.shipping"}
				);
		HibernateJpaVendorAdapter vendorAdapter 
			= new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect",
				env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("spring.jpa.generate-ddl",
				env.getProperty("spring.jpa.generate-ddl"));
		properties.put("hibernate.hbm2ddl.auto",
				env.getProperty("spring.jpa.hibernate.ddl-auto"));
				em.setJpaPropertyMap(properties);
				return em;

	}

	@Bean
	public DataSource secondDataSource() {
		DriverManagerDataSource dataSource 
			= new DriverManagerDataSource();
		dataSource.setDriverClassName(
				env.getProperty("spring.datasource.drive-class-name"));
		dataSource.setUrl(env.getProperty("spring.second-datasource.url"));
		dataSource.setUsername(env.getProperty("spring.second-datasource.username"));
		dataSource.setPassword(env.getProperty("spring.second-datasource.password"));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager secondTransactionManager() {
		JpaTransactionManager transactionManager
			= new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				secondEntityManager().getObject());
		return transactionManager;
	}
}




