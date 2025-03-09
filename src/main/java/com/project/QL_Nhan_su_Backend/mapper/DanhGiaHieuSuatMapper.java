package com.project.QL_Nhan_su_Backend.mapper;

import com.project.QL_Nhan_su_Backend.dto.DanhGiaHieuSuatDto;
import com.project.QL_Nhan_su_Backend.entity.DanhGiaHieuSuat;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;

public class DanhGiaHieuSuatMapper {
    public static DanhGiaHieuSuat mapToDanhGiaHieuSuat(DanhGiaHieuSuatDto danhGiaHieuSuatDto) {
        DanhGiaHieuSuat danhGiaHieuSuat = new DanhGiaHieuSuat();
        danhGiaHieuSuat.setMaDanhGia(danhGiaHieuSuatDto.getMaDanhGia());

        if (danhGiaHieuSuatDto.getMaNhanVien() != null) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNhanVien(danhGiaHieuSuatDto.getMaNhanVien());
            danhGiaHieuSuat.setMaNhanVien(nhanVien);
        }

        danhGiaHieuSuat.setDiem(danhGiaHieuSuatDto.getDiem());
        danhGiaHieuSuat.setNoiDung(danhGiaHieuSuatDto.getNoiDung());
        danhGiaHieuSuat.setThoiGianTao(danhGiaHieuSuatDto.getThoiGianTao());
        danhGiaHieuSuat.setThoiGianCapNhat(danhGiaHieuSuatDto.getThoiGianCapNhat());

        return danhGiaHieuSuat;
    }

    public static DanhGiaHieuSuatDto mapToDanhGiaHieuSuatDto(DanhGiaHieuSuat danhGiaHieuSuat) {
        DanhGiaHieuSuatDto danhGiaHieuSuatDto = new DanhGiaHieuSuatDto(
                danhGiaHieuSuat.getMaDanhGia(),
                danhGiaHieuSuat.getMaNhanVien() != null ? danhGiaHieuSuat.getMaNhanVien().getMaNhanVien() : null,
                danhGiaHieuSuat.getDiem(),
                danhGiaHieuSuat.getNoiDung(),
                danhGiaHieuSuat.getThoiGianTao(),
                danhGiaHieuSuat.getThoiGianCapNhat()
        );

        return danhGiaHieuSuatDto;
    }
}
