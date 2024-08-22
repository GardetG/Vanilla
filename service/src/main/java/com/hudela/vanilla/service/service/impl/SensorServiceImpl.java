package com.hudela.vanilla.service.service.impl;

import com.hudela.vanilla.service.domain.Sensor;
import com.hudela.vanilla.service.repository.SensorRepository;
import com.hudela.vanilla.service.service.SensorService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service implementation for devices
 */
@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    // TODO Trier la liste par niveau de batterie
    public List<Sensor> getAll() {
        return this.sensorRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateState(int id, boolean state) throws NotFoundException {
        Sensor sensor = this.sensorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Sensor %d not found", id)));
        sensor.setState(state);
    }

}
