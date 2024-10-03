package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.DanhSachDuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DanhSachDuAnRepo extends JpaRepository<DanhSachDuAn,Long> {
    @Query(value = "SELECT * FROM DanhSachDuAn WHERE TrangThaiId = ?",nativeQuery = true)
    public Set<DanhSachDuAn> findDanhSachDuAnByTrangThai(Long trangThaiId);
}
