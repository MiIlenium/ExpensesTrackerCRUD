package pet.application.petapplicationcrud;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class PetApplicationCrudApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PetApplicationCrudApplication.class, args);
        // Initialize Liquibase programmatically
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(context.getBean(DataSource.class));
        liquibase.setChangeLog("classpath:db/changelog/liquibase-changelog.xml");
        try {
            liquibase.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
