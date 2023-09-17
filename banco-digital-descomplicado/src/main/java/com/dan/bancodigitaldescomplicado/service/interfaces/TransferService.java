package com.dan.bancodigitaldescomplicado.service.interfaces;

import com.dan.bancodigitaldescomplicado.model.entity.Transfer;

public interface TransferService extends TransactionsService{

    void executeTransfer(Transfer transaction) throws Exception;

    void tranferAmount(Transfer transaction);


}
