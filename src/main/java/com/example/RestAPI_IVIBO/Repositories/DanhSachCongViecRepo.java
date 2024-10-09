package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.DanhSachCongViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhSachCongViecRepo extends JpaRepository<DanhSachCongViec,Long> {
}
