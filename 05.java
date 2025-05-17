class Student{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	boolean validateMarks(int marks){
		if(marks<=100 && marks>=0)throws Exception{
			return true;
		}
		else{
			return false;
			throw new Exception("Exception");
		}
	}
	
	Student(String name, int exam1, int exam2, int exam3)throws Exception{
		this.name=name;
			if(validateMarks(exam1)){
				this.exam1=exam1;
			}
			else{
				System.out.println("Exam scores must be between 0 and 100.");
				throw new Exception("Setting the marks value to 0");
			}
			if(validateMarks(exam2)){
				this.exam2=exam2;
			}
			else{
				System.out.println("Exam scores must be between 0 and 100.");
				throw new Exception("Setting the marks value to 0");
			}
			if(validateMarks(exam3)){
				this.exam3=exam3;
			}
			else{
				System.out.println("Exam scores must be between 0 and 100.");
				throw new Exception("Setting the marks value to 0");
			}
	} 
	
	public String getName(){
		return name;
	}
	
	public int getExam1(){
		return exam1;
	}
	
	public int getExam2(){
		return exam2;
	}
	
	
	public int getExam3(){
		return exam3;
	}
	
	public double calculateAverage(){
		return (exam1+exam2+exam3)/3;
	}
}

class StudentDemo{	
	public static void main(String[] args){
		Student s1;
		try{
			s1=new Student("John",75,110,90);
		}
		catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		System.out.println("Name: "+s1.getName()+"\nExam 1: "+s1.getExam1()+"\nExam 2: "+s1.getExam2()+"\nExam 3: "+s1.getExam3());
		System.out.println(s1.getName()+"'s Average: "+s1.calculateAverage());

	}
}
