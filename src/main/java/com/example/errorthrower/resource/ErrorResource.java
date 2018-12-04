package com.example.errorthrower.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("errors")
public class ErrorResource {

	@GetMapping("overflow")
	public String throwNullPointer() {
		return recursive("teste");
	}

	private String recursive(String string) {
		return recursive(string + string);
	}

}