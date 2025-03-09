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
@Table(name = "hop_dong")
@Entity
public class HopDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong")
    private Long maHopDong;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien maNhanVien;

    @Column(name = "loai_hop_dong", nullable = false)
    private String loaiHopDong;

    @Column(name = "ngay_bat_dau", nullable = false)
    private LocalDate ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private LocalDate ngayKetThuc;

    @Column(name = "luong", nullable = false)
    private BigDecimal luong;

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