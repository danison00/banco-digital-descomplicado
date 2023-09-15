package com.dan.bancodigitaldescomplicado.service.interfaces;

import java.math.BigDecimal;

import com.dan.bancodigitaldescomplicado.model.dto.TransferRequestDto;

import com.dan.bancodigitaldescomplicado.model.entity.Transfer;

public interface TransferService extends TransactionsService{

    void executeTransfer(TransferRequestDto transactionDto) throws Exception;

    void tranferValue(Transfer transaction);


}
