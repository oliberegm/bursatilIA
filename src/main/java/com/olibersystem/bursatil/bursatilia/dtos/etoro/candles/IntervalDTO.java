package com.olibersystem.bursatil.bursatilia.dtos.etoro.candles;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IntervalDTO implements Serializable {
    @JsonProperty("InstrumentId")
    private Long instrumentId;
    @JsonProperty("Candles")
    private List<CandleDTO> candles;
}
