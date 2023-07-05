package com.example.demo.Database;

import com.example.demo.Model.NhanVien;
import com.example.demo.Repositories.NhanVienRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static final Logger logger =  LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(NhanVienRepo nhanVienRepo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                NhanVien NhanVienB = new NhanVien("NhanVienB");
//                NhanVien NhanVienA = new NhanVien("NhanVienA");
//                NhanVien NhanVienC = new NhanVien("NhanVienC");
//                logger.info("insert data: "+ nhanVienRepo.save(NhanVienB));
//                logger.info("insert data: "+ nhanVienRepo.save(NhanVienA));
//                logger.info("insert data: "+ nhanVienRepo.save(NhanVienC));
            }
        };
    }

}
