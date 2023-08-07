package com.example.springdemo;
//Spring imports
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Java imports
import java.time.LocalDateTime;
@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Spring Demo Application is Alive:"+LocalDateTime.now().toLocalDate()+" "+LocalDateTime.now().toLocalTime();
	}

}
