package com.dan.bancodigitaldescomplicado.model.dto;

import java.math.BigDecimal;

public record TransferResponseDto(
    String name,
    String accountOrigin,
    BigDecimal value,
    String dateAndHour) {
    
}
