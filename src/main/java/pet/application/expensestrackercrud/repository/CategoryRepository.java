package pet.application.expensestrackercrud.repository;

import org.springframework.data.repository.CrudRepository;
import pet.application.expensestrackercrud.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
