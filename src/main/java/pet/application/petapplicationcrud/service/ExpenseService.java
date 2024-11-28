package pet.application.petapplicationcrud.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pet.application.petapplicationcrud.dto.ExpenseDTO;
import pet.application.petapplicationcrud.entity.Expense;
import pet.application.petapplicationcrud.repository.ExpenseRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public void addExpense(ExpenseDTO expenseDTO) {
        log.debug("Start adding expense: {}", expenseDTO.getName());
        expenseRepository.save(mapDTOToEntity(expenseDTO));
    }

    public Set<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(int id) {
        return expenseRepository.getExpenseById(id);
    }

    /*ToDo
        make it later with mapstruct
     */
    private Expense mapDTOToEntity(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();

        expense.setName(expenseDTO.getName());
        expense.setDescription(expenseDTO.getDescription());
        expense.setAmount(expenseDTO.getAmount());
        expense.setDate(expenseDTO.getDate());
        expense.setCategory(expenseDTO.getCategory());
        expense.setPaymentMethod(expenseDTO.getPaymentMethod());

        return expense;
    }
}
