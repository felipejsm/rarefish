package com.nssp.rarefish.config;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
	entityManagerFactoryRef = "primaryEntityManager",
	transactionManagerRef = "primaryTransactionManager",
	basePackages = {"com.nssp.rarefish.model.fish"})
public class PrimaryDataSourceConfiguration {
	@Autowired
	private Environment env;

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean primaryEntityManager() {
		LocalContainerEntityManagerFactoryBean em = 
			new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(primaryDataSource());
		em.setPackagesToScan(
				new String[] {"com.nssp.rarefish.model.fish"}
				);
		HibernateJpaVendorAdapter vendorAdapter 
			= new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("spring.jpa.properties.hibernate.dialect",
				env.getProperty("spring.jpa.properties.hibernate.dialect"));
				em.setJpaPropertyMap(properties);
				return em;

	}

	@Primary
	@Bean
	public DataSource primaryDataSource() {
		DriverManagerDataSource dataSource 
			= new DriverManagerDataSource();
		dataSource.setDriverClassName(
				env.getProperty("spring.datasource.drive-class-name"));
		dataSource.setUrl(env.getProperty("spring.first-datasource.url"));
		dataSource.setUsername(env.getProperty("spring.first-datasource.username"));
		dataSource.setPassword(env.getProperty("spring.first-datasource.password"));
		return dataSource;
	}

	@Primary
	@Bean
	public PlatformTransactionManager primaryTransactionManager() {
		JpaTransactionManager transactionManager
			= new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				primaryEntityManager().getObject());
		return transactionManager;
	}
}




