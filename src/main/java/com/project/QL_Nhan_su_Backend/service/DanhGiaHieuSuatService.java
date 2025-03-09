package com.project.QL_Nhan_su_Backend.service;

import com.project.QL_Nhan_su_Backend.dto.DanhGiaHieuSuatDto;

import java.util.List;

public interface DanhGiaHieuSuatService {
    DanhGiaHieuSuatDto createDanhGiaHieuSuat(DanhGiaHieuSuatDto danhGiaHieuSuatDto);

    List<DanhGiaHieuSuatDto> getAllDanhGiaHieuSuat();
    
    DanhGiaHieuSuatDto getDanhGiaHieuSuatById(Long id);

    DanhGiaHieuSuatDto updateDanhGiaHieuSuat(Long id, DanhGiaHieuSuatDto danhGiaHieuSuatDto);

    void deleteDanhGiaHieuSuat(Long id);

}
