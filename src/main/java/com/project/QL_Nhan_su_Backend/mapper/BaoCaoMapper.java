package com.project.QL_Nhan_su_Backend.mapper;

import com.project.QL_Nhan_su_Backend.dto.BaoCaoDto;
import com.project.QL_Nhan_su_Backend.entity.BaoCao;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;

public class BaoCaoMapper {
    public static BaoCao mapToBaoCao(BaoCaoDto baoCaoDto) {
        BaoCao baoCao = new BaoCao();
        baoCao.setMaBaoCao(baoCaoDto.getMaBaoCao());

        if (baoCaoDto.getMaNhanVien() != null) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNhanVien(baoCaoDto.getMaNhanVien());
            baoCao.setMaNhanVien(nhanVien);
        }

        baoCao.setLoaiBaoCao(baoCaoDto.getLoaiBaoCao());
        baoCao.setNoiDung(baoCaoDto.getNoiDung());
        baoCao.setThoiGianTao(baoCaoDto.getThoiGianTao());
        baoCao.setThoiGianCapNhat(baoCaoDto.getThoiGianCapNhat());

        return baoCao;
    }

    public static BaoCaoDto mapToBaoCaoDto(BaoCao baoCao) {
        BaoCaoDto baoCaoDto = new BaoCaoDto(
                baoCao.getMaBaoCao(),
                baoCao.getMaNhanVien() != null ? baoCao.getMaNhanVien().getMaNhanVien() : null,
                baoCao.getLoaiBaoCao(),
                baoCao.getNoiDung(),
                baoCao.getThoiGianTao(),
                baoCao.getThoiGianCapNhat()
        );

        return baoCaoDto;
    }
}
