package model;

import java.util.Arrays;

public class InfoEnterprise {
	private String name;
	private String logo;
	private long[] contacts;
	private String schedule;
	private String descriptionEnt;
	
	public InfoEnterprise(String name, String logo, long[] contacts, String schedule, String descriptionEnt) {
		this.name = name;
		this.logo = logo;
		this.contacts = contacts;
		this.schedule = schedule;
		this.descriptionEnt = descriptionEnt;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public long[] getContacts() {
		return contacts;
	}
	public void setContacts(long[] contacts) {
		this.contacts = contacts;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDescriptionEnt() {
		return descriptionEnt;
	}

	public void setDescriptionEnt(String descriptionEnt) {
		this.descriptionEnt = descriptionEnt;
	}

	@Override
	public String toString() {
		return "InfoEnterprise [name=" + name + ", logo=" + logo + ", contacts=" + Arrays.toString(contacts)
				+ ", schedule=" + schedule + ", descriptionEnt=" + descriptionEnt + "]";
	}
	
	
}
