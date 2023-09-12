package com.dan.bancodigitaldescomplicado.model.dto;


import com.dan.bancodigitaldescomplicado.model.entity.TypeAccount;

public record CreateAccountRequest(
        String cpf,
        String name,
        String telephone,
        String email,
        TypeAccount typeAccount,
        String username) {
}
