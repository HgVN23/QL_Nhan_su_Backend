package com.project.QL_Nhan_su_Backend.service.impl;

import com.project.QL_Nhan_su_Backend.dto.ChamCongDto;
import com.project.QL_Nhan_su_Backend.entity.ChamCong;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import com.project.QL_Nhan_su_Backend.mapper.ChamCongMapper;
import com.project.QL_Nhan_su_Backend.repository.ChamCongRepository;
import com.project.QL_Nhan_su_Backend.service.ChamCongService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChamCongServiceImpl implements ChamCongService {

    private ChamCongRepository chamCongRepository;

    public ChamCongServiceImpl(ChamCongRepository chamCongRepository) {
        this.chamCongRepository = chamCongRepository;
    }

    @Override
    public ChamCongDto createChamCong(ChamCongDto chamCongDto) {
        ChamCong chamCong = ChamCongMapper.mapToChamCong(chamCongDto);
        chamCong.setThoiGianTao(LocalDateTime.now());
        ChamCong savedChamCong = chamCongRepository.save(chamCong);

        return ChamCongMapper.mapToChamCongDto(savedChamCong);
    }

    @Override
    public List<ChamCongDto> getAllChamCong() {
        List<ChamCong> chamCongs = chamCongRepository.findAll();

        return chamCongs.stream()
                .map(ChamCongMapper::mapToChamCongDto)
                .collect(Collectors.toList());
    }

    @Override
    public ChamCongDto getChamCongById(Long id) {
        ChamCong chamCong = chamCongRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("ChamCong not found"));

        return ChamCongMapper.mapToChamCongDto(chamCong);
    }

    @Override
    public ChamCongDto updateChamCong(Long id, ChamCongDto chamCongDto) {
        ChamCong chamCong = chamCongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChamCong not found"));

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(chamCongDto.getMaNhanVien());
        chamCong.setMaNhanVien(nhanVien.getMaNhanVien() != null ? nhanVien : null);

        chamCong.setNgayLam(chamCongDto.getNgayLam());
        chamCong.setThoiGianBatDau(chamCongDto.getThoiGianBatDau());
        chamCong.setThoiGianKetThuc(chamCongDto.getThoiGianKetThuc());
        chamCong.setSoGioLam(chamCongDto.getSoGioLam());
        chamCong.setSoGioLamThem(chamCongDto.getSoGioLamThem());
        chamCong.setThoiGianCapNhat(LocalDateTime.now());
        ChamCong savedChamCong = chamCongRepository.save(chamCong);

        return ChamCongMapper.mapToChamCongDto(savedChamCong);
    }

    @Override
    public void deleteChamCong(Long id) {
        ChamCong chamCong = chamCongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChamCong not found"));

        chamCongRepository.delete(chamCong);
    }
}
