package pet.application.expensestrackercrud;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

/*ToDo:
    - Configure writing Structured Logging (https://www.baeldung.com/java-structured-logging)
    - Configure mapstruct, replace boilerplate on ExpenseServer line 77-81
 */


@SpringBootApplication
@Slf4j
public class ExpensesTrackerCRUD {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ExpensesTrackerCRUD.class, args);
        // Initialize Liquibase programmatically
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(context.getBean(DataSource.class));
        liquibase.setChangeLog("classpath:db/changelog/liquibase-changelog.xml");
        try {
            liquibase.afterPropertiesSet();
        } catch (Exception e) {
            log.error("Error while starting liquibase", e);
        }
    }

}
