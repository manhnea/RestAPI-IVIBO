package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.LichTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichTrinhRepo extends JpaRepository<LichTrinh,Long> {
}
