package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.LichTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LichTrinhRepo extends JpaRepository<LichTrinh,Long> {
    @Query(value = "SELECT * FROM LichTrinh WHERE CaNhanId = ?",nativeQuery = true)
    public Set<LichTrinh> findLichTrinhByCaNhanId(Long caNhanId);
}
