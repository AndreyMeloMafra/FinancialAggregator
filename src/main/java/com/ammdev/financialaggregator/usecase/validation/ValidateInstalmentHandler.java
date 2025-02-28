package com.ammdev.financialaggregator.usecase.validation;

import com.ammdev.financialaggregator.domain.aggregate.Cost;
import com.ammdev.financialaggregator.domain.aggregate.CostSource;
import com.ammdev.financialaggregator.domain.aggregate.Instalment;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ValidateInstalmentHandler extends AbstractValidationHandler {

    @Override
    protected boolean doValidate(List<Cost> costs) {
        List<Cost> costNotValid = costs.stream().filter(this::validateInstalment).toList();
        return !costNotValid.isEmpty();
    }

    private boolean validateInstalment(Cost cost) {
        Instalment instalment = cost.instalment();
        CostSource costSource = cost.costSource();

        return !ObjectUtils.isEmpty(instalment) || !isCostSourceRequiringInstalment(costSource);
    }

    private boolean isCostSourceRequiringInstalment(CostSource costSource) {
        return CostSource.CREDIT_CARD.equals(costSource) ||
                CostSource.FINANCING.equals(costSource) ||
                CostSource.LOAN.equals(costSource);
    }

    @Override
    protected String getErrorMessage() {
        return "O campo instalment é obrigatório quando a fonte do custo é igual a CREDIT_CARD, FINANCING ou LOAN";
    }
}