package com.example.demo.Controller;

import com.example.demo.Model.CongTy;
import com.example.demo.Model.NhanVien;
import com.example.demo.Model.ResponseObject;
import com.example.demo.Repositories.CongTyRepository;
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

    @Autowired
    private CongTyRepository congTyRepository;


    @GetMapping("")
    List<NhanVien> getNhanVien(){
        return nhanVienRepo.findAll();
    }


    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable long id){
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
    ResponseEntity<ResponseObject> updateCongTy(@RequestBody NhanVien nhanVien, @PathVariable long id) {
        CongTy congTy = congTyRepository.findById(nhanVien.getCongTy().getCongTyId()).get();

        nhanVien = nhanVienRepo.findById(id).get();
        System.out.println(nhanVien.getId() + "  " + id);
        nhanVien.setName(nhanVien.getName());

        nhanVien.setCongTy(congTy);
        nhanVienRepo.save(nhanVien);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update successfully"));

    }


    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> updateNhanVien(@PathVariable long id){
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