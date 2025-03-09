package com.project.QL_Nhan_su_Backend.controller;

import com.project.QL_Nhan_su_Backend.dto.LuongDto;
import com.project.QL_Nhan_su_Backend.service.LuongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/luong")
public class LuongController {

    private LuongService luongService;

    public LuongController(LuongService luongService) {
        this.luongService = luongService;
    }

    // http://localhost:8080/api/luong
    @PostMapping
    public ResponseEntity<LuongDto> createLuong(@RequestBody LuongDto luongDto) {
        return new ResponseEntity<>(luongService.createLuong(luongDto), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/luong
    @GetMapping
    public ResponseEntity<List<LuongDto>> getAllLuong() {
        List<LuongDto> luongs = luongService.getAllLuong();

        return ResponseEntity.ok(luongs);
    }

    // http://localhost:8080/api/luong/1
    @GetMapping("/{id}")
    public ResponseEntity<LuongDto> getLuongById(@PathVariable Long id) {
        LuongDto luongDto = luongService.getLuongById(id);

        return ResponseEntity.ok(luongDto);
    }

    // http://localhost:8080/api/luong/1
    @PutMapping("/{id}")
    public ResponseEntity<LuongDto> updateLuong(@PathVariable Long id, @RequestBody LuongDto luongDto) {
        LuongDto updatedLuong = luongService.updateLuong(id, luongDto);

        return ResponseEntity.ok(updatedLuong);
    }

    // http://localhost:8080/api/luong/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteLuong(@PathVariable Long id) {
        luongService.deleteLuong(id);

        return ResponseEntity.ok(Map.of("message", "Luong deleted successfully"));
    }
}
