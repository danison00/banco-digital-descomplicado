package com.dan.bancodigitaldescomplicado.model.entity;


import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@NoArgsConstructor
@Table(name="Tranfer")
public class Transfer extends TransactionAbstract{


    
    @ManyToOne
    @JoinColumn(name="origin_id_fk")
    private Account origin;
    
    public Transfer(Account origin, Account destination, BigDecimal value) {
        
        super(destination, value);
        this.origin = origin;      
    }

    
    
    

}
