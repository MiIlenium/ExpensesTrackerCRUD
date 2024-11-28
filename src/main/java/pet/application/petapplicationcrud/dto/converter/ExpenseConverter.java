package pet.application.petapplicationcrud.dto.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pet.application.petapplicationcrud.dto.ExpenseDTO;
import pet.application.petapplicationcrud.entity.Expense;

@Mapper(componentModel = "spring")
public interface ExpenseConverter {
    ExpenseConverter INSTANCE = Mappers.getMapper(ExpenseConverter.class);

    Expense toEntity(ExpenseDTO expenseDTO);
    ExpenseDTO toDto(Expense expense);
}
