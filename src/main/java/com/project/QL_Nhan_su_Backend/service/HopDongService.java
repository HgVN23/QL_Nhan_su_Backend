package com.project.QL_Nhan_su_Backend.service;

import com.project.QL_Nhan_su_Backend.dto.HopDongDto;
import com.project.QL_Nhan_su_Backend.dto.HopDongDto;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;

import java.util.List;

public interface HopDongService {
    HopDongDto createHopDong(HopDongDto hopDongDto);

    List<HopDongDto> getAllHopDong();
    
    HopDongDto getHopDongById(Long id);

    HopDongDto updateHopDong(Long id, HopDongDto hopDongDto);

    void deleteHopDong(Long id);

    List<HopDongDto> getHopDongWithPagination(int offset, int limit);

    long getMaxHopDong();

    List<HopDongDto> getHopDongsByMaNhanVien(Long maNhanVien);

    long getMaxHopDongByMaNhanVien(NhanVien maNhanVien);

}
