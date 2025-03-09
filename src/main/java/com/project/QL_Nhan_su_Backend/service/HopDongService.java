package com.project.QL_Nhan_su_Backend.service;

import com.project.QL_Nhan_su_Backend.dto.HopDongDto;

import java.util.List;

public interface HopDongService {
    HopDongDto createHopDong(HopDongDto hopDongDto);

    List<HopDongDto> getAllHopDong();
    
    HopDongDto getHopDongById(Long id);

    HopDongDto updateHopDong(Long id, HopDongDto hopDongDto);

    void deleteHopDong(Long id);

}
