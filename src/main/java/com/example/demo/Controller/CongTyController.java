package com.example.demo.Controller;

import com.example.demo.Model.CongTy;
import com.example.demo.Model.NhanVien;
import com.example.demo.Model.ResponseObject;
import com.example.demo.Repositories.CongTyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/CongTy")
public class CongTyController {
    @Autowired
    private CongTyRepository congTyRepository;

    @GetMapping("")
    List<CongTy> getCongTy(){
        return congTyRepository.findAll();
    }


    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable long id){
        Optional<CongTy> foundCongTy = congTyRepository.findById(id);
        if(foundCongTy.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Query successful",foundCongTy.get().getTenCongTy())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("fail", "Can not find CongTy")
            );
        }


    }

    //insert with POST method
    @PostMapping
    ResponseEntity<ResponseObject> insertCongTy(@RequestBody CongTy newCongTy){
        congTyRepository.save(newCongTy);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Insert successfully")
        );
    }

    //Update
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateCongTy(@RequestBody CongTy congTy, @PathVariable long id) {

        congTy = congTyRepository.findById(id).get();

        congTy.setTenCongTy(congTy.getTenCongTy());

        congTyRepository.save(congTy);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update successfully"));

    }
//        CongTy updateCongTy = congTyRepository.findById(id).map(
//                congTy -> {
//                    congTy.setTenCongTy(newCongTy.getTenCongTy());
//                    congTy.setNhanVien(newCongTy.getNhanVien());
//                    return congTyRepository.save(newCongTy);
//                }).orElseGet(()-> {
//            newCongTy.setCongTyId(id);
//            return congTyRepository.save(newCongTy);
//        });
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("ok","Update successfully")
//        );



    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteCongTy(@PathVariable long id){
        boolean exists = congTyRepository.existsById(id);
        if(exists){
            congTyRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Delete successful")
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("fail","Can not find CongTy to delete")
            );
        }
    }


}
