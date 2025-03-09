package com.project.QL_Nhan_su_Backend.service;

import com.project.QL_Nhan_su_Backend.dto.ChamCongDto;

import java.util.List;

public interface ChamCongService {
    ChamCongDto createChamCong(ChamCongDto chamCongDto);

    List<ChamCongDto> getAllChamCong();
    
    ChamCongDto getChamCongById(Long id);

    ChamCongDto updateChamCong(Long id, ChamCongDto chamCongDto);

    void deleteChamCong(Long id);

}
