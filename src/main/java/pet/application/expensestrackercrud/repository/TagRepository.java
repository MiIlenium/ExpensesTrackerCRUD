package pet.application.expensestrackercrud.repository;

import org.springframework.data.repository.CrudRepository;
import pet.application.expensestrackercrud.entity.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
}
