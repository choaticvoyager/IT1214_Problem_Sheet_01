class Student{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	Student(String name, int exam1, int exam2, int exam3){
		this.name=name;
		if(exam1>=0 && exam1<=100){
			this.exam1=exam1;
		}
		else{
			throw new IllegalArgumentException("Exam 1 score must be between 0 and 100.");
		}
		if(exam2>=0 && exam2<=100){
			this.exam2=exam2;
		}
		else{
			throw new IllegalArgumentException("Exam 2 score must be between 0 and 100.");
		}
		if(exam3>=0 && exam3<=100){
			this.exam3=exam3;
		}
		else{
			throw new IllegalArgumentException("Exam 3 score must be between 0 and 100.");
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
		return (exam1+exam2+exam3)/3.0;
	}
}

class StudentDemo{	
	public static void main(String[] args){
		//For invalid exam scores
		Student s1=null;
		try{
			s1=new Student("John",75,110,90);
		}
		catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		if(s1!=null){
			System.out.println("Name: "+s1.getName()+"\nExam 1: "+s1.getExam1()+"\nExam 2: "+s1.getExam2()+"\nExam 3: "+s1.getExam3());
			System.out.print(s1.getName()+"'s Average: ");
			System.out.printf("%.2f%n",s1.calculateAverage());
		}
		
		//For valid input
		Student s2=null;		
		try{
			s2=new Student("Kane",87,65,78);
		}
		catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}		
		if(s2!=null){
			System.out.println("Name: "+s2.getName()+"\nExam 1: "+s2.getExam1()+"\nExam 2: "+s2.getExam2()+"\nExam 3: "+s2.getExam3());
			System.out.print(s2.getName()+"'s Average: ");
			System.out.printf("%.2f%n",s2.calculateAverage());
		}
	}
}