package com.dan.bancodigitaldescomplicado.model.dto;

import java.math.BigDecimal;

public record DepositRequestDto(String accountNumber, BigDecimal value) {
    
}
