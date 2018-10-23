package xyz.chamc.examplespringfox.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class HelloController {

	@RequestMapping("/helloworld")
	public String helloWorld() {
		return "Hello World !!";
	}
	
	@RequestMapping("helloyourname")
	public String helloYourName(@RequestParam String name) {
		return "Hello " + name + " !!";
	}
}
