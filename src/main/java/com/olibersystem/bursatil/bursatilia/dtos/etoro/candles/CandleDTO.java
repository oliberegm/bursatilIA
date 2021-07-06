package com.olibersystem.bursatil.bursatilia.dtos.etoro.candles;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandleDTO implements Serializable {
    @JsonProperty("Interval")
    private String iInterval;
    @JsonProperty("Candles")
    private List<CandleValueDTO> candles;
    @JsonProperty("RangeOpen")
    private Double rangeOpen;
    @JsonProperty("RangeClose")
    private Double rangeClose;
    @JsonProperty("RangeHigh")
    private Double rangeHigh;
    @JsonProperty("RangeLow")
    private Double rangeLow;
}
