package com.project.QL_Nhan_su_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class NhanVienDto {
    private Long maNhanVien;
    private String hoTen;
    private LocalDate ngaySinh;
    private Boolean gioiTinh;
    private String sdt;
    private String email;
    private String diaChi;
    private String chucVu;
    private String phongBan;
    private String trangThai;
    private LocalDateTime thoiGianTao;
    private LocalDateTime thoiGianCapNhat;
}
