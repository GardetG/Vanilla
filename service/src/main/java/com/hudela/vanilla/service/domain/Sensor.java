package com.hudela.vanilla.service.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sensor")
@Getter
@Setter
public class Sensor implements Updatable {

    @Id
    private int id;
    private String name;
    private int volt;
    private Boolean state;

    // TODO Récupérer les informations du modèle de capteur
    @Transient
    private Model model;

    /**
     * Return sensor's battery percentage
     *
     * @return battery percentage
     */
    // TODO Calculer le pourcentage de batterie : Battery = volt / voltMax du modèle * 100
    public int getBattery() {
        return 0;
    }

    /**
     * Update device
     */
    @Override
    public void update() {
        // Mock: Ne pas modifier
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
