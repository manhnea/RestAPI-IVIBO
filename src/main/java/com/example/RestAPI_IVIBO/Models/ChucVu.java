package com.example.RestAPI_IVIBO.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.aot.generate.GenerationContext;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "chucvu")
@Table(name="chucvu")
public class ChucVu {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String chucVu;

}
