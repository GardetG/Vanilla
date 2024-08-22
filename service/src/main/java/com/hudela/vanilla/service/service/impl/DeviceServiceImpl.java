package com.hudela.vanilla.service.service.impl;

import com.hudela.vanilla.service.domain.Updatable;
import com.hudela.vanilla.service.service.DeviceService;
import com.hudela.vanilla.service.service.RelayService;
import com.hudela.vanilla.service.service.SensorService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final static int THRESHOLD = 60;

    private final SensorService sensorService;
    private final RelayService relayService;

    public DeviceServiceImpl(SensorService sensorService, RelayService relayService) {
        this.sensorService = sensorService;
        this.relayService = relayService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long update() {
        Instant start = Instant.now();
        List<Updatable> updatablesDevice = new ArrayList<>();
        updatablesDevice.addAll(this.sensorService.getAll());
        updatablesDevice.addAll(this.relayService.getAll());

        this.updateAll(updatablesDevice);

        Instant end = Instant.now();
        return Duration.between(start, end).toSeconds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    // TODO l'état des capteurs n'est pas mis à jour, à corriger
    // TODO Le seuil est fixé en dur dans le code, le définir dans le application.properties
    // TODO La méthode doit considérer les capteurs ET les relais
    public void disabledBelowBatteryThreshold() {
        this.sensorService.getAll()
                .stream()
                .filter(sensor -> sensor.getBattery()< THRESHOLD)
                .forEach(sensor -> sensor.setState(false));
    }

    /**
     * Update all updatable device of the list
     *
     * @param updatablesDevice updatable device list
     */
    // TODO La méthode est trop lente, à optimiser avec un traitement en parallèle.
    private void updateAll(List<Updatable> updatablesDevice) {
        for (Updatable updatable : updatablesDevice) {
                updatable.update();
        }
    }

}
