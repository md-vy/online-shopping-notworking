package com.StudentBack.BShopConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.StudentBack")
@EnableTransactionManagement
public class HibernateConfig {
	private static final String Driverclass="org.h2.Driver";
	private static final String DBURL=" jdbc:h2:tcp://localhost/~/studentBack";
	private static final String DBuser="sa";
	private static final String DBpass="";
	private static final String DBdialect="org.hibernate.dialect.H2Dialect";
@Bean("dataSource")
public DataSource getDataSource()
{
DriverManagerDataSource dataSource=new DriverManagerDataSource();
dataSource.setDriverClassName(Driverclass);
dataSource.setUrl(DBURL);
dataSource.setUsername(DBuser);
dataSource.setPassword(DBpass);

return dataSource;
}
@Bean("sessionFactory")
public SessionFactory getsessionFactory(DataSource datasource) {
	LocalSessionFactoryBuilder lsfb= new LocalSessionFactoryBuilder(datasource);
lsfb.addProperties(getHibernateProp());
lsfb.scanPackages("com.StudentBack");
return lsfb.buildSessionFactory();
}
private Properties getHibernateProp() {
	Properties prop = new Properties();
	prop.put("hibernate.dialect", DBdialect);
	
	//optional
	prop.put("hibernate.hbm2ddl.auto", "create"); //create,update, create-drop,validate. This property will tell hibernate to create table automatically
	prop.put("hibernate.show_sql", "true");
	prop.put("hibernate.format_sql", "true");
	//optional
	return prop;
}
@Bean
public HibernateTransactionManager gettm(SessionFactory sessionFactory) {
	return new HibernateTransactionManager(sessionFactory);
}
}

