package com.project.QL_Nhan_su_Backend.repository;

import com.project.QL_Nhan_su_Backend.entity.HopDong;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HopDongRepository extends JpaRepository<HopDong, Long> {
    List<HopDong> findAllByMaNhanVien_MaNhanVien(Long maNhanVien);
    long countByMaNhanVien(NhanVien nhanVien);
}
