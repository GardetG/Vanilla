package com.hudela.vanilla.service.service;

import com.hudela.vanilla.service.domain.Model;
import com.hudela.vanilla.service.domain.Sensor;
import com.hudela.vanilla.service.repository.SensorRepository;
import com.hudela.vanilla.service.service.impl.SensorServiceImpl;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
class SensorServiceTest {

    @Mock
    SensorRepository sensorRepository;

    @InjectMocks
    SensorServiceImpl sensorService;

    @Test
    public void when_getAll_should_return_full_list() {
        // Given
        Sensor sensor1 = new Sensor();
        sensor1.setId(0);
        sensor1.setName("Sensor1");
        sensor1.setModel(new Model());
        Sensor sensor2 = new Sensor();
        sensor2.setId(1);
        sensor2.setName("Sensor2");
        sensor2.setModel(new Model());
        when(sensorRepository.findAll()).thenReturn(List.of(sensor1, sensor2));

        // When
        List<Sensor> sensors = this.sensorService.getAll();

        // Then
        assertThat(sensors).containsExactly(sensor1, sensor2);
    }

    @Test
    public void when_getAll_should_return_batteries() {
        // Given
        Model model1 = new Model();
        model1.setConstructor("Constructor1");
        model1.setName("Model1");
        model1.setVoltMax(100);
        Sensor sensor1 = new Sensor();
        sensor1.setId(0);
        sensor1.setName("Sensor1");
        sensor1.setVolt(50);
        sensor1.setModel(model1);
        when(sensorRepository.findAll()).thenReturn(List.of(sensor1));

        // When
        List<Sensor> sensors = this.sensorService.getAll();

        // Then
        assertThat(sensors).isNotEmpty();
        assertThat(sensors.get(0).getBattery()).isEqualTo(50);
    }

    @Test
    public void when_updateState_should_update_state() throws NotFoundException {
        // Given
        Sensor sensor1 = new Sensor();
        sensor1.setId(1);
        sensor1.setName("Sensor1");
        sensor1.setState(false);
        sensor1.setModel(new Model());
        when(sensorRepository.findById(anyInt())).thenReturn(Optional.of(sensor1));

        // When
        this.sensorService.updateState(1, true);

        // Then
        assertThat(sensor1.getState()).isTrue();
        verify(sensorRepository, times(1)).findById(1);
    }

    @Test
    public void when_updateState_should_throws_exception() {
        // Given
        when(sensorRepository.findById(anyInt())).thenReturn(Optional.empty());

        // When
        assertThatThrownBy(() -> this.sensorService.updateState(1, true))
                // Then
                .isInstanceOf(NotFoundException.class);
    }

}