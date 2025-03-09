package com.project.QL_Nhan_su_Backend.service.impl;

import com.project.QL_Nhan_su_Backend.dto.DanhGiaHieuSuatDto;
import com.project.QL_Nhan_su_Backend.entity.DanhGiaHieuSuat;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import com.project.QL_Nhan_su_Backend.mapper.DanhGiaHieuSuatMapper;
import com.project.QL_Nhan_su_Backend.repository.DanhGiaHieuSuatRepository;
import com.project.QL_Nhan_su_Backend.service.DanhGiaHieuSuatService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DanhGiaHieuSuatServiceImpl implements DanhGiaHieuSuatService {

    private DanhGiaHieuSuatRepository danhGiaHieuSuatRepository;

    public DanhGiaHieuSuatServiceImpl(DanhGiaHieuSuatRepository danhGiaHieuSuatRepository) {
        this.danhGiaHieuSuatRepository = danhGiaHieuSuatRepository;
    }

    @Override
    public DanhGiaHieuSuatDto createDanhGiaHieuSuat(DanhGiaHieuSuatDto danhGiaHieuSuatDto) {
        DanhGiaHieuSuat danhGiaHieuSuat = DanhGiaHieuSuatMapper.mapToDanhGiaHieuSuat(danhGiaHieuSuatDto);
        danhGiaHieuSuat.setThoiGianTao(LocalDateTime.now());
        DanhGiaHieuSuat savedDanhGiaHieuSuat = danhGiaHieuSuatRepository.save(danhGiaHieuSuat);

        return DanhGiaHieuSuatMapper.mapToDanhGiaHieuSuatDto(savedDanhGiaHieuSuat);
    }

    @Override
    public List<DanhGiaHieuSuatDto> getAllDanhGiaHieuSuat() {
        List<DanhGiaHieuSuat> danhGiaHieuSuats = danhGiaHieuSuatRepository.findAll();

        return danhGiaHieuSuats.stream()
                .map(DanhGiaHieuSuatMapper::mapToDanhGiaHieuSuatDto)
                .collect(Collectors.toList());
    }

    @Override
    public DanhGiaHieuSuatDto getDanhGiaHieuSuatById(Long id) {
        DanhGiaHieuSuat danhGiaHieuSuat = danhGiaHieuSuatRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("DanhGiaHieuSuat not found"));

        return DanhGiaHieuSuatMapper.mapToDanhGiaHieuSuatDto(danhGiaHieuSuat);
    }

    @Override
    public DanhGiaHieuSuatDto updateDanhGiaHieuSuat(Long id, DanhGiaHieuSuatDto danhGiaHieuSuatDto) {
        DanhGiaHieuSuat danhGiaHieuSuat = danhGiaHieuSuatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DanhGiaHieuSuat not found"));

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(danhGiaHieuSuatDto.getMaNhanVien());
        danhGiaHieuSuat.setMaNhanVien(nhanVien.getMaNhanVien() != null ? nhanVien : null);

        danhGiaHieuSuat.setDiem(danhGiaHieuSuatDto.getDiem());
        danhGiaHieuSuat.setNoiDung(danhGiaHieuSuatDto.getNoiDung());
        danhGiaHieuSuat.setThoiGianCapNhat(LocalDateTime.now());
        DanhGiaHieuSuat savedDanhGiaHieuSuat = danhGiaHieuSuatRepository.save(danhGiaHieuSuat);

        return DanhGiaHieuSuatMapper.mapToDanhGiaHieuSuatDto(savedDanhGiaHieuSuat);
    }

    @Override
    public void deleteDanhGiaHieuSuat(Long id) {
        DanhGiaHieuSuat danhGiaHieuSuat = danhGiaHieuSuatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DanhGiaHieuSuat not found"));

        danhGiaHieuSuatRepository.delete(danhGiaHieuSuat);
    }
}
