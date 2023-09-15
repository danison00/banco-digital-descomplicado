package com.dan.bancodigitaldescomplicado.model.dto;

import java.math.BigDecimal;

public record TransferDto(
    String accountSend,
    String accountOrigin,
    BigDecimal value) {


    
}
