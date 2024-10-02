package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.DanhSachChamCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DanhSachChamCongRepo extends JpaRepository<DanhSachChamCong, Long> {
    @Query(value = "SELECT * FROM danh_sach_cham_cong WHERE id_nhan_vien = ?1 ", nativeQuery = true)
    DanhSachChamCong findByNhanVienAndThangAndNam(Long idNhanVien);
}
