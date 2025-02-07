package pet.application.expensestrackercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.application.expensestrackercrud.entity.Category;
import pet.application.expensestrackercrud.entity.Tag;

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
