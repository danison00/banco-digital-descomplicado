package com.dan.bancodigitaldescomplicado.model.dto;

import java.time.LocalDate;

public record AccountDataResponseDto(
        String cpf,
        String name,
        String telephone,
        String email,
        String number,
        LocalDate openingDate,
        String type) {

}
