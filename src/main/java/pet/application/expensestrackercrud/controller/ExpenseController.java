package pet.application.expensestrackercrud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pet.application.expensestrackercrud.dto.ExpenseDTO;
import pet.application.expensestrackercrud.entity.Expense;
import pet.application.expensestrackercrud.service.ExpenseService;

import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/api/expense/create")
    public void createExpense(@RequestBody ExpenseDTO expense) {
        log.debug("expense created {}", expense.getName());
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
