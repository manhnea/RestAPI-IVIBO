package com.example.RestAPI_IVIBO.Controllers;
import com.example.RestAPI_IVIBO.Models.DanhSachDuAn;
import com.example.RestAPI_IVIBO.Repositories.DanhSachDuAnRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping({"/dsduan"})
public class DanhSachDuAnController {
    @Autowired
    DanhSachDuAnRepo danhSachDuAnRepo;

    public DanhSachDuAnController() {
    }

    @GetMapping({"/get"})
    public ResponseEntity<List<DanhSachDuAn>> get() {
        return ResponseEntity.ok(this.danhSachDuAnRepo.findAll());
    }

    @GetMapping({"find/{id}"})
    public ResponseEntity<DanhSachDuAn> findById(@PathVariable("id") Long id) {
        DanhSachDuAn duAn = (DanhSachDuAn)this.danhSachDuAnRepo.findById(id).orElseThrow();
        return ResponseEntity.ok(duAn);
    }

    @PostMapping({"/post"})
    public ResponseEntity post(@RequestBody DanhSachDuAn duAn) {
        DanhSachDuAn savedDuAn = (DanhSachDuAn)this.danhSachDuAnRepo.save(duAn);
        return savedDuAn == null ? new ResponseEntity(savedDuAn, HttpStatus.FORBIDDEN) : ResponseEntity.ok(savedDuAn);
    }

    @PutMapping({"/put/{id}"})
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody DanhSachDuAn duAn) {
        DanhSachDuAn updatedDuAn = (DanhSachDuAn)this.danhSachDuAnRepo.findById(id).orElseThrow();
        updatedDuAn.setTenDuAn(duAn.getTenDuAn());
        updatedDuAn.setTrangThai(duAn.getTrangThai());
        duAn = (DanhSachDuAn)this.danhSachDuAnRepo.save(updatedDuAn);
        return new ResponseEntity(duAn, HttpStatus.FORBIDDEN);
    }

    @GetMapping({"/trangthai/{id}"})
    public ResponseEntity<Set<DanhSachDuAn>> findByTrangThai(@PathVariable("id") Long id) {
        Set<DanhSachDuAn> setDuAns = this.danhSachDuAnRepo.findDanhSachDuAnByTrangThai(id);
        return setDuAns == null ? ResponseEntity.ok(new HashSet()) : ResponseEntity.ok(setDuAns);
    }
}
