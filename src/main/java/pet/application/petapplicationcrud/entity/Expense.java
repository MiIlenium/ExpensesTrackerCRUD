package pet.application.petapplicationcrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String description;
    private long amount;
    @ManyToOne
    private Category category_id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;
    private Date date;

    @ManyToOne
    @JoinColumn
    private PaymentMethod paymentMethod;

    @ManyToMany
    @JoinTable(
            name = "expense_tag",
            joinColumns = @JoinColumn(name = "expense_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
}
