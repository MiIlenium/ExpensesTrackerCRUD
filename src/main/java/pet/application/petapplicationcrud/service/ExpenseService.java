package pet.application.petapplicationcrud.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pet.application.petapplicationcrud.dto.ExpenseDTO;
import pet.application.petapplicationcrud.entity.Category;
import pet.application.petapplicationcrud.entity.Expense;
import pet.application.petapplicationcrud.entity.Tag;
import pet.application.petapplicationcrud.repository.CategoryRepository;
import pet.application.petapplicationcrud.repository.ExpenseRepository;
import pet.application.petapplicationcrud.repository.TagRepository;

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

    public void addExpense(ExpenseDTO expenseDTO) {
        log.debug("Start adding expense: {}", expenseDTO.getName());
        Expense expense = expenseRepository.save(mapDTOToEntity(expenseDTO));

        if(expenseDTO.getCategory()!=null) {
            for (Category category : removeCategoryDuplicates(expenseDTO.getCategory())) {
                category.setExpenseId(expense.getId());
                categoryRepository.save(category);
            }
        }

        if(expenseDTO.getTags()!=null) {
            for(Tag tag : expenseDTO.getTags()) {
                tag.setExpenseId(expense.getId());
                tagRepository.save(tag);
            }
        }
    }

    public Set<Expense> getAllExpenses() {
        return expenseRepository.findAll();
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
        expense.setPaymentMethod(expenseDTO.getPaymentMethod());

        return expense;
    }

    private List<Category> removeCategoryDuplicates(List<Category> category) {
        return category.stream().distinct().toList();
    }
}
