package com.project.QL_Nhan_su_Backend.service.impl;

import com.project.QL_Nhan_su_Backend.dto.NguoiDungDto;
import com.project.QL_Nhan_su_Backend.entity.NguoiDung;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import com.project.QL_Nhan_su_Backend.mapper.NguoiDungMapper;
import com.project.QL_Nhan_su_Backend.repository.NguoiDungRepository;
import com.project.QL_Nhan_su_Backend.service.NguoiDungService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    private NguoiDungRepository nguoiDungRepository;

    public NguoiDungServiceImpl(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }

    @Override
    public NguoiDungDto createNguoiDung(NguoiDungDto nguoiDungDto) {
        NguoiDung nguoiDung = NguoiDungMapper.mapToNguoiDung(nguoiDungDto);
        nguoiDung.setThoiGianTao(LocalDateTime.now());
        NguoiDung savedNguoiDung = nguoiDungRepository.save(nguoiDung);

        return NguoiDungMapper.mapToNguoiDungDto(savedNguoiDung);
    }

    @Override
    public List<NguoiDungDto> getAllNguoiDung() {
        List<NguoiDung> nguoiDungs = nguoiDungRepository.findAll();

        return nguoiDungs.stream()
                .map(NguoiDungMapper::mapToNguoiDungDto)
                .collect(Collectors.toList());
    }

    @Override
    public NguoiDungDto getNguoiDungById(Long id) {
        NguoiDung nguoiDung = nguoiDungRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("NguoiDung not found"));

        return NguoiDungMapper.mapToNguoiDungDto(nguoiDung);
    }

    @Override
    public NguoiDungDto updateNguoiDung(Long id, NguoiDungDto nguoiDungDto) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NguoiDung not found"));

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(nguoiDungDto.getMaNhanVien());
        nguoiDung.setMaNhanVien(nhanVien.getMaNhanVien() != null ? nhanVien : null);

        nguoiDung.setTenNguoiDung(nguoiDungDto.getTenNguoiDung());
        nguoiDung.setMatKhau(nguoiDungDto.getMatKhau());
        nguoiDung.setVaiTro(nguoiDungDto.getVaiTro());
        nguoiDung.setThoiGianCapNhat(LocalDateTime.now());
        NguoiDung savedNguoiDung = nguoiDungRepository.save(nguoiDung);

        return NguoiDungMapper.mapToNguoiDungDto(savedNguoiDung);
    }

    @Override
    public void deleteNguoiDung(Long id) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NguoiDung not found"));

        nguoiDungRepository.delete(nguoiDung);
    }

    @Override
    public NguoiDungDto login(String tenNguoiDung, String matKhau) {
        NguoiDung nguoiDung = nguoiDungRepository.findByTenNguoiDung(tenNguoiDung)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!nguoiDung.getMatKhau().equals(matKhau)) {
            throw new RuntimeException("Invalid username or password");
        }

        return NguoiDungMapper.mapToNguoiDungDto(nguoiDung);
    }

    @Override
    public List<NguoiDungDto> getNguoiDungWithPagination(String tenNguoiDung, int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<NguoiDung> nguoiDungPage;

        if (tenNguoiDung != null && !tenNguoiDung.isEmpty()) {
            nguoiDungPage = nguoiDungRepository.findByTenNguoiDungContainingIgnoreCase(tenNguoiDung, pageable);
        } else {
            nguoiDungPage = nguoiDungRepository.findAll(pageable);
        }

        return nguoiDungPage.stream()
                .map(NguoiDungMapper::mapToNguoiDungDto)
                .collect(Collectors.toList());
    }


    public long getMaxNguoiDung() {
        return nguoiDungRepository.count();
    }
}
