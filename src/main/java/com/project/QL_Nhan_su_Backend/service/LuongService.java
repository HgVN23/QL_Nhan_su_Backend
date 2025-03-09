package com.project.QL_Nhan_su_Backend.service;

import com.project.QL_Nhan_su_Backend.dto.LuongDto;

import java.util.List;

public interface LuongService {
    LuongDto createLuong(LuongDto luongDto);

    List<LuongDto> getAllLuong();
    
    LuongDto getLuongById(Long id);

    LuongDto updateLuong(Long id, LuongDto luongDto);

    void deleteLuong(Long id);

}
