package staj.RESTAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import staj.RESTAPI.dto.KisiDto;
import staj.RESTAPI.service.KisiService;

import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor//
public class KisiController {
    private final KisiService kisiService;  // kisiService'in save metoduna kisiDto gönderdik
    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto){
        return ResponseEntity.ok(kisiService.save(kisiDto));
    }


    @GetMapping
    public ResponseEntity<List<KisiDto>> tumunuListele(){
        return ResponseEntity.ok(kisiService.getAll());
    }



}
