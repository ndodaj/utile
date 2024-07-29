package al.utile.utile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "al.utile")
@EnableDiscoveryClient
public class UtileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtileApplication.class, args);
	}

}
