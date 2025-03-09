package com.project.QL_Nhan_su_Backend.controller;

import com.project.QL_Nhan_su_Backend.dto.ChamCongDto;
import com.project.QL_Nhan_su_Backend.service.ChamCongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chamCong")
public class ChamCongController {

    private ChamCongService chamCongService;

    public ChamCongController(ChamCongService chamCongService) {
        this.chamCongService = chamCongService;
    }

    // http://localhost:8080/api/chamCong
    @PostMapping
    public ResponseEntity<ChamCongDto> createChamCong(@RequestBody ChamCongDto chamCongDto) {
        return new ResponseEntity<>(chamCongService.createChamCong(chamCongDto), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/chamCong
    @GetMapping
    public ResponseEntity<List<ChamCongDto>> getAllChamCong() {
        List<ChamCongDto> chamCongs = chamCongService.getAllChamCong();

        return ResponseEntity.ok(chamCongs);
    }

    // http://localhost:8080/api/chamCong/1
    @GetMapping("/{id}")
    public ResponseEntity<ChamCongDto> getChamCongById(@PathVariable Long id) {
        ChamCongDto chamCongDto = chamCongService.getChamCongById(id);

        return ResponseEntity.ok(chamCongDto);
    }

    // http://localhost:8080/api/chamCong/1
    @PutMapping("/{id}")
    public ResponseEntity<ChamCongDto> updateChamCong(@PathVariable Long id, @RequestBody ChamCongDto chamCongDto) {
        ChamCongDto updatedChamCong = chamCongService.updateChamCong(id, chamCongDto);

        return ResponseEntity.ok(updatedChamCong);
    }

    // http://localhost:8080/api/chamCong/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteChamCong(@PathVariable Long id) {
        chamCongService.deleteChamCong(id);

        return ResponseEntity.ok(Map.of("message", "ChamCong deleted successfully"));
    }
}
