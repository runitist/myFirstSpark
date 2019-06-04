package com.example.demo;

import static spark.Spark.*;

public class HtmlSpark {
	public static void main(String[] args) {
		staticFiles.location("/static");
		
		get("/hello", (req, res) -> {
			return "Hello : "+req.queryParams("name")+", age : "+ req.queryParams("age");
		});
		
		post("/hello", (req, res) -> {
			return "post Hello : "+req.queryParams("name")+", age : "+ req.queryParams("age");
		});
	}
}
