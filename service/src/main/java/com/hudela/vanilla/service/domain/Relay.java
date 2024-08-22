package com.hudela.vanilla.service.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relay")
@Getter
@Setter
public class Relay implements Updatable {

    @Id
    private int id;
    private String name;
    private int battery;
    private Boolean state;

    @Override
    public void update() {
        // Mock: Ne pas modifier
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
