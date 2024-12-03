package pet.application.petapplicationcrud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pet.application.petapplicationcrud.dto.ExpenseDTO;
import pet.application.petapplicationcrud.entity.Expense;
import pet.application.petapplicationcrud.service.ExpenseService;

import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/api/expense/create")
    public void createExpense(@RequestBody ExpenseDTO expense) {
        log.debug("expense created {}", expense.getDescription());
        expenseService.addExpense(expense);
    }

    @GetMapping("/api/expense/listAll")
    public Set<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/api/expense/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/api/expense/delete/{id}")
    public void deleteExpenseById(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
    }

    @PostMapping("/api/expense/update")
    public void updateExpense(@RequestBody ExpenseDTO expense){
        expenseService.updateExpense(expense);
    }
}
