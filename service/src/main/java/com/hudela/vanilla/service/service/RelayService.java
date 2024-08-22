package com.hudela.vanilla.service.service;

import com.hudela.vanilla.service.domain.Relay;
import javassist.NotFoundException;

import java.util.List;

/**
 * Service interface for relays
 */
public interface RelayService {

    /**
     * Get a list of all relays
     *
     * @return Relay list
     */
    List<Relay> getAll();

    /**
     * Update the state of a relay
     *
     * @param id Relau id
     * @param state boolean
     */
    void updateState(int id, boolean state) throws NotFoundException;
}
