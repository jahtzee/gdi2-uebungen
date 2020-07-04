package uebung13;

import java.time.LocalDate;

public class Person {
	private String name, surname;
	LocalDate date;
	public Person() {
		this.name = null;
		this.surname = null;
		this.date = null;
	}
	public Person(String name, String surname, LocalDate date) {
		this.name = name;
		this.surname = surname;
		this.date = date;
	}
	public LocalDate getDate() {
		return this.date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name + " " + surname + " " + date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth();
	}
}
