package com.example.errorthrower.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("errors")
public class ErrorResource {

	@GetMapping("overflow")
	public String throwStackOverflow() {
		return recursive("teste");
	}

	private String recursive(String string) {
		return recursive(string + string);
	}

	@GetMapping("oom")
	public String throwOutOfMemory() {

		Set<String> set = new HashSet<>();
		String str = "";
		while (str != "end") {
			str += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv";
			set.add(str);
		}

		return "ok";
	}

}