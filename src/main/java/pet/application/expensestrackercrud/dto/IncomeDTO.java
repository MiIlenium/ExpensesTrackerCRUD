package pet.application.expensestrackercrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import pet.application.expensestrackercrud.entity.Category;
import pet.application.expensestrackercrud.entity.Tag;
import pet.application.expensestrackercrud.enums.PaymentMethod;

import java.util.Date;
import java.util.List;

public class IncomeDTO {
    private long id;
    private String name;
    private String description;
    private long amount;
    private Date date;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private PaymentMethod paymentMethod;
    @Nullable
    private List<Tag> tags;
    @Nullable
    private List<Category> category;
}
