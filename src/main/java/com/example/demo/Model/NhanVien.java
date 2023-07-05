package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "NhanVien2")
public class NhanVien {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "NhanVien_sequence",
            sequenceName = "NhanVien_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "NhanVien_sequence"
    )
    private long id;
    @Column
    private String name;

    public NhanVien() {
    }

    public NhanVien(String users) {
        this.name = name;
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

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
