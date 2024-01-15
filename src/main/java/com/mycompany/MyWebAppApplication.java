package com.mycompany;
import com.mycompany.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//Swagger


//Swagger

@SpringBootApplication
@ComponentScan("com.mycompany")
//@EnableSwagger2
public class MyWebAppApplication {

	public static void main(String[] args) {
		Logger logger= LoggerFactory.getLogger(MyWebAppApplication.class);
		logger.info("Running the Web Application");
		SpringApplication.run(MyWebAppApplication.class, args);
	}

}
