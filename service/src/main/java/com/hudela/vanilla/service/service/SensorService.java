package com.hudela.vanilla.service.service;

import com.hudela.vanilla.service.domain.Sensor;
import javassist.NotFoundException;

import java.util.List;

/**
 * Service interface for sensors
 */
public interface SensorService {

    /**
     * Get a list of all sensors
     *
     * @return Sensor list
     */
    List<Sensor> getAll();

    /**
     * Update the state of a sensor
     *
     * @param id Sensor id
     * @param state boolean
     */
    void updateState(int id, boolean state) throws NotFoundException;
}
