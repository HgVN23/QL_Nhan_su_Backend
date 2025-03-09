package com.project.QL_Nhan_su_Backend.dto;

import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class NguoiDungDto {
    private Long maNguoiDung;
    private Long maNhanVien;
    private String tenNguoiDung;
    private String matKhau;
    private String vaiTro;
    private LocalDateTime thoiGianTao;
    private LocalDateTime thoiGianCapNhat;
}
