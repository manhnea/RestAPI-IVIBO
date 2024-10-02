package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.LichTrinh;
import com.example.RestAPI_IVIBO.Repositories.LichTrinhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/dsduan")
public class DanhSachDuAnController {

    @Autowired
    LichTrinhRepo lichTrinhRepo;

    @GetMapping("/get")
    public ResponseEntity<List<LichTrinh>> get(){
        return  ResponseEntity.ok(lichTrinhRepo.findAll());
    }
}
