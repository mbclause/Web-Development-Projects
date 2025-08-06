package model;

public class CourseMapping {

		final int  id;

		String   semesterName;
		
		String   quarterName;
		
		public CourseMapping()
		{
			id = 0;
			
			semesterName = "";
			
			quarterName = "";
		}
		
		public CourseMapping(int id, String semesterName, String  quarterName)
		{
			this.id = id;
			
			this.semesterName = semesterName;
			
			this.quarterName = quarterName;
		}

		public String getSemesterName() {
			return semesterName;
		}

		public void setSemesterName(String semesterName) {
			this.semesterName = semesterName;
		}

		public String getQuarterName() {
			return quarterName;
		}

		public void setQuarterName(String quarterName) {
			this.quarterName = quarterName;
		}

		public int getId() {
			return id;
		}

}
