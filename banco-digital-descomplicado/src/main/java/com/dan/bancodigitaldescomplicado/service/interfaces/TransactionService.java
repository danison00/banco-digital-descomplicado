package com.dan.bancodigitaldescomplicado.service.interfaces;

import com.dan.bancodigitaldescomplicado.model.dto.TransactionDto;

public interface TransactionService {

    void execute(TransactionDto transactionDto) throws Exception;
    
}
