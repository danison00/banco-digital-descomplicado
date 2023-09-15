package com.dan.bancodigitaldescomplicado.model.dto;

import java.math.BigDecimal;

public record DepositDto(String accountNumber, BigDecimal value) {
    
}
