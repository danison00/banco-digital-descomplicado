package com.dan.bancodigitaldescomplicado.service.interfaces;

import java.math.BigDecimal;

import com.dan.bancodigitaldescomplicado.model.dto.TransferDto;

import com.dan.bancodigitaldescomplicado.model.entity.Transfer;

public interface TransferService extends TransactionsService{

    void executeTransfer(TransferDto transactionDto) throws Exception;

    void tranferValue(Transfer transaction);


}
