package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepo extends JpaRepository<ChucVu, Long> {
}
