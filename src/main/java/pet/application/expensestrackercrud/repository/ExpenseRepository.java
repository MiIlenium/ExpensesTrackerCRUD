package pet.application.expensestrackercrud.repository;

import jakarta.annotation.Nonnull;
import org.springframework.data.repository.CrudRepository;
import pet.application.expensestrackercrud.entity.Expense;

import java.util.Set;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    @Nonnull
    Set<Expense> findAll();
    Expense findById(long id);
}
