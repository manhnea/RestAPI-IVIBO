package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.DanhSachChamCong;
import com.example.RestAPI_IVIBO.Repositories.DanhSachChamCongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/DanhSachChamCong")
public class DanhSachChamCongController {
    @Autowired
    DanhSachChamCongRepo danhSachChamCongRepo;
    @GetMapping("/get")
    public ResponseEntity<List<DanhSachChamCong>> get(){
        return ResponseEntity.ok(danhSachChamCongRepo.findAll());
    }
    @GetMapping("/get/{id}")
    public List<DanhSachChamCong> getById(@PathVariable int id){
        return danhSachChamCongRepo.findDanhSachChamCongById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<DanhSachChamCong> add(@RequestBody DanhSachChamCong danhSachChamCong){
        return ResponseEntity.ok(danhSachChamCongRepo.save(danhSachChamCong));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<DanhSachChamCong> update(@PathVariable Long id, @RequestBody DanhSachChamCong danhSachChamCong){
        DanhSachChamCong danhSachChamCong1 = danhSachChamCongRepo.findById(id).get();
        danhSachChamCong1.setThoiGianKetThuc(danhSachChamCong.getThoiGianKetThuc());
        return ResponseEntity.ok(danhSachChamCongRepo.save(danhSachChamCong));
    }
}
