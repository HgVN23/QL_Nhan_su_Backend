package com.project.QL_Nhan_su_Backend.repository;

import com.project.QL_Nhan_su_Backend.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {
    Optional<NguoiDung> findByTenNguoiDung(String tenNguoiDung);
}
