package com.project.QL_Nhan_su_Backend.service.impl;

import com.project.QL_Nhan_su_Backend.dto.HopDongDto;
import com.project.QL_Nhan_su_Backend.dto.HopDongDto;
import com.project.QL_Nhan_su_Backend.entity.HopDong;
import com.project.QL_Nhan_su_Backend.entity.HopDong;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import com.project.QL_Nhan_su_Backend.mapper.HopDongMapper;
import com.project.QL_Nhan_su_Backend.mapper.HopDongMapper;
import com.project.QL_Nhan_su_Backend.repository.HopDongRepository;
import com.project.QL_Nhan_su_Backend.service.HopDongService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HopDongServiceImpl implements HopDongService {

    private HopDongRepository hopDongRepository;

    public HopDongServiceImpl(HopDongRepository hopDongRepository) {
        this.hopDongRepository = hopDongRepository;
    }

    @Override
    public HopDongDto createHopDong(HopDongDto hopDongDto) {
        HopDong hopDong = HopDongMapper.mapToHopDong(hopDongDto);
        hopDong.setThoiGianTao(LocalDateTime.now());
        HopDong savedHopDong = hopDongRepository.save(hopDong);

        return HopDongMapper.mapToHopDongDto(savedHopDong);
    }

    @Override
    public List<HopDongDto> getAllHopDong() {
        List<HopDong> hopDongs = hopDongRepository.findAll();

        return hopDongs.stream()
                .map(HopDongMapper::mapToHopDongDto)
                .collect(Collectors.toList());
    }

    @Override
    public HopDongDto getHopDongById(Long id) {
        HopDong hopDong = hopDongRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("HopDong not found"));

        return HopDongMapper.mapToHopDongDto(hopDong);
    }

    @Override
    public HopDongDto updateHopDong(Long id, HopDongDto hopDongDto) {
        HopDong hopDong = hopDongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HopDong not found"));

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(hopDongDto.getMaNhanVien());
        hopDong.setMaNhanVien(nhanVien.getMaNhanVien() != null ? nhanVien : null);

        hopDong.setLoaiHopDong(hopDongDto.getLoaiHopDong());
        hopDong.setNgayBatDau(hopDongDto.getNgayBatDau());
        hopDong.setNgayKetThuc(hopDongDto.getNgayKetThuc());
        hopDong.setLuong(hopDongDto.getLuong());
        hopDong.setTrangThai(hopDongDto.getTrangThai());
        hopDong.setThoiGianCapNhat(LocalDateTime.now());
        HopDong savedHopDong = hopDongRepository.save(hopDong);

        return HopDongMapper.mapToHopDongDto(savedHopDong);
    }

    @Override
    public void deleteHopDong(Long id) {
        HopDong hopDong = hopDongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HopDong not found"));

        hopDongRepository.delete(hopDong);
    }

    @Override
    public List<HopDongDto> getHopDongWithPagination(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<HopDong> hopDongPage = hopDongRepository.findAll(pageable);

        return hopDongPage.stream()
                .map(HopDongMapper::mapToHopDongDto)
                .collect(Collectors.toList());
    }

    public long getMaxHopDong() {
        return hopDongRepository.count();
    }
}
