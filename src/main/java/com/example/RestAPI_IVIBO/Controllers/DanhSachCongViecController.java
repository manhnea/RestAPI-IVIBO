package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.DanhSachCongViec;
import com.example.RestAPI_IVIBO.Repositories.DanhSachCongViecRepo;
import com.example.RestAPI_IVIBO.Repositories.DanhSachCongViecRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/dscongviec")

public class DanhSachCongViecController {
    @Autowired
    DanhSachCongViecRepo danhSachCongViecRepo;

    public DanhSachCongViecController() {
    }

    @GetMapping({"/get"})
    public ResponseEntity<List<DanhSachCongViec>> get() {
        return ResponseEntity.ok(this.danhSachCongViecRepo.findAll());
    }

    @GetMapping({"find/{id}"})
    public ResponseEntity<DanhSachCongViec> findById(@PathVariable("id") Long id) {
        DanhSachCongViec congViec = (DanhSachCongViec)this.danhSachCongViecRepo.findById(id).orElseThrow();
        return ResponseEntity.ok(congViec);
    }

    @PostMapping({"/post"})
    public ResponseEntity post(@RequestBody DanhSachCongViec congViec) {
        DanhSachCongViec savedCongViec = (DanhSachCongViec)this.danhSachCongViecRepo.save(congViec);
        return savedCongViec == null ? new ResponseEntity(savedCongViec, HttpStatus.FORBIDDEN) : ResponseEntity.ok(savedCongViec);
    }

    @PutMapping({"/put/{id}"})
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody DanhSachCongViec congViec) {
        DanhSachCongViec updatedCongViec = danhSachCongViecRepo.findById(id).orElseThrow();
        updatedCongViec.setDuAnId(congViec.getDuAnId());
        updatedCongViec.setCaNhan(congViec.getCaNhan());
        updatedCongViec.setNgayBatDau(congViec.getNgayBatDau());
        updatedCongViec.setNgayKetThuc(congViec.getNgayKetThuc());
        updatedCongViec.setMucDo(congViec.getMucDo());
        updatedCongViec.setGhiChu(congViec.getGhiChu());
        updatedCongViec.setTrangThai(congViec.getTrangThai());
        congViec = danhSachCongViecRepo.save(updatedCongViec);
        return new ResponseEntity(congViec, HttpStatus.OK);
    }

}
