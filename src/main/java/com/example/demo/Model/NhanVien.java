package com.example.demo.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "NhanVien")
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

    @NotBlank(message = "Ten nhan vien null")
    private String name;


    @ManyToOne
    @JoinColumn (name = "congTyId")
    private CongTy congTy;



}
