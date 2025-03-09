package com.project.QL_Nhan_su_Backend.mapper;

import com.project.QL_Nhan_su_Backend.dto.HopDongDto;
import com.project.QL_Nhan_su_Backend.entity.HopDong;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;

public class HopDongMapper {
    public static HopDong mapToHopDong(HopDongDto hopDongDto) {
        HopDong hopDong = new HopDong();
        hopDong.setMaHopDong(hopDongDto.getMaHopDong());

        if (hopDongDto.getMaNhanVien() != null) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNhanVien(hopDongDto.getMaNhanVien());
            hopDong.setMaNhanVien(nhanVien);
        }

        hopDong.setLoaiHopDong(hopDongDto.getLoaiHopDong());
        hopDong.setNgayBatDau(hopDongDto.getNgayBatDau());
        hopDong.setNgayKetThuc(hopDongDto.getNgayKetThuc());
        hopDong.setLuong(hopDongDto.getLuong());
        hopDong.setTrangThai(hopDongDto.getTrangThai());
        hopDong.setThoiGianTao(hopDongDto.getThoiGianTao());
        hopDong.setThoiGianCapNhat(hopDongDto.getThoiGianCapNhat());

        return hopDong;
    }

    public static HopDongDto mapToHopDongDto(HopDong hopDong) {
        HopDongDto hopDongDto = new HopDongDto(
                hopDong.getMaHopDong(),
                hopDong.getMaNhanVien() != null ? hopDong.getMaNhanVien().getMaNhanVien() : null,
                hopDong.getLoaiHopDong(),
                hopDong.getNgayBatDau(),
                hopDong.getNgayKetThuc(),
                hopDong.getLuong(),
                hopDong.getTrangThai(),
                hopDong.getThoiGianTao(),
                hopDong.getThoiGianCapNhat()
        );

        return hopDongDto;
    }
}
