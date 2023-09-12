package com.dan.bancodigitaldescomplicado.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;
    
    private BigDecimal balance;
    private TypeAccount type;

    @Column(columnDefinition = "DATE")
    private LocalDate openingDate;

    @OneToMany(mappedBy = "origin")
    private List<Transaction> transactionsSend;
    
    @OneToMany(mappedBy = "destination")
    private List<Transaction> transactionsReceived;

}