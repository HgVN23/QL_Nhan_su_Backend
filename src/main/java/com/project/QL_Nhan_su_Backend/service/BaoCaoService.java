package com.project.QL_Nhan_su_Backend.service;

import com.project.QL_Nhan_su_Backend.dto.BaoCaoDto;

import java.util.List;

public interface BaoCaoService {
    BaoCaoDto createBaoCao(BaoCaoDto baoCaoDto);

    List<BaoCaoDto> getAllBaoCao();
    
    BaoCaoDto getBaoCaoById(Long id);

    BaoCaoDto updateBaoCao(Long id, BaoCaoDto baoCaoDto);

    void deleteBaoCao(Long id);

}
