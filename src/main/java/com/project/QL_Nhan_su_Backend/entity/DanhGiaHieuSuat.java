package com.project.QL_Nhan_su_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "danh_gia_hieu_suat")
@Entity
public class DanhGiaHieuSuat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_danh_gia")
    private Long maDanhGia;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien maNhanVien;

    @Column(name = "diem", nullable = false)
    private Double diem;

    @Column(name = "noi_dung", columnDefinition = "TEXT", nullable = false)
    private String noiDung;

    @Column(name = "thoi_gian_tao", updatable = false)
    private LocalDateTime thoiGianTao = LocalDateTime.now();

    @Column(name = "thoi_gian_cap_nhat")
    private LocalDateTime thoiGianCapNhat;

    @PreUpdate
    protected void onUpdate() {
        this.thoiGianCapNhat = LocalDateTime.now();
    }
}