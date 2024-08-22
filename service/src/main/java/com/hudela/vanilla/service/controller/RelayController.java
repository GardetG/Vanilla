package com.hudela.vanilla.service.controller;

import com.hudela.vanilla.service.dto.RelayDto;
import com.hudela.vanilla.service.mapper.RelayMapper;
import com.hudela.vanilla.service.service.RelayService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for relay entity
 */
@RestController
@RequestMapping("/api/relays")
public class RelayController {

    private final RelayService relayService;
    private final RelayMapper relayMapper;

    public RelayController(RelayService relayService, RelayMapper relayMapper){
        this.relayService = relayService;
        this.relayMapper = relayMapper;
    }

    /**
     * Get a list of all relays
     *
     * @return Relay DTO list
     */
    @GetMapping()
    public ResponseEntity<List<RelayDto>> getAll() {
        List<RelayDto> relays = this.relayMapper.toDtos(this.relayService.getAll());
        return new ResponseEntity<>(relays, HttpStatus.OK);
    }

    /**
     * Update a sensor state
     */
    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Void> updateState(@PathVariable(value = "id") int id,
                                            @ModelAttribute(value="state") boolean state) throws NotFoundException {
        this.relayService.updateState(id, state);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
