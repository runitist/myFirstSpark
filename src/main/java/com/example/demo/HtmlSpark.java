package com.example.demo;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class HtmlSpark {
	public static void main(String[] args) {
		staticFiles.location("/static");

		get("/hello", (req, res) -> {
			return "Hello : " + req.queryParams("name") + ", age : " + req.queryParams("age");
		});

		post("/hello", (req, res) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("name", req.queryParams("name"));
			model.put("age", req.queryParams("age"));

			return render(model, "result.html");
		});
	}

	public static String render(Map<String, Object> model, String templatePath) {

		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
