package com.project.QL_Nhan_su_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ChamCongDto {
    private Long maChamCong;
    private Long maNhanVien;
    private LocalDate ngayLam;
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;
    private Double soGioLam;
    private Double soGioLamThem;
    private LocalDateTime thoiGianTao;
    private LocalDateTime thoiGianCapNhat;
}
