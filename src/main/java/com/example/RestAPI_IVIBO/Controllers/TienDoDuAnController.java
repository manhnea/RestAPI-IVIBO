package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.TienDoDuAn;
import com.example.RestAPI_IVIBO.Repositories.TienDoDuAnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TienDoDuAn")
public class TienDoDuAnController {
    @Autowired
    TienDoDuAnRepo tienDoDuAnRepo;
    @GetMapping("/get")
    public ResponseEntity<List<TienDoDuAn>> get(){
        return ResponseEntity.ok(tienDoDuAnRepo.findAll());
    }
}
