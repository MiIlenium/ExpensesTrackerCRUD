package pet.application.petapplicationcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.application.petapplicationcrud.enums.PaymentMethodEnum;
import pet.application.petapplicationcrud.entity.Category;
import pet.application.petapplicationcrud.entity.Tag;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("amount")
    private long amount;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("paymentMethod")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private PaymentMethodEnum paymentMethod;
    @JsonProperty("tags")
    private List<Tag> tags;
    @JsonProperty("category")
    private Category category;
}
