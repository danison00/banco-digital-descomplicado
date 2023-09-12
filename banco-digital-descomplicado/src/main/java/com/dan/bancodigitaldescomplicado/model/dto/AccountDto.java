package com.dan.bancodigitaldescomplicado.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.dan.bancodigitaldescomplicado.model.entity.TypeAccount;

import jakarta.persistence.Column;

public record AccountDto(String number, BigDecimal balance, LocalDate openingDate) {
    
}
