package com.example.RestAPI_IVIBO.Controllers;
import com.example.RestAPI_IVIBO.Models.LichTrinh;
import com.example.RestAPI_IVIBO.Repositories.LichTrinhRepo;
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
@RequestMapping({"/lichtrinh"})
public class LichTrinhController {
    @Autowired
    LichTrinhRepo lichTrinhRepo;

    public LichTrinhController() {
    }

    @GetMapping({"/get"})
    public ResponseEntity<List<LichTrinh>> get() {
        return ResponseEntity.ok(this.lichTrinhRepo.findAll());
    }

    @GetMapping({"find/{id}"})
    public ResponseEntity<List<LichTrinh>> findById(@PathVariable("id") Long id) {
        List<LichTrinh> lichTrinh = this.lichTrinhRepo.findLichTrinhByCaNhanId(id);
        return ResponseEntity.ok(lichTrinh);
    }

    @PostMapping({"/post"})
    public ResponseEntity post(@RequestBody LichTrinh lichTrinh) {
        LichTrinh savedLichTrinh = (LichTrinh)this.lichTrinhRepo.save(lichTrinh);
        return savedLichTrinh == null ? new ResponseEntity(savedLichTrinh, HttpStatus.FORBIDDEN) : ResponseEntity.ok(savedLichTrinh);
    }

    @PutMapping({"/put/{id}"})
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody LichTrinh lichTrinh) {
        LichTrinh updatedLichTrinh = (LichTrinh)this.lichTrinhRepo.findById(id).orElseThrow();
        updatedLichTrinh.setGhiChu(lichTrinh.getGhiChu());
        updatedLichTrinh.setCaNhan(lichTrinh.getCaNhan());
        updatedLichTrinh.setTieuDe(lichTrinh.getTieuDe());
        updatedLichTrinh.setNgayBatDau(lichTrinh.getNgayBatDau());
        updatedLichTrinh.setNgayKetThuc(lichTrinh.getNgayKetThuc());
        lichTrinh = (LichTrinh)this.lichTrinhRepo.save(updatedLichTrinh);
        return new ResponseEntity(lichTrinh, HttpStatus.OK);
    }

}
