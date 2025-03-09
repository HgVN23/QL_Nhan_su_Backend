package com.project.QL_Nhan_su_Backend.service.impl;

import com.project.QL_Nhan_su_Backend.dto.LuongDto;
import com.project.QL_Nhan_su_Backend.entity.Luong;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import com.project.QL_Nhan_su_Backend.mapper.LuongMapper;
import com.project.QL_Nhan_su_Backend.repository.LuongRepository;
import com.project.QL_Nhan_su_Backend.service.LuongService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LuongServiceImpl implements LuongService {

    private LuongRepository luongRepository;

    public LuongServiceImpl(LuongRepository luongRepository) {
        this.luongRepository = luongRepository;
    }

    @Override
    public LuongDto createLuong(LuongDto luongDto) {
        Luong luong = LuongMapper.mapToLuong(luongDto);
        luong.setThoiGianTao(LocalDateTime.now());
        Luong savedLuong = luongRepository.save(luong);

        return LuongMapper.mapToLuongDto(savedLuong);
    }

    @Override
    public List<LuongDto> getAllLuong() {
        List<Luong> luongs = luongRepository.findAll();

        return luongs.stream()
                .map(LuongMapper::mapToLuongDto)
                .collect(Collectors.toList());
    }

    @Override
    public LuongDto getLuongById(Long id) {
        Luong luong = luongRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Luong not found"));

        return LuongMapper.mapToLuongDto(luong);
    }

    @Override
    public LuongDto updateLuong(Long id, LuongDto luongDto) {
        Luong luong = luongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Luong not found"));

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(luongDto.getMaNhanVien());
        luong.setMaNhanVien(nhanVien.getMaNhanVien() != null ? nhanVien : null);

        luong.setLuongCoBan(luongDto.getLuongCoBan());
        luong.setLuongLamThem(luongDto.getThuong());
        luong.setTruLuong(luongDto.getTruLuong());
        luong.setNgayTraLuong(luongDto.getNgayTraLuong());
        luong.setTrangThai(luongDto.getTrangThai());
        luong.setThoiGianCapNhat(LocalDateTime.now());
        Luong savedLuong = luongRepository.save(luong);

        return LuongMapper.mapToLuongDto(savedLuong);
    }

    @Override
    public void deleteLuong(Long id) {
        Luong luong = luongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Luong not found"));

        luongRepository.delete(luong);
    }
}
