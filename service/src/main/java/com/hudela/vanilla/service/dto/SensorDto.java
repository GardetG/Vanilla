package com.hudela.vanilla.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDto {

    private int id;
    private String name;
    private String constructor;
    private int battery;
    private boolean state;

}
