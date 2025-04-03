package com.project.QL_Nhan_su_Backend.repository;

import com.project.QL_Nhan_su_Backend.entity.NguoiDung;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    Page<NhanVien> findByHoTenContainingIgnoreCase(String hoTen, Pageable pageable);
    long count();
}
