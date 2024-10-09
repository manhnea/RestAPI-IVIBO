package com.example.RestAPI_IVIBO.Repositories;

import com.example.RestAPI_IVIBO.Models.CaNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface CaNhanRepo extends JpaRepository<CaNhan, Long> {
    @Query(value = "SELECT * FROM CaNhan WHERE UserId = :userId AND MatKhau = :matKhau", nativeQuery = true)
    List<CaNhan> findCaNhanByUserIdAndMatKhau(@Param("userId") String userId, @Param("matKhau") String matKhau);

}
