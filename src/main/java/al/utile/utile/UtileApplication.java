package al.utile.utile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "al.utile")
public class UtileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtileApplication.class, args);
	}

}
