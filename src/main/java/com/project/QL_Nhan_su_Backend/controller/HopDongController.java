package com.project.QL_Nhan_su_Backend.controller;

import com.project.QL_Nhan_su_Backend.dto.HopDongDto;
import com.project.QL_Nhan_su_Backend.service.HopDongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hopDong")
public class HopDongController {

    private HopDongService hopDongService;

    public HopDongController(HopDongService hopDongService) {
        this.hopDongService = hopDongService;
    }

    // http://localhost:8080/api/hopDong
    @PostMapping
    public ResponseEntity<HopDongDto> createHopDong(@RequestBody HopDongDto hopDongDto) {
        return new ResponseEntity<>(hopDongService.createHopDong(hopDongDto), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/hopDong
    @GetMapping
    public ResponseEntity<List<HopDongDto>> getAllHopDong() {
        List<HopDongDto> hopDongs = hopDongService.getAllHopDong();

        return ResponseEntity.ok(hopDongs);
    }

    // http://localhost:8080/api/hopDong/1
    @GetMapping("/{id}")
    public ResponseEntity<HopDongDto> getHopDongById(@PathVariable Long id) {
        HopDongDto hopDongDto = hopDongService.getHopDongById(id);

        return ResponseEntity.ok(hopDongDto);
    }

    // http://localhost:8080/api/hopDong/1
    @PutMapping("/{id}")
    public ResponseEntity<HopDongDto> updateHopDong(@PathVariable Long id, @RequestBody HopDongDto hopDongDto) {
        HopDongDto updatedHopDong = hopDongService.updateHopDong(id, hopDongDto);

        return ResponseEntity.ok(updatedHopDong);
    }

    // http://localhost:8080/api/hopDong/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteHopDong(@PathVariable Long id) {
        hopDongService.deleteHopDong(id);

        return ResponseEntity.ok(Map.of("message", "HopDong deleted successfully"));
    }
}
