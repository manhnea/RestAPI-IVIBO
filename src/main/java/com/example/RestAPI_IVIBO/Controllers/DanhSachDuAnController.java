package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.DanhSachDuAn;
import com.example.RestAPI_IVIBO.Repositories.DanhSachDuAnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dsduan")
public class DanhSachDuAnController {
    @Autowired
    DanhSachDuAnRepo danhSachDuAnRepo;

    @GetMapping("/get")
    public ResponseEntity<List<DanhSachDuAn>> get() {
        return ResponseEntity.ok(danhSachDuAnRepo.findAll());
    }

    @GetMapping("find/{id}")
    public ResponseEntity<DanhSachDuAn> findById(@PathVariable("id") Long id) {
        DanhSachDuAn duAn = danhSachDuAnRepo.findById(id).orElseThrow();
        return ResponseEntity.ok(duAn);
    }

    @PostMapping("/post")
    public ResponseEntity post(@RequestBody DanhSachDuAn duAn) {
        DanhSachDuAn savedDuAn = danhSachDuAnRepo.save(duAn);
        if (savedDuAn == null) {
            return new ResponseEntity(savedDuAn, HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(savedDuAn);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody DanhSachDuAn duAn) {
        DanhSachDuAn updatedDuAn = danhSachDuAnRepo.findById(id).orElseThrow();
        updatedDuAn.setTenDuAn(duAn.getTenDuAn());
        updatedDuAn.setTrangThai(duAn.getTrangThai());
        duAn = danhSachDuAnRepo.save(updatedDuAn);
        return new ResponseEntity(duAn, HttpStatus.FORBIDDEN);
    }
}
