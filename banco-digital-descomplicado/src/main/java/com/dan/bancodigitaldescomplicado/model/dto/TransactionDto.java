package com.dan.bancodigitaldescomplicado.model.dto;

import java.math.BigDecimal;

public record TransactionDto(
    String accountSend,
    String accountOrigin,
    BigDecimal value) {


    
}
