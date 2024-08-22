package com.hudela.vanilla.service.controller;

import com.hudela.vanilla.service.dto.SensorDto;
import com.hudela.vanilla.service.mapper.SensorMapper;
import com.hudela.vanilla.service.service.SensorService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for sensor entity
 */
@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    public SensorController(SensorService sensorService, SensorMapper sensorMapper){
        this.sensorService = sensorService;
        this.sensorMapper = sensorMapper;
    }

    /**
     * Get a list of all sensors
     *
     * @return Sensor DTO list
     */
    @GetMapping()
    public ResponseEntity<List<SensorDto>> getAll() {
        List<SensorDto> devices = this.sensorMapper.toDtos(this.sensorService.getAll());
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    /**
     * Update a sensor state
     */
    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Void> updateState(@PathVariable(value = "id") int id,
                                            @ModelAttribute(value="state") boolean state) throws NotFoundException {
        this.sensorService.updateState(id, state);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
