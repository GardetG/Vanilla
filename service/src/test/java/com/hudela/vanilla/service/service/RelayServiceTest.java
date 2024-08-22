package com.hudela.vanilla.service.service;

import com.hudela.vanilla.service.domain.Relay;
import com.hudela.vanilla.service.repository.RelayRepository;
import com.hudela.vanilla.service.service.impl.RelayServiceImpl;
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
class RelayServiceTest {

    @Mock
    RelayRepository relayRepository;

    @InjectMocks
    RelayServiceImpl relayService ;

    @Test
    public void when_getAll_should_return_full_list() {
        // Given
        Relay relay1 = new Relay();
        relay1.setId(0);
        relay1.setName("Relay1");
        Relay relay2 = new Relay();
        relay2.setId(1);
        relay2.setName("Relay2");
        when(relayRepository.findAll()).thenReturn(List.of(relay1, relay2));

        // When
        List<Relay> relays = this.relayService.getAll();

        // Then
        assertThat(relays).containsExactly(relay1, relay2);
    }

    @Test
    public void when_updateState_should_update_state() throws NotFoundException {
        // Given
        Relay relay1 = new Relay();
        relay1.setId(1);
        relay1.setName("Relay1");
        relay1.setState(false);
        when(relayRepository.findById(anyInt())).thenReturn(Optional.of(relay1));

        // When
        this.relayService.updateState(1, true);

        // Then
        assertThat(relay1.getState()).isTrue();
        verify(relayRepository, times(1)).findById(1);
    }

    @Test
    public void when_updateState_should_throws_exception() {
        // Given
        when(relayRepository.findById(anyInt())).thenReturn(Optional.empty());

        // When
        assertThatThrownBy(() -> this.relayService.updateState(1, true))
        // Then
                .isInstanceOf(NotFoundException.class);
    }

}