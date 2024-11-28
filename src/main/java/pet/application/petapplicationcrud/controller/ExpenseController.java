package pet.application.petapplicationcrud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
}
