package com.dan.bancodigitaldescomplicado.model.dto;

import java.math.BigDecimal;

public record TransferRequestDto(
    String accountDestination,
    BigDecimal value,
    boolean saveDestination) {

}
