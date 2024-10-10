package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.DanhSachChamCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhSachChamCongRepo extends JpaRepository<DanhSachChamCong, Long> {
    @Query(value = "SELECT * FROM DanhSachChamCong WHERE CaNhanId = ?1", nativeQuery = true)
    List<DanhSachChamCong> findDanhSachChamCongById(int id);
}
