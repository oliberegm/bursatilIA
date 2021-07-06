package com.olibersystem.bursatil.bursatilia.traders;

import com.olibersystem.bursatil.bursatilia.config.TaskConfig;
import com.olibersystem.bursatil.bursatilia.converts.CandleConvert;
import com.olibersystem.bursatil.bursatilia.converts.InstrumentDataConvert;
import com.olibersystem.bursatil.bursatilia.dtos.etoro.InstrumentDataListRequestDTO;
import com.olibersystem.bursatil.bursatilia.dtos.etoro.candles.IntervalDTO;
import com.olibersystem.bursatil.bursatilia.model.etoro.Candles;
import com.olibersystem.bursatil.bursatilia.model.etoro.InstrumentData;
import com.olibersystem.bursatil.bursatilia.repository.etoro.CandlesRepository;
import com.olibersystem.bursatil.bursatilia.repository.etoro.InstrumentDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
@Slf4j
public class Etoro {
    private final WebClient webClient;
    private final InstrumentDataRepository instrumentDataRepository;
    private final CandlesRepository candlesRepository;
    private final static String URL_DATA = "https://api.etorostatic.com/sapi/instrumentsmetadata/V1.1/instruments?cv=5e8db4053cccfb09c2c9ac3ea7cc7d45_e979059b0b4392cb2d4d2aaae4b2";
    private final static String URL_CANDLES1 ="https://candle.etoro.com/candles/desc.json/FiveMinutes/1000/";
    private final static String URL_CANDLES2 ="?client_request_id=30ae72f2-9a6a-4a8d-8e84-2f69e471c8c0";

    public Etoro(WebClient webClient, InstrumentDataRepository instrumentDataRepository, CandlesRepository candlesRepository) {
        this.webClient = webClient;
        this.instrumentDataRepository = instrumentDataRepository;
        this.candlesRepository = candlesRepository;
    }

    /**
     * cargar los datos de las currencys
     */

    @Async(TaskConfig.ETORO_TASK_EXECUTOR)
    @Scheduled(fixedDelay = 1000 * 60 * 60 )
    public void loadCurrencys() {
        webClient.get()
                .uri(URL_DATA)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(InstrumentDataListRequestDTO.class)
                .subscribe(success -> processSuccess(success), throwable -> processError(throwable));
    }

    private void processError(Throwable throwable) {
        log.error("Error into load data base: {}", throwable.getMessage());
        throwable.printStackTrace();
    }

    private void processSuccess(InstrumentDataListRequestDTO success) {
        List<InstrumentData> list = Arrays.stream(success.getInstrumentDisplayDatas())
                .map(InstrumentDataConvert::entityToRequestDTO)
                .collect(Collectors.toList());
        log.info("init save data");
        instrumentDataRepository.saveAll(list);
        log.info("end save data");
    }


    @Async(TaskConfig.ETORO_TASK_EXECUTOR)
    @Scheduled(fixedDelay = 1000 * 60 * 5 )
    public void loadCandles() {
        List<InstrumentData> instrument = instrumentDataRepository.findAll();
        instrument.forEach(ins -> {
            webClient.get()
                    .uri(URL_CANDLES1 + ins.getInstrumentID() + URL_CANDLES2)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(IntervalDTO.class)
                    .subscribe(success -> candlesSuccess(success), throwable -> candlesError(throwable));
        });
    }

    private void candlesError(Throwable throwable) {
        log.error("Error into candles data base: {}", throwable.getMessage());
        throwable.printStackTrace();
    }

    private void candlesSuccess(IntervalDTO success) {
        List<Candles> candles = success.getCandles().stream()
                .map(m -> m.getCandles().stream().map(CandleConvert::toRequestDTO).collect(Collectors.toList()))
                .findFirst().get();
        log.info("save data: {}", success.getInstrumentId());
        candlesRepository.saveAll(candles);
        log.info("end save data {}", success.getInstrumentId());
    }
}
