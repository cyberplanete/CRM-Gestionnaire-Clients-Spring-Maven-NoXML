package crm.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//Remplace config.xml

@EnableWebMvc
@Configuration
@ComponentScan({ "crm.dao","crm.controleur","crm.service","crm.entity","crm.aspect","crm.config","crm.erreurs" })
public class ApplicationContextConfig implements WebMvcConfigurer{
	
	
	@Bean
	@Autowired
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(securityDataSource());
        sessionFactory.setPackagesToScan(new String[]{"crm.entity"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

	@Autowired
	@Bean
	public DataSource securityDataSource() {
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	    dataSource.setUrl("jdbc:mysql://localhost:3306/crm_gestionnaire_client?useSSL=false");
//	    dataSource.setUsername("etudiantspring");
//	    dataSource.setPassword("etudiantspring");
	   
	    ComboPooledDataSource dataSource = new ComboPooledDataSource();
	    try {
	    	//JDBC 
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/crm_gestionnaire_client?useSSL=false" );
			dataSource.setUser("etudiantspring");                                  
			dataSource.setPassword("etudiantspring");
			
			//Connection pool properties
			dataSource.setIdleConnectionTestPeriod(60 * 5);
			dataSource.setInitialPoolSize(5);
			dataSource.setMinPoolSize(5);
		    dataSource.setAcquireIncrement(1);
		    dataSource.setMaxPoolSize(20);
			
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	    return dataSource;
	}
	@Autowired
	@Bean
	public InternalResourceViewResolver viewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setViewClass(JstlView.class);
	    viewResolver.setPrefix("/WEB-INF/view/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	}

	
	@Bean
	@Autowired
	 Properties hibernateProperties() {
	        return new Properties() {

				private static final long serialVersionUID = 1L;
					//Hibernate properties
				{
	                setProperty("hibernate.hbm2ddl.auto", "update");
	                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
	                setProperty("hibernate.show_sql", "true");
	            }
	        };
	 }	
}
