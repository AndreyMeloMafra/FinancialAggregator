package com.ammdev.financialaggregator.external.client;

import com.ammdev.financialaggregator.domain.aggregate.Cost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${api.rest.product.card.name}", url = "${api.rest.product.card.url}")
public interface CardClient {

    @GetMapping(value = "${api.rest.product.card.credit.list}")
    List<Cost> listCreditCard(@RequestParam String userId, @RequestParam String token);

    @GetMapping(value = "${api.rest.product.card.debit.list}")
    List<Cost> listDebitCard(@RequestParam String userId, @RequestParam String token);
}
