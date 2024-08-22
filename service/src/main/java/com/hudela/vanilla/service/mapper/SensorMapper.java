package com.hudela.vanilla.service.mapper;

import com.hudela.vanilla.service.domain.Sensor;
import com.hudela.vanilla.service.dto.SensorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SensorMapper {

    @Mapping(target = "constructor", source = "model.constructor")
    SensorDto toDto(Sensor sensor);
    List<SensorDto> toDtos(List<Sensor> sensors);
}
