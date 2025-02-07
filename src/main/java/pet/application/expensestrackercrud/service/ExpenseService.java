package pet.application.expensestrackercrud.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pet.application.expensestrackercrud.dto.ExpenseDTO;
import pet.application.expensestrackercrud.entity.Category;
import pet.application.expensestrackercrud.entity.Expense;
import pet.application.expensestrackercrud.entity.Tag;
import pet.application.expensestrackercrud.exception.WebException;
import pet.application.expensestrackercrud.repository.CategoryRepository;
import pet.application.expensestrackercrud.repository.ExpenseRepository;
import pet.application.expensestrackercrud.repository.TagRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;

    private static final String EXPENSE_NOT_FOUND = "Expense cannot be found";

    public void addExpense(ExpenseDTO expenseDTO) {
        log.debug("Start adding expense: {}", expenseDTO.getName());
        Expense expense = expenseRepository.save(mapDTOToEntity(expenseDTO));

        //mapping category to expense in database
        if (expenseDTO.getCategory() != null) {
            for (Category category : removeCategoryDuplicates(expenseDTO.getCategory())) {
                category.setExpenseId(expense.getId());
                categoryRepository.save(category);
            }
        }
        //mapping tag to expense in database
        if (expenseDTO.getTags() != null) {
            for (Tag tag : expenseDTO.getTags()) {
                tag.setExpenseId(expense.getId());
                tagRepository.save(tag);
            }
        }
    }

    public Set<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id).orElse(null);
        if (expense == null) {
            log.warn("Expense with id {} not found", id);
            throw new WebException(EXPENSE_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
        return expense;
    }

    public void deleteExpenseById(Long id) {
        try {
            expenseRepository.deleteById(id);
        } catch (Exception e) {
            log.warn(EXPENSE_NOT_FOUND);
            throw new WebException(EXPENSE_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
    }

    public void updateExpense(ExpenseDTO expenseDTO) {
        log.debug("Start updating expense: {}", expenseDTO.getName());
        Expense expense = expenseRepository.findById(expenseDTO.getId());
        if (expense == null) {
            log.warn(EXPENSE_NOT_FOUND);
            throw new WebException(EXPENSE_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        expense.setName(expenseDTO.getName());
        expense.setDescription(expenseDTO.getDescription());
        expense.setDate(expenseDTO.getDate());
        expense.setPaymentMethod(expenseDTO.getPaymentMethod());
        expense.setAmount(expenseDTO.getAmount());

        expenseRepository.save(expense);

        log.debug("End updating expense: {}", expenseDTO.getName());
    }

    private Expense mapDTOToEntity(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();

        expense.setName(expenseDTO.getName());
        expense.setDescription(expenseDTO.getDescription());
        expense.setAmount(expenseDTO.getAmount());
        expense.setDate(expenseDTO.getDate());
        expense.setPaymentMethod(expenseDTO.getPaymentMethod());

        return expense;
    }

    private List<Category> removeCategoryDuplicates(List<Category> category) {
        return category.stream().distinct().toList();
    }
}
