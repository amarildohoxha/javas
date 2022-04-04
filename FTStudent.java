class FTStudent extends Student{
	FTStudent (int am, String name){
		super(am, name, 10);
	}
	
	public String typeOfStudent(){
		return "Full Time Student";
	}
	
	public String toString(){
		return super.toString()+"Full Time Student";
	}	
}
