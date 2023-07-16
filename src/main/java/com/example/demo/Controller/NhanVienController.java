package com.example.demo.Controller;

import com.example.demo.Model.NhanVien;
import com.example.demo.Model.ResponseObject;
import com.example.demo.Repositories.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/NhanVien")
public class NhanVienController {

    @Autowired
    private NhanVienRepo nhanVienRepo;


    @GetMapping("")
    List<NhanVien> getNhanVien(){
        return nhanVienRepo.findAll();
    }


    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<NhanVien> foundNhanVien = nhanVienRepo.findById(id);
        if(foundNhanVien.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Query successful", foundNhanVien.get().getName())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("fail", "Can not find NhanVien")
            );
        }


    }

    //insert with POST method
    @PostMapping
    ResponseEntity<ResponseObject> insertNhanVien(@RequestBody NhanVien newNhanVien){
        nhanVienRepo.save(newNhanVien);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Insert successfully", newNhanVien.getName())
        );
    }

    //Update
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateNhanVien(@RequestBody NhanVien newNhanVien,@PathVariable Long id){
        NhanVien updateNhanVien = nhanVienRepo.findById(id).map(
                nhanVien -> {
                    nhanVien.setName(newNhanVien.getName());
                    nhanVien.setCongTy(newNhanVien.getCongTy());
                    return nhanVienRepo.save(nhanVien);
                }).orElseGet(()-> {
            newNhanVien.setId(id);
            return nhanVienRepo.save(newNhanVien);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update successfully", newNhanVien.getName())
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> updateNhanVien(@PathVariable Long id){
        boolean exists = nhanVienRepo.existsById(id);
        if(exists){
            nhanVienRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Delete successful")
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("fail","Can not find NhanVien to delete")
            );
        }
    }



}