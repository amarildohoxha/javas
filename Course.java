class Course implements CourseInterface, Comparable {
	private int code;
	private int ects;
	private String title;
	
	Course (int code, int ects, String title){
		this.code = code;
		this.ects = ects;
		this.title = title;
	}
	
	public int getCode(){
		return code;
	}
	public int getECTS(){
		return ects;
	}
	public String getTitle(){
		return title;
	}
	public String toString(){
		return "Code:"+code+", ECTS:"+ects+", Title:"+title;
	}
	public int compareTo(Object o) {		
 		int retVal = -2;
		if(o instanceof Course) {			
			if (ects == ((Course)o).getECTS()){
				retVal = 0;
			}
			else if (ects > ((Course)o).getECTS()){
				retVal = 1;
			}
			else {
				retVal = -1;
			}
		}
		return retVal;
	}
	
}
