package com.project.QL_Nhan_su_Backend.controller;

import com.project.QL_Nhan_su_Backend.dto.NguoiDungDto;
import com.project.QL_Nhan_su_Backend.service.NguoiDungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nguoiDung")
public class NguoiDungController {

    private NguoiDungService nguoiDungService;

    public NguoiDungController(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }

    // http://localhost:8080/api/nguoiDung
    @PostMapping
    public ResponseEntity<NguoiDungDto> createNguoiDung(@RequestBody NguoiDungDto nguoiDungDto) {
        return new ResponseEntity<>(nguoiDungService.createNguoiDung(nguoiDungDto), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/nguoiDung
    @GetMapping
    public ResponseEntity<List<NguoiDungDto>> getAllNguoiDung() {
        List<NguoiDungDto> nguoiDungs = nguoiDungService.getAllNguoiDung();

        return ResponseEntity.ok(nguoiDungs);
    }

    // http://localhost:8080/api/nguoiDung/1
    @GetMapping("/{id}")
    public ResponseEntity<NguoiDungDto> getNguoiDungById(@PathVariable Long id) {
        NguoiDungDto nguoiDungDto = nguoiDungService.getNguoiDungById(id);

        return ResponseEntity.ok(nguoiDungDto);
    }

    // http://localhost:8080/api/nguoiDung/1
    @PutMapping("/{id}")
    public ResponseEntity<NguoiDungDto> updateNguoiDung(@PathVariable Long id, @RequestBody NguoiDungDto nguoiDungDto) {
        NguoiDungDto updatedNguoiDung = nguoiDungService.updateNguoiDung(id, nguoiDungDto);

        return ResponseEntity.ok(updatedNguoiDung);
    }

    // http://localhost:8080/api/nguoiDung/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteNguoiDung(@PathVariable Long id) {
        nguoiDungService.deleteNguoiDung(id);

        return ResponseEntity.ok(Map.of("message", "NguoiDung deleted successfully"));
    }

    // http://localhost:8080/api/nguoiDung/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String tenNguoiDung = loginRequest.get("tenNguoiDung");
        String matKhau = loginRequest.get("matKhau");

        try {
            NguoiDungDto nguoiDungDto = nguoiDungService.login(tenNguoiDung, matKhau);
            return ResponseEntity.ok(nguoiDungDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
