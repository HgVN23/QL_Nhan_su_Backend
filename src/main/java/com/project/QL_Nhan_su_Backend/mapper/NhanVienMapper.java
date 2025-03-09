package com.project.QL_Nhan_su_Backend.mapper;

import com.project.QL_Nhan_su_Backend.dto.NhanVienDto;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;

public class NhanVienMapper {
    public static NhanVien mapToNhanVien(NhanVienDto nhanVienDto) {
        NhanVien nhanVien = new NhanVien(
                nhanVienDto.getMaNhanVien(),
                nhanVienDto.getHoTen(),
                nhanVienDto.getNgaySinh(),
                nhanVienDto.getGioiTinh(),
                nhanVienDto.getSdt(),
                nhanVienDto.getEmail(),
                nhanVienDto.getDiaChi(),
                nhanVienDto.getChucVu(),
                nhanVienDto.getPhongBan(),
                nhanVienDto.getTrangThai(),
                nhanVienDto.getThoiGianTao(),
                nhanVienDto.getThoiGianCapNhat()
        );

        return nhanVien;
    }

    public static NhanVienDto mapToNhanVienDto(NhanVien nhanVien) {
        NhanVienDto nhanVienDto = new NhanVienDto(
                nhanVien.getMaNhanVien(),
                nhanVien.getHoTen(),
                nhanVien.getNgaySinh(),
                nhanVien.getGioiTinh(),
                nhanVien.getSdt(),
                nhanVien.getEmail(),
                nhanVien.getDiaChi(),
                nhanVien.getChucVu(),
                nhanVien.getPhongBan(),
                nhanVien.getTrangThai(),
                nhanVien.getThoiGianTao(),
                nhanVien.getThoiGianCapNhat()
        );

        return nhanVienDto;
    }
}
