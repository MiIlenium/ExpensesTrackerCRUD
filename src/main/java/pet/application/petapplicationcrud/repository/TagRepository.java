package pet.application.petapplicationcrud.repository;

import org.springframework.data.repository.CrudRepository;
import pet.application.petapplicationcrud.entity.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
}
