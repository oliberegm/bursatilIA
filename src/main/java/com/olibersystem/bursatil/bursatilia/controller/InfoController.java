package com.olibersystem.bursatil.bursatilia.controller;

import com.olibersystem.bursatil.bursatilia.dtos.InfoResponseDTO;
import com.olibersystem.bursatil.bursatilia.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ia/api/v1/info")
@Slf4j
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }


    @GetMapping("xor/{eval1}/{eval2}")
    public ResponseEntity<InfoResponseDTO> xor(@PathVariable("eval1") Double eval1,
                                               @PathVariable("eval2") Double eval2) {
        log.info("init call xor");
        InfoResponseDTO resp = infoService.xorInfo(eval1, eval2);
        ResponseEntity<InfoResponseDTO> response = new ResponseEntity(resp, HttpStatus.OK);
        log.info("end call xor");
        return response;
    }
}
