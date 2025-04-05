package com.project.QL_Nhan_su_Backend.service;

import com.project.QL_Nhan_su_Backend.dto.BaoCaoDto;
import com.project.QL_Nhan_su_Backend.dto.BaoCaoDto;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;

import java.util.List;

public interface BaoCaoService {
    BaoCaoDto createBaoCao(BaoCaoDto baoCaoDto);

    List<BaoCaoDto> getAllBaoCao();
    
    BaoCaoDto getBaoCaoById(Long id);

    BaoCaoDto updateBaoCao(Long id, BaoCaoDto baoCaoDto);

    void deleteBaoCao(Long id);

    List<BaoCaoDto> getBaoCaoWithPagination(int offset, int limit);

    long getMaxBaoCao();

    List<BaoCaoDto> getBaoCaosByMaNhanVien(Long maNhanVien);

    long getMaxBaoCaoByMaNhanVien(NhanVien maNhanVien);
}
