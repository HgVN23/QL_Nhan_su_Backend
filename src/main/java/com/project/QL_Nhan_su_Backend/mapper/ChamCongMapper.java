package com.project.QL_Nhan_su_Backend.mapper;

import com.project.QL_Nhan_su_Backend.dto.ChamCongDto;
import com.project.QL_Nhan_su_Backend.entity.ChamCong;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;

public class ChamCongMapper {
    public static ChamCong mapToChamCong(ChamCongDto chamCongDto) {
        ChamCong chamCong = new ChamCong();
        chamCong.setMaChamCong(chamCongDto.getMaChamCong());

        if (chamCongDto.getMaNhanVien() != null) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNhanVien(chamCongDto.getMaNhanVien());
            chamCong.setMaNhanVien(nhanVien);
        }

        chamCong.setNgayLam(chamCongDto.getNgayLam());
        chamCong.setThoiGianBatDau(chamCongDto.getThoiGianBatDau());
        chamCong.setThoiGianKetThuc(chamCongDto.getThoiGianKetThuc());
        chamCong.setSoGioLam(chamCongDto.getSoGioLam());
        chamCong.setSoGioLamThem(chamCongDto.getSoGioLamThem());
        chamCong.setThoiGianTao(chamCongDto.getThoiGianTao());
        chamCong.setThoiGianCapNhat(chamCongDto.getThoiGianCapNhat());

        return chamCong;
    }

    public static ChamCongDto mapToChamCongDto(ChamCong chamCong) {
        ChamCongDto chamCongDto = new ChamCongDto(
                chamCong.getMaChamCong(),
                chamCong.getMaNhanVien() != null ? chamCong.getMaNhanVien().getMaNhanVien() : null,
                chamCong.getNgayLam(),
                chamCong.getThoiGianBatDau(),
                chamCong.getThoiGianKetThuc(),
                chamCong.getSoGioLam(),
                chamCong.getSoGioLamThem(),
                chamCong.getThoiGianTao(),
                chamCong.getThoiGianCapNhat()
        );

        return chamCongDto;
    }
}
