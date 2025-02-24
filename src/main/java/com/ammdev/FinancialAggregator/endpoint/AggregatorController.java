package com.ammdev.FinancialAggregator.endpoint;

import com.ammdev.FinancialAggregator.domain.AggregatorResponse;
import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.domain.Period;
import com.ammdev.FinancialAggregator.usecase.aggregator.AggregateCostUsecase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/aggregator/v1")
public class AggregatorController {

    AggregateCostUsecase aggregateCostUsecase;

    public AggregatorController(AggregateCostUsecase aggregateCostUsecase) {
        this.aggregateCostUsecase = aggregateCostUsecase;
    }

    @PostMapping("/cost")
    public AggregatorResponse getCost(
            @RequestBody List<Cost> costs,
            @RequestHeader String startDate,
            @RequestHeader String endDate
    ) {
        Period period = new Period(startDate, endDate);

        return aggregateCostUsecase.execute(costs, period);
    }
}
