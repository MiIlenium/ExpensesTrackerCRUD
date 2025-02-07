package pet.application.expensestrackercrud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.application.expensestrackercrud.dto.SummaryDTO;
import pet.application.expensestrackercrud.service.ReportService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExpenseReportController {
    private final ReportService reportService;

    @GetMapping("/api/report/generateReport")
    public List<SummaryDTO> expenseReportController() {
        return reportService.getExpensesSummary();
    }
}
