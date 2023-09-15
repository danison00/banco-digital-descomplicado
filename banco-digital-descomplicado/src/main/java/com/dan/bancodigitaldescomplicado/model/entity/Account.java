package com.dan.bancodigitaldescomplicado.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
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

    @JsonIgnore
    @OneToMany(mappedBy = "origin")
    private List<Transfer> transactionsSend;
   
    @JsonIgnore
    @OneToMany(mappedBy = "destination")
    private List<Transfer> transactionsReceived;
    
    @JsonIgnore
    @OneToMany(mappedBy = "destination")
    private List<Deposit> deposits;

   @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cliente_id_fk")
    private Client client;


    public Account(TypeAccount type) {
        this.type = type;
        this.balance = BigDecimal.valueOf(0);
    }

    


}