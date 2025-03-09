package com.project.QL_Nhan_su_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BaoCaoDto {
    private Long maBaoCao;
    private Long maNhanVien;
    private String loaiBaoCao;
    private String noiDung;
    private LocalDateTime thoiGianTao;
    private LocalDateTime thoiGianCapNhat;
}
