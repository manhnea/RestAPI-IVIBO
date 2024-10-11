package com.example.RestAPI_IVIBO.Controllers;

import com.example.RestAPI_IVIBO.Models.CaNhan;
import com.example.RestAPI_IVIBO.Models.DanhSachChamCong;
import com.example.RestAPI_IVIBO.Repositories.CaNhanRepo;
import com.example.RestAPI_IVIBO.Repositories.DanhSachChamCongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/DanhSachChamCong")
public class DanhSachChamCongController {
       private double targetLatitude = 20.838447688138174;
       private double targetLongtitude =  106.71434504769483;
       private double targetDistance = 0.25;//in Kilometers

    @Autowired
    DanhSachChamCongRepo danhSachChamCongRepo;

    @Autowired
    CaNhanRepo caNhanRepo;
    @GetMapping("/get")
    public ResponseEntity<List<DanhSachChamCong>> get(){
        return ResponseEntity.ok(danhSachChamCongRepo.findAll());
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<DanhSachChamCong> getById(Long id){
        return ResponseEntity.ok(danhSachChamCongRepo.findById(id).get());
    }
    @PostMapping("/add")
    public ResponseEntity<DanhSachChamCong> add(@RequestBody DanhSachChamCong danhSachChamCong){
        return ResponseEntity.ok(danhSachChamCongRepo.save(danhSachChamCong));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<DanhSachChamCong> update(@PathVariable Long id, @RequestBody DanhSachChamCong danhSachChamCong){
        DanhSachChamCong danhSachChamCong1 = danhSachChamCongRepo.findById(id).get();
        return ResponseEntity.ok(danhSachChamCongRepo.save(danhSachChamCong));
    }
    @GetMapping("/chamcong")
    public ResponseEntity checking(@RequestParam("id") Long id,
                                   @RequestParam("latitude") String latitude,
                                   @RequestParam("longitude") String longitude ){
        Double dLatitude = Double.parseDouble(latitude);
        Double dLongitude = Double.parseDouble(longitude);
        double currentDistance = haversineDistance(dLatitude,dLongitude,targetLatitude,targetLongtitude);
        Map<String, String> map = new HashMap<>();

        // Convert to JSON
        map.put("time",Instant.now().toString());
        if(Math.abs(currentDistance)<=targetDistance){
            map.put("status","true");
            //Diem danh tren DB
            DanhSachChamCong danhSachChamCong = new DanhSachChamCong();
            CaNhan caNhan =caNhanRepo.findById(id).orElseThrow();
            danhSachChamCong.setCaNhan(caNhan);
            Date date = new Date();
            danhSachChamCong.setThoiGian(date);
            danhSachChamCongRepo.save(danhSachChamCong);
            return ResponseEntity.ok(mapToJson(map));
        }else{
            //Neu khong du gan
            map.put("status","false");
            return ResponseEntity.ok(map);
        }
    }

    public static double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Radius of the Earth in kilometers
        double dLat = toRadians(lat2 - lat1);
        double dLon = toRadians(lon2 - lon1); // Corrected this line

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(toRadians(lat1)) * Math.cos(toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c; // Distance in kilometers

        return distance;
    }

    private static double toRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    private static String mapToJson(Map<String, String> map) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":\"")
                    .append(entry.getValue()).append("\",");
        }
        // Remove trailing comma and close JSON
        json.deleteCharAt(json.length() - 1).append("}");
        return json.toString();
    }
}
