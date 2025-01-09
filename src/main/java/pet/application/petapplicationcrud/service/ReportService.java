package pet.application.petapplicationcrud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pet.application.petapplicationcrud.dto.SummaryDTO;
import pet.application.petapplicationcrud.repository.ExpenseOverviewRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportService {
    private final ExpenseOverviewRepository expenseOverviewRepository;

    public List<SummaryDTO> getExpensesSummary() {
        return expenseOverviewRepository.getExpenseOverview();
    }
}
