package pet.application.expensestrackercrud.dto.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pet.application.expensestrackercrud.dto.ExpenseDTO;
import pet.application.expensestrackercrud.entity.Expense;

@Mapper(componentModel = "spring")
public interface ExpenseConverter {
    ExpenseConverter INSTANCE = Mappers.getMapper(ExpenseConverter.class);

    Expense toEntity(ExpenseDTO expenseDTO);
    ExpenseDTO toDto(Expense expense);
}
