package com.hudela.vanilla.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelayDto {

    private int id;
    private String name;
    private int battery;
    private boolean state;

}
