package com.example.RestAPI_IVIBO.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name="DanhSachDuAn")
public class DanhSachDuAn {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
        @JoinColumn(name="tenDuAn")
        private String tenDuAn;

        @ManyToOne
        @JoinColumn(name="TrangThaiId")
        private TienDoDuAn trangThai;
    }


