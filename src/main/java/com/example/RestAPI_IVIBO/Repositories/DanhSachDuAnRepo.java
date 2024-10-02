package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.DanhSachDuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhSachDuAnRepo extends JpaRepository<DanhSachDuAn,Long> {
}
