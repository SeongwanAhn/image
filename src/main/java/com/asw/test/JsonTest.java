package com.asw.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.asw.test.json.AdminMenu;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	public static void main(String[] args) {
		JsonTest obj = new JsonTest();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		List<AdminMenu> staff = createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("D:\\staff.json"), staff);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(staff);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<AdminMenu> createDummyObject() {

		List<AdminMenu> menues = new ArrayList<AdminMenu>();

		AdminMenu mainmenu = new AdminMenu();
		mainmenu.setMenuName("사용자");
		mainmenu.setMenuUrl("/admin/user/list");
		mainmenu.setMainMenuYn(true);

		menues.add(mainmenu);

		mainmenu = new AdminMenu();
		mainmenu.setMenuName("공통코드");
		mainmenu.setMenuUrl("#");
		mainmenu.setMainMenuYn(true);


		AdminMenu submenu = new AdminMenu();
		submenu.setMenuName("공통코드");
		submenu.setMenuUrl("/admin/common/code/list");
		submenu.setMainMenuYn(false);

		mainmenu.addSubmenu(submenu);

		menues.add(mainmenu);

		return menues;

	}

}
