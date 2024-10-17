package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.CaNhan;
import com.example.RestAPI_IVIBO.Models.ChucVu;
import com.example.RestAPI_IVIBO.Repositories.CaNhanRepo;
import com.example.RestAPI_IVIBO.Repositories.ChucVuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public ResponseEntity<CaNhan> addCaNhan(@RequestBody CaNhan caNhan) {
        // Retrieve the maximum id from the repository
        Long maxId = caNhanRepo.findMaxId(); // You'll need to implement this method in your repository

        // Increment the id by 1
        if (maxId != null) {
            caNhan.setId(maxId + 1);
        } else {
            caNhan.setId(1L); // If there are no records, start with 1
        }

        caNhan.setUserId("NV" + caNhan.getId());
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
        updateCaNhan.setImgurl(caNhan.getImgurl());
        updateCaNhan.setTrangThai(1);
        return ResponseEntity.ok(caNhanRepo.save(updateCaNhan));
    }
    @PutMapping("/deleteCaNhan/{id}")
    public ResponseEntity<String> deleteCaNhan(@PathVariable Long id){
        CaNhan updateCaNhan = caNhanRepo.findById(id).get();
        updateCaNhan.setTrangThai(0);
        return ResponseEntity.ok("Xóa thành công");
    }

    @PostMapping("/login")
    public ResponseEntity<CaNhan> login(@RequestParam String userId, @RequestParam String matKhau){
        List<CaNhan> findCaNhan = caNhanRepo.findCaNhanByUserIdAndMatKhau(userId,matKhau);
        if(findCaNhan.size()>1){
            return new ResponseEntity<>(new CaNhan(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(findCaNhan.get(0),HttpStatus.OK);
    }

}
