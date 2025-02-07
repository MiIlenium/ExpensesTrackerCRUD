package pet.application.expensestrackercrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pet.application.expensestrackercrud.enums.PaymentMethod;
import pet.application.expensestrackercrud.entity.Category;
import pet.application.expensestrackercrud.entity.Tag;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {
    private long id;
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
    private PaymentMethod paymentMethod;
    @JsonProperty("tags")
    @Nullable
    private List<Tag> tags;
    @JsonProperty("category")
    @Nullable
    private List<Category> category;
}
