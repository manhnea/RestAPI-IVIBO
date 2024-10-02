package com.example.RestAPI_IVIBO.Models;

import jakarta.persistence.*;

public class MucDo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String tenDuAn;

    private String mucDo;
}
