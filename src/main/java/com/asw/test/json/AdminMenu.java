package com.asw.test.json;

import java.util.ArrayList;
import java.util.List;

public class AdminMenu {

	private boolean isMainMenu;
	private String currentMenuUrl="";

	private String menuName;
	private String menuUrl;
	private AdminMenu currentMenu;
	private List<AdminMenu> subMenues = null;

	public AdminMenu(){}

	public AdminMenu(String currentUrl){
		this.currentMenuUrl = currentUrl;
	}

	public boolean isMainMenu() {
		return isMainMenu;
	}
	public void setMainMenuYn(boolean isMainMenu) {
		this.isMainMenu = isMainMenu;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public List<AdminMenu> getSubMenues() {
		return subMenues;
	}
	public void setSubMenues(List<AdminMenu> subMenues) {
		this.subMenues = subMenues;
	}

	public void addSubmenu(AdminMenu subMenu){
		if(this.subMenues == null){
			this.subMenues = new ArrayList<AdminMenu>();
		}

		this.subMenues.add(subMenu);
	}

	public boolean isCurrentMenuYN() {

		boolean isCurrentMenu = false;
		if(isHasSubmenues()){
			isCurrentMenu = subMenues.contains(this.currentMenu);
		}
		else{
			isCurrentMenu = this.currentMenuUrl.equals(menuUrl);
		}
		return isCurrentMenu;
	}

	public void setCurrentMenuUrl(String currentMenuUrl) {
		this.currentMenuUrl = currentMenuUrl;
		this.currentMenu = new AdminMenu(currentMenuUrl);
	}
	public String getCurrentMenuUrl(){
		return this.currentMenuUrl;
	}

	public boolean isHasSubmenues(){
		return subMenues != null && !subMenues.isEmpty();
	}

	public boolean equals(Object other){
		boolean equal = false;
		if(other != null){
			equal = this.currentMenuUrl.equals(((AdminMenu) other).getMenuUrl());
		}
		return equal;

	}
	
	public String toString(){
	 StringBuilder sb = new StringBuilder(); 	

	 sb.append("menuName: ");
	 sb.append(menuName);
	 sb.append("menuUrl: ");
	 sb.append(menuUrl);
	 sb.append("subMenues: ");
	 sb.append(subMenues.toString());
	 sb.append("mainMenu: ");
	 sb.append(isMainMenu);

	 return sb.toString();
		
		
	}

}
