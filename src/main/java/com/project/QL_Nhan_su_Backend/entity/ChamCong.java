package com.project.QL_Nhan_su_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cham_cong")
@Entity
public class ChamCong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_cham_cong")
    private Long maChamCong;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien maNhanVien;

    @Column(name = "ngay_lam", nullable = false)
    private LocalDate ngayLam;

    @Column(name = "thoi_gian_bat_dau")
    private LocalTime thoiGianBatDau;

    @Column(name = "thoi_gian_ket_thuc")
    private LocalTime thoiGianKetThuc;

    @Column(name = "so_gio_lam")
    private Double soGioLam;

    @Column(name = "so_gio_lam_them")
    private Double soGioLamThem;

    @Column(name = "thoi_gian_tao", updatable = false)
    private LocalDateTime thoiGianTao = LocalDateTime.now();

    @Column(name = "thoi_gian_cap_nhat")
    private LocalDateTime thoiGianCapNhat;

    @PreUpdate
    protected void onUpdate() {
        this.thoiGianCapNhat = LocalDateTime.now();
    }
}