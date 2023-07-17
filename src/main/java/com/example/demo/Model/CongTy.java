package com.example.demo.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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


}

