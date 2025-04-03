package com.project.QL_Nhan_su_Backend.service;

import com.project.QL_Nhan_su_Backend.dto.NhanVienDto;

import java.util.List;

public interface NhanVienService {
    NhanVienDto createNhanVien(NhanVienDto nhanVienDto);

    List<NhanVienDto> getAllNhanVien();
    
    NhanVienDto getNhanVienById(Long id);

    NhanVienDto updateNhanVien(Long id, NhanVienDto nhanVienDto);

    void deleteNhanVien(Long id);

    List<NhanVienDto> getNhanVienWithPagination(String hoTen, int offset, int limit);

    public long getMaxNhanVien();
}
