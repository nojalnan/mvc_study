package com.nows.blog;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestController {
	@RequestMapping("/")
	public String index() {
		return "helloworld!";
	}

}
