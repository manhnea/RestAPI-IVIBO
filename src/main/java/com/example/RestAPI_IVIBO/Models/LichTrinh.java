package com.example.RestAPI_IVIBO.Models;

import jakarta.persistence.*;

import java.util.Date;

public class LichTrinh {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="CaNhanId")
    private CaNhan caNhanId;

    private String tieuDe;

    private Date ngayBatDau;

    private Date ngayKetThuc;
    private String ghiChu;
}
