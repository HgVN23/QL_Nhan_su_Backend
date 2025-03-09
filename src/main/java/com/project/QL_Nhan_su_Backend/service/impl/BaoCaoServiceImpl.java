package com.project.QL_Nhan_su_Backend.service.impl;

import com.project.QL_Nhan_su_Backend.dto.BaoCaoDto;
import com.project.QL_Nhan_su_Backend.entity.BaoCao;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import com.project.QL_Nhan_su_Backend.mapper.BaoCaoMapper;
import com.project.QL_Nhan_su_Backend.repository.BaoCaoRepository;
import com.project.QL_Nhan_su_Backend.service.BaoCaoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaoCaoServiceImpl implements BaoCaoService {

    private BaoCaoRepository baoCaoRepository;

    public BaoCaoServiceImpl(BaoCaoRepository baoCaoRepository) {
        this.baoCaoRepository = baoCaoRepository;
    }

    @Override
    public BaoCaoDto createBaoCao(BaoCaoDto baoCaoDto) {
        BaoCao baoCao = BaoCaoMapper.mapToBaoCao(baoCaoDto);
        baoCao.setThoiGianTao(LocalDateTime.now());
        BaoCao savedBaoCao = baoCaoRepository.save(baoCao);

        return BaoCaoMapper.mapToBaoCaoDto(savedBaoCao);
    }

    @Override
    public List<BaoCaoDto> getAllBaoCao() {
        List<BaoCao> baoCaos = baoCaoRepository.findAll();

        return baoCaos.stream()
                .map(BaoCaoMapper::mapToBaoCaoDto)
                .collect(Collectors.toList());
    }

    @Override
    public BaoCaoDto getBaoCaoById(Long id) {
        BaoCao baoCao = baoCaoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("BaoCao not found"));

        return BaoCaoMapper.mapToBaoCaoDto(baoCao);
    }

    @Override
    public BaoCaoDto updateBaoCao(Long id, BaoCaoDto baoCaoDto) {
        BaoCao baoCao = baoCaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BaoCao not found"));

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(baoCaoDto.getMaNhanVien());
        baoCao.setMaNhanVien(nhanVien.getMaNhanVien() != null ? nhanVien : null);

        baoCao.setLoaiBaoCao(baoCaoDto.getLoaiBaoCao());
        baoCao.setNoiDung(baoCaoDto.getNoiDung());
        baoCao.setThoiGianCapNhat(LocalDateTime.now());
        BaoCao savedBaoCao = baoCaoRepository.save(baoCao);

        return BaoCaoMapper.mapToBaoCaoDto(savedBaoCao);
    }

    @Override
    public void deleteBaoCao(Long id) {
        BaoCao baoCao = baoCaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BaoCao not found"));

        baoCaoRepository.delete(baoCao);
    }
}
