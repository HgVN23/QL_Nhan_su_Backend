package com.project.QL_Nhan_su_Backend.controller;

import com.project.QL_Nhan_su_Backend.dto.BaoCaoDto;
import com.project.QL_Nhan_su_Backend.service.BaoCaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/baoCao")
public class BaoCaoController {

    private BaoCaoService baoCaoService;

    public BaoCaoController(BaoCaoService baoCaoService) {
        this.baoCaoService = baoCaoService;
    }

    // http://localhost:8080/api/baoCao
    @PostMapping
    public ResponseEntity<BaoCaoDto> createBaoCao(@RequestBody BaoCaoDto baoCaoDto) {
        return new ResponseEntity<>(baoCaoService.createBaoCao(baoCaoDto), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/baoCao
    @GetMapping
    public ResponseEntity<List<BaoCaoDto>> getAllBaoCao() {
        List<BaoCaoDto> baoCaos = baoCaoService.getAllBaoCao();

        return ResponseEntity.ok(baoCaos);
    }

    // http://localhost:8080/api/baoCao/1
    @GetMapping("/{id}")
    public ResponseEntity<BaoCaoDto> getBaoCaoById(@PathVariable Long id) {
        BaoCaoDto baoCaoDto = baoCaoService.getBaoCaoById(id);

        return ResponseEntity.ok(baoCaoDto);
    }

    // http://localhost:8080/api/baoCao/1
    @PutMapping("/{id}")
    public ResponseEntity<BaoCaoDto> updateBaoCao(@PathVariable Long id, @RequestBody BaoCaoDto baoCaoDto) {
        BaoCaoDto updatedBaoCao = baoCaoService.updateBaoCao(id, baoCaoDto);

        return ResponseEntity.ok(updatedBaoCao);
    }

    // http://localhost:8080/api/baoCao/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBaoCao(@PathVariable Long id) {
        baoCaoService.deleteBaoCao(id);

        return ResponseEntity.ok(Map.of("message", "BaoCao deleted successfully"));
    }
}
