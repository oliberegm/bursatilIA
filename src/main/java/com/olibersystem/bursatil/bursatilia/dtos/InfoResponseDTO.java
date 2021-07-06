package com.olibersystem.bursatil.bursatilia.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class InfoResponseDTO implements Serializable {
    private Double data;
}
