package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.ChucVu;
import com.example.RestAPI_IVIBO.Repositories.ChucVuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ChucVu")
public class ChucVuController {
    @Autowired
    ChucVuRepo chucVuRepo;
    @GetMapping("/get")
    public ResponseEntity<List<ChucVu>> get(){
        return ResponseEntity.ok(chucVuRepo.findAll());
    }
}
