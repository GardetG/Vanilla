package com.hudela.vanilla.service.service.impl;

import com.hudela.vanilla.service.domain.Relay;
import com.hudela.vanilla.service.repository.RelayRepository;
import com.hudela.vanilla.service.service.RelayService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service implementation for relays
 */
@Service
public class RelayServiceImpl implements RelayService {

    private final RelayRepository relayRepository;

    public RelayServiceImpl(RelayRepository relayRepository) {
        this.relayRepository = relayRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Relay> getAll() {
        return this.relayRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateState(int id, boolean state) throws NotFoundException {
        Relay relay = this.relayRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Sensor %d not found", id)));
        relay.setState(state);
    }

}
