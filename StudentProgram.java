import java.util.Scanner;

class StudentProgram{
	public static void main (String [] args){
		
		Course c[] = new Course[10];
		c[0] = new Course(101,2,"Mathimatika I");
		c[1] = new Course(102,6,"Programmatismos I");
		c[2] = new Course(103,5,"Fysiki");
		c[3] = new Course(104,4,"Psifiaki Sxediasi");
		c[4] = new Course(105,3,"Eisagogi sta Psifiaka Systimata");
		c[5] = new Course(201,5,"Pithanotites kai Statistiki");
		c[6] = new Course(202,6,"Progrmmatismos II");
		c[7] = new Course(203,5,"Antikeimenostrafis Programmatismos");
		c[8] = new Course(204,3,"Algorithmoi kai Domes Dedomenon");
		c[9] = new Course(205,4,"Diktia Ypologiston");
		
		Student s[] = new Student[5];
		s[0] = new FTStudent(190102, "Kostas Konstantinou");
		s[1] = new PTStudent(180201, "Maria Marious", "Grammateas");
		s[2] = new PTStudent(180153, "Petros Petrou", "Oikonomologos");
		s[3] = new FTStudent(190222, "Eleni Eleniou");
		s[4] = new FTStudent(199912, "Stefanos Stefanou");
		
		Scanner mscan = new Scanner(System.in);
		int indf, indm;
		do {
			System.out.print("Dose index fititi (0-4) h -1 gia exodo:");
			indf = mscan.nextInt();
			if (indf != -1){
				System.out.print("Dose index mathimatos (0-9):");
				indm = mscan.nextInt();
				try {
					s[indf].addCourse(c[indm]);
				} 
				catch (ThereIsNoSpaceException x){
					System.out.println(x);
				}
			}
		} while (indf != -1);
		
		s[0].removeCourse(103);		
		
		for (int i=0; i<s.length; i++){
			s[i].sortingDesc();
		}
		
		System.out.println("---------");
		printlAllFTStudents(s);
		System.out.println("---------");
		printlAllPTStudents(s);
		System.out.println("---------");
		printlAllStudents(s);
		System.out.println("---------");
		System.out.println(findMaxECTSStudent(s));
		
		sortStudents(s);
		
		System.out.println("---------");
		printlAllFTStudents(s);
		System.out.println("---------");
		printlAllPTStudents(s);
		System.out.println("---------");
		printlAllStudents(s);
		System.out.println("---------");		
		
		
		
	}
	
	static void printlAllFTStudents(Student s[]){
		for (int i=0; i<s.length; i++){
			if (s[i] instanceof FTStudent){
				System.out.println(s[i]);
			}
		}
	}
	static void printlAllPTStudents(Student s[]){
		for (int i=0; i<s.length; i++){
			if (s[i] instanceof PTStudent){
				System.out.println(s[i]);
			}
		}
	}
	static void printlAllStudents(Student s[]){
		for (int i=0; i<s.length; i++){
			System.out.println(s[i].getAM()+ " "+ s[i].typeOfStudent() + " "+ s[i].getSumECTS());			
		}
	}
	
	static Student findMaxECTSStudent(Student s[]){
		Student maxs = s[0];
		for (int i=1; i<s.length; i++){
			if (s[i].getSumECTS() > maxs.getSumECTS()){
				maxs = s[i];
			}
		}
		return maxs;
	}
	
	static void sortStudents(Student s[]){
		Student temp;
		for (int i=1; i<s.length;i++){
			for (int j=s.length-1; j>=i; j--){				
				if (s[j-1].compareTo(s[j]) == -1){
					temp = s[j-1];
					s[j-1] = s[j];
					s[j] = temp;
				}				
			}
		}		
	}
	
}
