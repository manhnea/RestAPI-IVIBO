package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.MucDo;
import com.example.RestAPI_IVIBO.Repositories.MucDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MucDo")
public class MucDoController {
    @Autowired
    MucDoRepo mucDoRepo;
    @GetMapping("/get")
    public ResponseEntity<List<MucDo>> get(){
        return ResponseEntity.ok(mucDoRepo.findAll());
    }
}
