package model;

public class Language {

	String  name;
	
	int     numPeople;
	
	public Language() {
		
		name = "";
		
		numPeople = 0;
	}
	
	
	public Language(String name) {
		
		this.name = name;
		
		numPeople = 0;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumPeople() {
		return numPeople;
	}


	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}
	
	public void  incNumPeople() {
		
		numPeople++;
	}
	
}
