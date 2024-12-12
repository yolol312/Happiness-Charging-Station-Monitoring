package com.example.happyDream;

import com.example.happyDream.DTO.ReportDTO;
import com.example.happyDream.Service.ChargerServiceFacade;
import com.example.happyDream.Service.ReportService;
import com.example.happyDream.Service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class NavBarConfig {
    private final ReportService reportService;
    private final List<ReportDTO> totalBreakdownReport;

    @Autowired
    public NavBarConfig(ReportService reportService) {
        this.reportService = reportService;
        totalBreakdownReport = reportService.reportSelectByNotCheckedReport();
    }

    @ModelAttribute("totalAlertCount")
    public int addTotalAlertCount() {
        int totalAlertCount = 0;
        if(!totalBreakdownReport.isEmpty()){
            totalAlertCount = 1;
        }
        return totalAlertCount;
    }

    @ModelAttribute("totalBreakdownReportCount")
    public int addTotalBreakdownReportCount() {
        return totalBreakdownReport.size();
    }
}