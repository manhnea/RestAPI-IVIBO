package com.example.RestAPI_IVIBO.Models;

import jakarta.persistence.*;

public class TienDoDuAn {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String trangThai;
}
