package com.hudela.vanilla.service.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "model")
@Getter
@Setter
public class Model {

    @Id
    private int id;
    private String name;
    private String constructor;
    private int voltMax;

}
