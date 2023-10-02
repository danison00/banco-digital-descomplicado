package com.dan.bancodigitaldescomplicado.model.dto;

import java.math.BigDecimal;

public record TransferRequestDto(
    String accountSend,
    BigDecimal value,
    boolean saveDestination) {

}
