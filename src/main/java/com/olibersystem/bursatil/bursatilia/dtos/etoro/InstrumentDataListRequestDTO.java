package com.olibersystem.bursatil.bursatilia.dtos.etoro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentDataListRequestDTO {
    @JsonProperty("InstrumentDisplayDatas")
    private InstrumentDataRequestDTO[] instrumentDisplayDatas;
}
