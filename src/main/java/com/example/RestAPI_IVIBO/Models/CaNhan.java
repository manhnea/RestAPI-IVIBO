package com.example.RestAPI_IVIBO.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.aot.generate.GenerationContext;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CaNhan {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String hoTen;

    private String matKhau;

    private String email;

    private String soDienThoai;

    private int trangThai;
    @ManyToOne
    @JoinColumn(name="ChucVuId")
    private ChucVu chucVu;
}
