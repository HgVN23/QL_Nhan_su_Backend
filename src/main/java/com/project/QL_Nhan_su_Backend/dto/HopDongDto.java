package com.project.QL_Nhan_su_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HopDongDto {
    private Long maHopDong;
    private Long maNhanVien;
    private String loaiHopDong;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private BigDecimal luong;
    private String trangThai;
    private LocalDateTime thoiGianTao;
    private LocalDateTime thoiGianCapNhat;
}
