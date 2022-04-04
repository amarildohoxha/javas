abstract class Student implements Comparable{
	private int am;
	private String name;
	private Course courses[];
	
	Student (int am, String name, int size){
		this.am = am;
		this.name = name;
		courses = new Course[size];
	}
	
	public int getAM(){
		return am;
	}
	public String getName(){
		return name;
	}
	public Course[] getCourses(){
		return courses;
	}
	
	private int find(int code){
		for (int i=0; i<courses.length; i++){
			if (courses[i] != null){
				if (courses[i].getCode() == code){
					return i;
				}
			}
		}
		return -1;
	}
	
	public void addCourse(Course c) throws ThereIsNoSpaceException {
		if (find(c.getCode()) != -1){
			System.out.println("Course "+c+" exists in the courses array");
			return;
		}
		
		boolean flag = false;
		for (int i=0; i<courses.length; i++){
			if (courses[i] == null){
				courses[i] = c;
				flag=true;
				break;
			}
		}
		if (!flag){
			throw new ThereIsNoSpaceException("There is no space in the courses array");
		}
	}
	
	public void removeCourse(int courseCode){
		int pos = find(courseCode);
		if (pos != -1){
			courses[pos] = null;
		}
	}
	
	public abstract String typeOfStudent();
	
	public int getSumECTS(){
		int sum=0;
		for (int i=0; i<courses.length; i++){
			if (courses[i] != null){ 
				sum += courses[i].getECTS();
			}
		}
		return sum;
	}
	
	private int countCourses(){
		int counter = 0;
		for (int i=0; i<courses.length; i++){
			if (courses[i] != null){
				counter++;
			}
		}
		return counter;
	}
	
	public void sortingDesc(){
		if (countCourses() < courses.length){
			System.out.println("The array cannot be sorted because there are empty spaces");
			return;
		}
		Course temp;
		for (int i=1; i<courses.length;i++){
			for (int j=courses.length-1; j>=i;j--){				
				if (courses[j-1].compareTo(courses[j]) == -1){
					temp = courses[j-1];
					courses[j-1] = courses[j];
					courses[j] = temp;
				}				
			}
		}
	}
	
	public String toString(){
		String s = "AM:"+am+" Name:"+name+" Sum of ECTS"+ getSumECTS() +" Courses:"+countCourses()+"\n";
		for (int i=0; i<courses.length; i++){
			if (courses[i] != null){ 
				s += courses[i]+"\n";
			}
		}
		return s;
	}
	
	public int compareTo(Object o) {
		int retVal = -2;
		if(o instanceof Student) {	
			int sum1 = getSumECTS();
			int sum2 = ((Student)o).getSumECTS();
			if (sum1 == sum2){
				retVal = 0;
			}
			else if (sum1 > sum2){
				retVal = 1;
			}
			else {
				retVal = -1;
			}
		}
		return retVal;
	}
	
}
