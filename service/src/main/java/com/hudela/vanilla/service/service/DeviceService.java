package com.hudela.vanilla.service.service;

/**
 * Service interface to manage relays and sensors
 */
public interface DeviceService {

    /**
     * Update relays and sensors firmware
     *
     * @return Operation duration
     */
    long update();

    /**
     * Disable relays and sensors when their battery is below the threshold
     */
    void disabledBelowBatteryThreshold();

}
