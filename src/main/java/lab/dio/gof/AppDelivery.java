package lab.dio.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppDelivery {

	public static void main(String[] args) {
		SpringApplication.run(AppDelivery.class, args);
	}

}
