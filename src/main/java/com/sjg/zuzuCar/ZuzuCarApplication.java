package com.sjg.zuzuCar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sjg.zuzuCar.Mapper")
public class ZuzuCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuzuCarApplication.class, args);
	}

}
