package com.project.QL_Nhan_su_Backend.repository;

import com.project.QL_Nhan_su_Backend.entity.BaoCao;
import com.project.QL_Nhan_su_Backend.entity.BaoCao;
import com.project.QL_Nhan_su_Backend.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaoCaoRepository extends JpaRepository<BaoCao, Long> {
    List<BaoCao> findAllByMaNhanVien_MaNhanVien(Long maNhanVien);
    long countByMaNhanVien(NhanVien nhanVien);

}
