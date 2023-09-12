package com.dan.bancodigitaldescomplicado.model.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String telephone;
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="user_id_fk")
    private User user;




    
}
