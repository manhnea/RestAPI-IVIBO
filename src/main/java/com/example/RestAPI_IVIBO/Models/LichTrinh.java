package com.example.RestAPI_IVIBO.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@Entity
@Table(name="LichTrinh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LichTrinh {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;



    @Column(name="TIEUDE")
    private String tieuDe;

    @Column(name="NGAYBATDAU")
    private Date ngayBatDau;

    @Column(name="NGAYKETTHUC")
    private Date ngayKetThuc;

    @Column(name="GHICHU")
    private String ghiChu;
    @ManyToOne
    @JoinColumn(name="CaNhanId")
    private CaNhan caNhan;
}
