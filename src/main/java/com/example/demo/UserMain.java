package com.example.demo;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class UserMain {
	public static void main(String[] args) {
		staticFiles.location("/static");
		
		List<User> users = new ArrayList<User>();

		get("/users", (req, res) -> {
			return "Hello : " + req.queryParams("name") + ", age : " + req.queryParams("age");
		});

		post("/users", (req, res) -> {
			//User user = new User(req.queryParams("name"), req.queryParams("age"));
			User user = new User();
			user.setAge(req.queryParams("age"));
			user.setName(req.queryParams("name"));
			users.add(user);
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("users", users);

			return render(model, "resultmany.html");
		});
	}

	public static String render(Map<String, Object> model, String templatePath) {

		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
