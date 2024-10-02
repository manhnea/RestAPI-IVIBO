package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.LichTrinh;
import com.example.RestAPI_IVIBO.Repositories.LichTrinhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lichtrinh")
public class LichTrinhController {
    @Autowired
    LichTrinhRepo lichTrinhRepo;

    @GetMapping("/get")
    public ResponseEntity<List<LichTrinh>> get() {
        return ResponseEntity.ok(lichTrinhRepo.findAll());
    }

    @GetMapping("find/{id}")
    public ResponseEntity<LichTrinh> findById(@PathVariable("id") Long id) {
        LichTrinh lichTrinh = lichTrinhRepo.findById(id).orElseThrow();
        return ResponseEntity.ok(lichTrinh);
    }

    @PostMapping("/post")
    public ResponseEntity post(@RequestBody LichTrinh lichTrinh) {
        LichTrinh savedLichTrinh = lichTrinhRepo.save(lichTrinh);
        if (savedLichTrinh == null) {
            return new ResponseEntity(savedLichTrinh, HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(savedLichTrinh);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody LichTrinh lichTrinh) {
        LichTrinh updatedLichTrinh = lichTrinhRepo.findById(id).orElseThrow();
        updatedLichTrinh.setGhiChu(lichTrinh.getGhiChu());
        updatedLichTrinh.setCaNhanId(lichTrinh.getCaNhanId());
        updatedLichTrinh.setTieuDe(lichTrinh.getTieuDe());
        updatedLichTrinh.setNgayBatDau(lichTrinh.getNgayBatDau());
        updatedLichTrinh.setNgayKetThuc(lichTrinh.getNgayKetThuc());
        lichTrinh = lichTrinhRepo.save(updatedLichTrinh);
        return new ResponseEntity(lichTrinh, HttpStatus.FORBIDDEN);
    }
}
