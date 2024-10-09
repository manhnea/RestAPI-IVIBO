package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.MucDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MucDoRepo extends JpaRepository<MucDo, Long> {
}
