package com.ammdev.financialaggregator.endpoint;

import com.ammdev.financialaggregator.domain.AggregatorResponse;
import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.domain.Period;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateProductCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.impl.AggregateCreditCardCostUsecaseImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/aggregator/v1")
public class AggregatorController {

    private final AggregateCostUsecase aggregateCostUsecase;
    private final AggregateProductCostUsecase aggregateProductCostUsecase;

    public AggregatorController(AggregateCostUsecase aggregateCostUsecase, AggregateCreditCardCostUsecaseImpl aggregateProductCostUsecase) {
        this.aggregateCostUsecase = aggregateCostUsecase;
        this.aggregateProductCostUsecase = aggregateProductCostUsecase;
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

    @PostMapping("/credit-cards")
    public List<Cost> getCreditCardBillings(
//            @RequestBody List<Cost> costs,
            @RequestHeader String startDate,
            @RequestHeader String endDate
    ) {
        Period period = new Period(startDate, endDate);

        return aggregateProductCostUsecase.retrieveCost(period);
    }

}
