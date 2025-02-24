package com.ammdev.FinancialAggregator.usecase.validation;

import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.domain.CostSource;
import com.ammdev.FinancialAggregator.domain.Instalment;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ValidateInstalmentHandler extends AbstractValidationHandler {

    @Override
    protected boolean doValidate(Cost cost) {
        Instalment instalment = cost.getInstalment();
        CostSource costSource = cost.getCostSource();

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