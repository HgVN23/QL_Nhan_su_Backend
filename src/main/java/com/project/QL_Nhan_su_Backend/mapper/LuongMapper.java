package com.project.QL_Nhan_su_Backend.mapper;

import com.project.QL_Nhan_su_Backend.dto.LuongDto;
import com.project.QL_Nhan_su_Backend.entity.Luong;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;

public class LuongMapper {
    public static Luong mapToLuong(LuongDto luongDto) {
        Luong luong = new Luong();
        luong.setMaLuong(luongDto.getMaLuong());

        if (luongDto.getMaNhanVien() != null) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNhanVien(luongDto.getMaNhanVien());
            luong.setMaNhanVien(nhanVien);
        }

        luong.setLuongCoBan(luongDto.getLuongCoBan());
        luong.setLuongLamThem(luongDto.getLuongLamThem());
        luong.setThuong(luongDto.getThuong());
        luong.setTruLuong(luongDto.getTruLuong());
        luong.setNgayTraLuong(luongDto.getNgayTraLuong());
        luong.setTrangThai(luongDto.getTrangThai());
        luong.setThoiGianTao(luongDto.getThoiGianTao());
        luong.setThoiGianCapNhat(luongDto.getThoiGianCapNhat());

        return luong;
    }

    public static LuongDto mapToLuongDto(Luong luong) {
        LuongDto luongDto = new LuongDto(
                luong.getMaLuong(),
                luong.getMaNhanVien() != null ? luong.getMaNhanVien().getMaNhanVien() : null,
                luong.getLuongCoBan(),
                luong.getLuongLamThem(),
                luong.getThuong(),
                luong.getTruLuong(),
                luong.getNgayTraLuong(),
                luong.getTrangThai(),
                luong.getThoiGianTao(),
                luong.getThoiGianCapNhat()
        );

        return luongDto;
    }
}
