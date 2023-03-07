package com.desafio.heuristicas.coesaobasica.valueobjects.percentual.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FazerPercentual {

    private BigDecimal value;

    public FazerPercentual(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal escolhaPercentual(int casas, RoundingMode arrendodamento) {
        return value.divide(BigDecimal.valueOf(1), casas, arrendodamento);
    }

}
