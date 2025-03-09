package com.project.QL_Nhan_su_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LuongDto {
    private Long maLuong;
    private Long maNhanVien;
    private BigDecimal luongCoBan;
    private BigDecimal luongLamThem;
    private BigDecimal thuong;
    private BigDecimal truLuong;
    private LocalDate ngayTraLuong;
    private String trangThai;
    private LocalDateTime thoiGianTao;
    private LocalDateTime thoiGianCapNhat;
}
