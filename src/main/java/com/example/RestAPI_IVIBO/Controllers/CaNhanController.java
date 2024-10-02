package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.CaNhan;
import com.example.RestAPI_IVIBO.Models.ChucVu;
import com.example.RestAPI_IVIBO.Repositories.CaNhanRepo;
import com.example.RestAPI_IVIBO.Repositories.ChucVuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CaNhan")
public class CaNhanController {
    @Autowired
    CaNhanRepo caNhanRepo;
    @Autowired
    ChucVuRepo chucVuRepo;
    @GetMapping("/get")
    public ResponseEntity<List<CaNhan>> get(){
        return ResponseEntity.ok(caNhanRepo.findAll());
    }
    @PostMapping("/addCaNhan")
    public ResponseEntity<CaNhan> addCaNhan(@RequestBody CaNhan caNhan){
        return ResponseEntity.ok(caNhanRepo.save(caNhan));
    }
    @PutMapping("/updateCaNhan/{id}")
    public ResponseEntity<CaNhan> updateCaNhan(@PathVariable Long id, @RequestBody CaNhan caNhan){
        CaNhan updateCaNhan = caNhanRepo.findById(id).get();
        ChucVu chucVu = chucVuRepo.findById(caNhan.getChucVu().getId()).get();
        updateCaNhan.setHoTen(caNhan.getHoTen());
        updateCaNhan.setSoDienThoai(caNhan.getSoDienThoai());
        updateCaNhan.setEmail(caNhan.getEmail());
        updateCaNhan.setChucVu(chucVu);
        updateCaNhan.setTrangThai(1);
        return ResponseEntity.ok(caNhanRepo.save(updateCaNhan));
    }
    @PutMapping("/deleteCaNhan/{id}")
    public ResponseEntity<String> deleteCaNhan(@PathVariable Long id, @RequestBody CaNhan caNhan){
        CaNhan updateCaNhan = caNhanRepo.findById(id).get();
        updateCaNhan.setTrangThai(0);
        return ResponseEntity.ok("Xóa thành công");
    }

}
