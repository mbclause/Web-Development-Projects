package model;

public class Course {

	final int    id;
	
	String       name;
	
	boolean		isSemester;
	
	boolean     isMapped;
	
	public  Course()
	{
		id = 0;
		
		name = "";
		
		isSemester = false;
		
		isMapped = false;
	}
	
	public Course(int  id, String name, boolean  isSemester, boolean isMapped)
	{
		this.id = id;
		
		this.name = name;
		
		this.isSemester = isSemester;
		
		this.isMapped = isMapped;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSemester() {
		return isSemester;
	}

	public void setSemester(boolean isSemester) {
		this.isSemester = isSemester;
	}

	public boolean isMapped() {
		return isMapped;
	}

	public void setMapped(boolean isMapped) {
		this.isMapped = isMapped;
	}

	public int getId() {
		return id;
	}
		
}
