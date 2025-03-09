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
@Table(name = "bao_cao")
@Entity
public class BaoCao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bao_cao")
    private Long maBaoCao;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien maNhanVien;

    @Column(name = "loai_bao_cao", nullable = false)
    private String loaiBaoCao;

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