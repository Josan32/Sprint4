package cat.itacademy.barcelonactiva.Mosqueda.JoseAntonio.s04.t02.n03.S04T02N03MosquedaJoseAntonio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class S04T02N03MosquedaJoseAntonioApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N03MosquedaJoseAntonioApplication.class, args);
	}

}
