class PTStudent extends Student{
	private String job;
	PTStudent (int am, String name, String job){
		super(am, name, 5);
		this.job = job;
	}
	
	public String getJob(){
		return job;
	}
	public void setJob(String job){
		this.job = job;
	}	
	
	public String typeOfStudent(){
		return "Part Time Student";
	}
	
	public String toString(){
		return super.toString()+"Part Time Student";
	}	
}
