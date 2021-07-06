package com.olibersystem.bursatil.bursatilia.dtos.etoro.candles;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandleValueDTO {
    @JsonProperty("InstrumentID")
    private Long instrumentID;
    @JsonProperty("FromDate")
    private String fromDate;
    @JsonProperty("Open")
    private Double open;
    @JsonProperty("High")
    private Double high;
    @JsonProperty("Low")
    private Double low;
    @JsonProperty("Close")
    private Double close;
}
