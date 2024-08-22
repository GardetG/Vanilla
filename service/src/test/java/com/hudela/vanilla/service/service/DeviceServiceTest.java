package com.hudela.vanilla.service.service;

import com.hudela.vanilla.service.domain.Relay;
import com.hudela.vanilla.service.domain.Sensor;
import com.hudela.vanilla.service.service.impl.DeviceServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class DeviceServiceTest {

    @Mock
    SensorService sensorService;
    @Mock
    RelayService relayService;

    @InjectMocks
    DeviceServiceImpl updateService ;

    @Test
    void when_update_should_take_less_than_5_secondes() {
        // Given
        Sensor sensor1 = new Sensor();
        Sensor sensor2 = new Sensor();
        Sensor sensor3 = new Sensor();
        Relay relay1 = new Relay();
        Relay relay2 = new Relay();
        when(sensorService.getAll()).thenReturn(List.of(sensor1, sensor2, sensor3));
        when(relayService.getAll()).thenReturn(List.of(relay1, relay2));

        // When
        long duration = this.updateService.update();

        // Then
        assertThat(duration).isLessThan(5);
    }
}