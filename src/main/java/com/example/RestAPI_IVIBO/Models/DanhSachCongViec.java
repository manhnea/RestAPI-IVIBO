package com.example.RestAPI_IVIBO.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="DanhSachCongViec")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DanhSachCongViec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_DuAn")
    private DanhSachDuAn duAnId;

    @ManyToOne
    @JoinColumn(name="UserId")
    private CaNhan caNhan;

    @Column(name="NgayBatDau")
    private Date ngayBatDau;

    @Column(name="NgayKetThuc")
    private Date ngayKetThuc;

    @ManyToOne
    @JoinColumn(name="ID_MucDo")
    private MucDo mucDo;

    @Column(name="GhiChu")
    private String ghiChu;

    @Column(name="TrangThai")
    private String trangThai;


}
