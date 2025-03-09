package com.project.QL_Nhan_su_Backend.controller;

import com.project.QL_Nhan_su_Backend.dto.DanhGiaHieuSuatDto;
import com.project.QL_Nhan_su_Backend.service.DanhGiaHieuSuatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/danhGiaHieuSuat")
public class DanhGiaHieuSuatController {

    private DanhGiaHieuSuatService danhGiaHieuSuatService;

    public DanhGiaHieuSuatController(DanhGiaHieuSuatService danhGiaHieuSuatService) {
        this.danhGiaHieuSuatService = danhGiaHieuSuatService;
    }

    // http://localhost:8080/api/danhGiaHieuSuat
    @PostMapping
    public ResponseEntity<DanhGiaHieuSuatDto> createDanhGiaHieuSuat(@RequestBody DanhGiaHieuSuatDto danhGiaHieuSuatDto) {
        return new ResponseEntity<>(danhGiaHieuSuatService.createDanhGiaHieuSuat(danhGiaHieuSuatDto), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/danhGiaHieuSuat
    @GetMapping
    public ResponseEntity<List<DanhGiaHieuSuatDto>> getAllDanhGiaHieuSuat() {
        List<DanhGiaHieuSuatDto> danhGiaHieuSuats = danhGiaHieuSuatService.getAllDanhGiaHieuSuat();

        return ResponseEntity.ok(danhGiaHieuSuats);
    }

    // http://localhost:8080/api/danhGiaHieuSuat/1
    @GetMapping("/{id}")
    public ResponseEntity<DanhGiaHieuSuatDto> getDanhGiaHieuSuatById(@PathVariable Long id) {
        DanhGiaHieuSuatDto danhGiaHieuSuatDto = danhGiaHieuSuatService.getDanhGiaHieuSuatById(id);

        return ResponseEntity.ok(danhGiaHieuSuatDto);
    }

    // http://localhost:8080/api/danhGiaHieuSuat/1
    @PutMapping("/{id}")
    public ResponseEntity<DanhGiaHieuSuatDto> updateDanhGiaHieuSuat(@PathVariable Long id, @RequestBody DanhGiaHieuSuatDto danhGiaHieuSuatDto) {
        DanhGiaHieuSuatDto updatedDanhGiaHieuSuat = danhGiaHieuSuatService.updateDanhGiaHieuSuat(id, danhGiaHieuSuatDto);

        return ResponseEntity.ok(updatedDanhGiaHieuSuat);
    }

    // http://localhost:8080/api/danhGiaHieuSuat/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDanhGiaHieuSuat(@PathVariable Long id) {
        danhGiaHieuSuatService.deleteDanhGiaHieuSuat(id);

        return ResponseEntity.ok(Map.of("message", "DanhGiaHieuSuat deleted successfully"));
    }
}
