package com.project.QL_Nhan_su_Backend.controller;

import com.project.QL_Nhan_su_Backend.dto.NhanVienDto;
import com.project.QL_Nhan_su_Backend.service.NhanVienService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nhanVien")
public class NhanVienController {

    private NhanVienService nhanVienService;

    public NhanVienController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    // http://localhost:8080/api/nhanVien
    @PostMapping
    public ResponseEntity<NhanVienDto> createNhanVien(@RequestBody NhanVienDto nhanVienDto) {
        return new ResponseEntity<>(nhanVienService.createNhanVien(nhanVienDto), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/nhanVien
    @GetMapping
    public ResponseEntity<List<NhanVienDto>> getAllNhanVien() {
        List<NhanVienDto> nhanViens = nhanVienService.getAllNhanVien();

        return ResponseEntity.ok(nhanViens);
    }

    // http://localhost:8080/api/nhanVien/1
    @GetMapping("/{id}")
    public ResponseEntity<NhanVienDto> getNhanVienById(@PathVariable Long id) {
        NhanVienDto nhanVienDto = nhanVienService.getNhanVienById(id);

        return ResponseEntity.ok(nhanVienDto);
    }

    // http://localhost:8080/api/nhanVien/1
    @PutMapping("/{id}")
    public ResponseEntity<NhanVienDto> updateNhanVien(@PathVariable Long id, @RequestBody NhanVienDto nhanVienDto) {
        NhanVienDto updatedNhanVien = nhanVienService.updateNhanVien(id, nhanVienDto);

        return ResponseEntity.ok(updatedNhanVien);
    }

    // http://localhost:8080/api/nhanVien/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteNhanVien(@PathVariable Long id) {
        nhanVienService.deleteNhanVien(id);

        return ResponseEntity.ok(Map.of("message", "NhanVien deleted successfully"));
    }
}
