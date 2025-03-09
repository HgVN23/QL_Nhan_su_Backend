package com.project.QL_Nhan_su_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DanhGiaHieuSuatDto {
    private Long maDanhGia;
    private Long maNhanVien;
    private Double diem;
    private String noiDung;
    private LocalDateTime thoiGianTao;
    private LocalDateTime thoiGianCapNhat;
}
