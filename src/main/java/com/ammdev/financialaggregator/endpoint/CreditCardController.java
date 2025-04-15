package com.ammdev.financialaggregator.endpoint;

import com.ammdev.financialaggregator.domain.aggregate.Cost;
import com.ammdev.financialaggregator.domain.aggregate.Period;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateProductCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.impl.AggregateCreditCardCostUsecaseImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-card/v1")
public class CreditCardController {

    private final AggregateProductCostUsecase aggregateProductCostUsecase;


    public CreditCardController(AggregateCreditCardCostUsecaseImpl aggregateProductCostUsecase) {
        this.aggregateProductCostUsecase = aggregateProductCostUsecase;
    }

    @GetMapping
    public List<Cost> getCreditCardBillings(
            @RequestHeader String startDate,
            @RequestHeader String endDate
    ) {
        Period period = new Period(startDate, endDate);

        return aggregateProductCostUsecase.retrieveCost(period);
    }
}
