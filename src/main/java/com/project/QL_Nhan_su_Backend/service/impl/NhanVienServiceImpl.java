package com.project.QL_Nhan_su_Backend.service.impl;

import com.project.QL_Nhan_su_Backend.dto.NhanVienDto;
import com.project.QL_Nhan_su_Backend.dto.NhanVienDto;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import com.project.QL_Nhan_su_Backend.mapper.NhanVienMapper;
import com.project.QL_Nhan_su_Backend.mapper.NhanVienMapper;
import com.project.QL_Nhan_su_Backend.repository.NhanVienRepository;
import com.project.QL_Nhan_su_Backend.service.NhanVienService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository;

    public NhanVienServiceImpl(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }

    @Override
    public NhanVienDto createNhanVien(NhanVienDto nhanVienDto) {
        NhanVien nhanVien = NhanVienMapper.mapToNhanVien(nhanVienDto);
        nhanVien.setThoiGianTao(LocalDateTime.now());
        NhanVien savedNhanVien = nhanVienRepository.save(nhanVien);

        return NhanVienMapper.mapToNhanVienDto(savedNhanVien);
    }

    @Override
    public List<NhanVienDto> getAllNhanVien() {
        List<NhanVien> nhanViens = nhanVienRepository.findAll();

        return nhanViens.stream()
                .map(NhanVienMapper::mapToNhanVienDto)
                .collect(Collectors.toList());
    }

    @Override
    public NhanVienDto getNhanVienById(Long id) {
        NhanVien nhanVien = nhanVienRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("NhanVien not found"));

        return NhanVienMapper.mapToNhanVienDto(nhanVien);
    }

    @Override
    public NhanVienDto updateNhanVien(Long id, NhanVienDto nhanVienDto) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NhanVien not found"));

        nhanVien.setHoTen(nhanVienDto.getHoTen());
        nhanVien.setNgaySinh(nhanVienDto.getNgaySinh());
        nhanVien.setGioiTinh(nhanVienDto.getGioiTinh());
        nhanVien.setSdt(nhanVienDto.getSdt());
        nhanVien.setEmail(nhanVienDto.getEmail());
        nhanVien.setDiaChi(nhanVienDto.getDiaChi());
        nhanVien.setChucVu(nhanVienDto.getChucVu());
        nhanVien.setPhongBan(nhanVienDto.getPhongBan());
        nhanVien.setTrangThai(nhanVienDto.getTrangThai());
        nhanVien.setThoiGianCapNhat(LocalDateTime.now());
        NhanVien savedNhanVien = nhanVienRepository.save(nhanVien);

        return NhanVienMapper.mapToNhanVienDto(savedNhanVien);
    }

    @Override
    public void deleteNhanVien(Long id) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NhanVien not found"));

        nhanVienRepository.delete(nhanVien);
    }

    @Override
    public List<NhanVienDto> getNhanVienWithPagination(String hoTen, int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<NhanVien> nhanVienPage;

        if (hoTen != null && !hoTen.isEmpty()) {
            nhanVienPage = nhanVienRepository.findByHoTenContainingIgnoreCase(hoTen, pageable);
        } else {
            nhanVienPage = nhanVienRepository.findAll(pageable);
        }

        return nhanVienPage.stream()
                .map(NhanVienMapper::mapToNhanVienDto)
                .collect(Collectors.toList());
    }

    public long getMaxNhanVien() {
        return nhanVienRepository.count();
    }
}
