package com.example.demo.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.*;

@Entity
@Table(name = "Cong_ty")
public class CongTy {

    @Id
    @SequenceGenerator(
            name = "CongTy_seq",
            sequenceName = "CongTy_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CongTy_seq"
    )
    private long congTyId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "congTy")
    private List<NhanVien> nhanVien = new ArrayList<NhanVien>();


    @NotBlank(message = "Ten Cong Ty null")
    private String tenCongTy;

    public CongTy() {
    }

    public CongTy(List<NhanVien> nhanVien, String tenCongTy) {
        this.nhanVien = nhanVien;
        this.tenCongTy = tenCongTy;
    }

    public long getId() {
        return congTyId;
    }

    public void setId(long congTyId) {
        this.congTyId = congTyId;
    }


    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public List<NhanVien> getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(List<NhanVien> nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public String toString() {
        return "CongTy{" +
                "id=" + congTyId +
                ", nhanVien=" + nhanVien +
                ", tenCongTy='" + tenCongTy + '\'' +
                '}';
    }
}

