package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.DanhSachCongViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhSachCongViecRepo extends JpaRepository<DanhSachCongViec, Long> {
    @Query(value = "SELECT * FROM DanhSachCongViec WHERE UserId = ?1", nativeQuery = true)
    List<DanhSachCongViec> findDanhSachCongViecById(int id);
}


