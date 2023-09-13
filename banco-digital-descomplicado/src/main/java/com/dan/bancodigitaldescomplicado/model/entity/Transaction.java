package com.dan.bancodigitaldescomplicado.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name="Transactions")
public class Transaction implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="origin_id_fk")
    private Account origin;
    
    @ManyToOne
    @JoinColumn(name="destination_id_fk")
    private Account destination;

    private BigDecimal value;
    private String dateAndHour;
    
    public Transaction(Account origin, Account destination, BigDecimal value) {
        this.origin = origin;
        this.destination = destination;
        this.value = value;
    }

    
    
    

}
