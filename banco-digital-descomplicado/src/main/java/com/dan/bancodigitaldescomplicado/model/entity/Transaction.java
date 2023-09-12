package com.dan.bancodigitaldescomplicado.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
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

    private BigInteger value;
    private String dateAndHour;
    
    

}
