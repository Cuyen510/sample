package com.example.demo.Model;


import jakarta.persistence.*;

import java.util.*;

@Entity@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @SequenceGenerator(
            name = "NhanVien_seq",
            sequenceName = "NhanVien_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "NhanVien_seq"
    )
    private long id;

    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "congTyId")
    private CongTy congTy;


    public NhanVien() {
    }

    public NhanVien(String users) {
        this.name = name;
    }

    public NhanVien(String name, CongTy congTy) {
        this.name = name;
        this.congTy = congTy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CongTy getCongTy() {
        return congTy;
    }

    public void setCongTy(CongTy congTy) {
        this.congTy = congTy;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", congTy=" + congTy +
                '}';
    }
}
