package com.dan.bancodigitaldescomplicado.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.dan.bancodigitaldescomplicado.model.entity.Deposit;
import com.dan.bancodigitaldescomplicado.model.entity.Transfer;

public record AccountDto(
        String number,
        BigDecimal balance,
        LocalDate openingDate,
        List<Deposit> deposits,
        List<Transfer> tranferReceived,
        List<Transfer> tranferSend) {

}
