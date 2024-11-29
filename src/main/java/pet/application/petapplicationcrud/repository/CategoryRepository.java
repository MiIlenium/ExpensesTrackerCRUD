package pet.application.petapplicationcrud.repository;

import org.springframework.data.repository.CrudRepository;
import pet.application.petapplicationcrud.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
