package pet.application.petapplicationcrud.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pet.application.petapplicationcrud.dto.SummaryDTO;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ExpenseOverviewRepository {
    private final EntityManager entityManager;

    public List<SummaryDTO> getExpenseOverview() {
        String sqlQuery = """
                SELECT
                    "ID",
                    "expense_name",
                    "payment_method",
                    ARRAY_AGG("tags") AS tags,
                    ARRAY_AGG("categories") AS categories
                FROM
                    public.expenses_overview
                GROUP BY
                    "ID", "expense_name", "payment_method";""";

        return entityManager.createNativeQuery(sqlQuery).getResultList();
    }
}
