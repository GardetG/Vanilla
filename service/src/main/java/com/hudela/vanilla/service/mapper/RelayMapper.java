package com.hudela.vanilla.service.mapper;

import com.hudela.vanilla.service.domain.Relay;
import com.hudela.vanilla.service.dto.RelayDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RelayMapper {

    RelayDto toDto(Relay relay);
    List<RelayDto> toDtos(List<Relay> relays);
}
