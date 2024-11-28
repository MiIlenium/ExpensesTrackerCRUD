package pet.application.petapplicationcrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.application.petapplicationcrud.enums.PaymentMethodEnum;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String description;
    private long amount;
    @ManyToOne
    private Category category_id;
    @ManyToOne
    @JoinColumn
    private Category category;
    private Date date;

    private PaymentMethodEnum paymentMethod;

    @ManyToMany
    private List<Tag> tags;
}
