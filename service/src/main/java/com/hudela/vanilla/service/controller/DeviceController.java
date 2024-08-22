package com.hudela.vanilla.service.controller;

import com.hudela.vanilla.service.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing devices
 */
@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    /**
     * Update all device
     *
     * @return Operation duration
     */
    @PostMapping("/update")
    public ResponseEntity<Long> updateAll() {
        long duration = this.deviceService.update();
        return new ResponseEntity<>(duration, HttpStatus.OK);
    }

    /**
     * Disable relays and sensors when their battery is below the threshold
     */
    @PostMapping("/autodisable")
    public ResponseEntity<Void> autoDisable() {
        this.deviceService.disabledBelowBatteryThreshold();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
