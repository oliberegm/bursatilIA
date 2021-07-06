package com.olibersystem.bursatil.bursatilia.converts;

import com.olibersystem.bursatil.bursatilia.dtos.InfoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class InfoConver {
    public InfoResponseDTO infoResponseDTOToDouble(Double resp) {
        return InfoResponseDTO.builder()
                .data(resp)
                .build();
    }
}
