package pet.application.petapplicationcrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.application.petapplicationcrud.enums.PaymentMethod;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String incomeSource;
    private Date incomeDate;
    private PaymentMethod paymentMethod;
}
