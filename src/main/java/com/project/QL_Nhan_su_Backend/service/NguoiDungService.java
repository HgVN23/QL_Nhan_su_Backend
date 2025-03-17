package com.project.QL_Nhan_su_Backend.service;

import com.project.QL_Nhan_su_Backend.dto.NguoiDungDto;

import java.util.List;

public interface NguoiDungService {
    NguoiDungDto createNguoiDung(NguoiDungDto nguoiDungDto);

    List<NguoiDungDto> getAllNguoiDung();
    
    NguoiDungDto getNguoiDungById(Long id);

    NguoiDungDto updateNguoiDung(Long id, NguoiDungDto nguoiDungDto);

    void deleteNguoiDung(Long id);

    NguoiDungDto login(String tenNguoiDung, String matKhau);
}
