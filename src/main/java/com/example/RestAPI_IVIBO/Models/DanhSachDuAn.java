package com.example.RestAPI_IVIBO.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DanhSachDuAn {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;

        private String tenDuAn;

        @ManyToOne
        @JoinColumn(name="TrangThaiId")
        private TienDoDuAn trangThai;



    }


