package pet.application.petapplicationcrud.repository;

import org.springframework.data.repository.CrudRepository;
import pet.application.petapplicationcrud.entity.Expense;

import java.util.Set;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    Expense getExpenseById(int id);

    Set<Expense> findAll();
}
