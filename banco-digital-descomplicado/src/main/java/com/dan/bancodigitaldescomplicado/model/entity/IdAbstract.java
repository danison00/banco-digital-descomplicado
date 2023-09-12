package com.dan.bancodigitaldescomplicado.model.entity;

import java.io.Serializable;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class IdAbstract<T extends Serializable> implements Serializable {
    
    @Id
    private T id;

}
