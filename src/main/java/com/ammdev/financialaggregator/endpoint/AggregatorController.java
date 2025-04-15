package com.ammdev.financialaggregator.endpoint;

import com.ammdev.financialaggregator.domain.aggregate.AggregatorResponse;
import com.ammdev.financialaggregator.domain.aggregate.Cost;
import com.ammdev.financialaggregator.domain.aggregate.Period;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateProductCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.impl.AggregateCreditCardCostUsecaseImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aggregator/v1")
public class AggregatorController {

    private final AggregateCostUsecase aggregateCostUsecase;

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
