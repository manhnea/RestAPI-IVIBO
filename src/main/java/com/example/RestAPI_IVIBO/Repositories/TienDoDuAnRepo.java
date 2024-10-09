package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.TienDoDuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TienDoDuAnRepo extends JpaRepository<TienDoDuAn, Long> {
}
