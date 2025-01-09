package pet.application.petapplicationcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.application.petapplicationcrud.entity.Category;
import pet.application.petapplicationcrud.entity.Tag;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SummaryDTO {
    private int id;
    private String expenseName;
    private int paymentMethod;
    private List<Tag> tags;
    private List<Category> categories;
}
