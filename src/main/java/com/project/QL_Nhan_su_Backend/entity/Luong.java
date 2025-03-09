package com.project.QL_Nhan_su_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "luong")
@Entity
public class Luong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_luong")
    private Long maLuong;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien maNhanVien;

    @Column(name = "luong_co_ban", nullable = false)
    private BigDecimal luongCoBan;

    @Column(name = "luong_lam_them")
    private BigDecimal luongLamThem;

    @Column(name = "thuong")
    private BigDecimal thuong;

    @Column(name = "tru_luong")
    private BigDecimal truLuong;

    @Column(name = "ngay_tra_luong", nullable = false)
    private LocalDate ngayTraLuong;

    @Column(name = "trang_thai", nullable = false)
    private String trangThai;

    @Column(name = "thoi_gian_tao", updatable = false)
    private LocalDateTime thoiGianTao = LocalDateTime.now();

    @Column(name = "thoi_gian_cap_nhat")
    private LocalDateTime thoiGianCapNhat;

    @PreUpdate
    protected void onUpdate() {
        this.thoiGianCapNhat = LocalDateTime.now();
    }
}