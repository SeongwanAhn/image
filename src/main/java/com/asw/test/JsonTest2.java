package com.asw.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.asw.test.json.AdminMenu;
import com.asw.test.json.Staff;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest2 {

	public static void main(String[] args) {
		JsonTest2 obj = new JsonTest2();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Convert JSON string from file to Object
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("menu.json");
			List<AdminMenu> menu = mapper.readValue(is, List.class);
			System.out.println(menu);

			// Convert JSON string to Object
			String jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
			Staff staff1 = mapper.readValue(jsonInString, Staff.class);
			System.out.println(staff1);

			// Pretty print
			String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
			System.out.println(prettyStaff1);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
