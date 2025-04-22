package hard;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.context.annotation.*;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "hard")
public class TestTransaction {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestTransaction.class);

        BankService service = context.getBean(BankService.class);

        // Run Successful Transaction
        service.transfer(101, 102, 1000);

        // Run Failed Transaction
        service.transfer(101, 102, 100000); // Assuming insufficient funds

        context.close();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setPackagesToScan("hard");
        factory.setHibernateProperties(hibernateProps());
        factory.setAnnotatedClasses(Account.class, Transaction.class);
        return factory;
    }

    private Properties hibernateProps() {
        Properties props = new Properties();
        props.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/bank");
        props.put("hibernate.connection.username", "root");
        props.put("hibernate.connection.password", "your_password");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("show_sql", "true");
        return props;
    }
}
