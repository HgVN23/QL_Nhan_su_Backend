package com.project.QL_Nhan_su_Backend.mapper;

import com.project.QL_Nhan_su_Backend.dto.NguoiDungDto;
import com.project.QL_Nhan_su_Backend.entity.NguoiDung;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;

public class NguoiDungMapper {
    public static NguoiDung mapToNguoiDung(NguoiDungDto nguoiDungDto) {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setMaNguoiDung(nguoiDungDto.getMaNguoiDung());

        if (nguoiDungDto.getMaNhanVien() != null) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNhanVien(nguoiDungDto.getMaNhanVien());
            nguoiDung.setMaNhanVien(nhanVien);
        }

        nguoiDung.setTenNguoiDung(nguoiDungDto.getTenNguoiDung());
        nguoiDung.setMatKhau(nguoiDungDto.getMatKhau());
        nguoiDung.setVaiTro(nguoiDungDto.getVaiTro());
        nguoiDung.setThoiGianTao(nguoiDungDto.getThoiGianTao());
        nguoiDung.setThoiGianCapNhat(nguoiDungDto.getThoiGianCapNhat());

        return nguoiDung;
    }

    public static NguoiDungDto mapToNguoiDungDto(NguoiDung nguoiDung) {
        NguoiDungDto nguoiDungDto = new NguoiDungDto(
                nguoiDung.getMaNguoiDung(),
                nguoiDung.getMaNhanVien() != null ? nguoiDung.getMaNhanVien().getMaNhanVien() : null,
                nguoiDung.getTenNguoiDung(),
                nguoiDung.getMatKhau(),
                nguoiDung.getVaiTro(),
                nguoiDung.getThoiGianTao(),
                nguoiDung.getThoiGianCapNhat()
        );

        return nguoiDungDto;
    }
}
