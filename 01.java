class Student{
    private int studentID;
    private String name;
    private int daysAttended;

    Student(int  studentID, String name, int daysAttended){
        this.studentID=studentID;
        this.name=name;
        this.daysAttended=daysAttended;
    }

	public int getStudentID(){
		return studentID;
	}
	
	public void setStudentID(int studentID){
        this.studentID=studentID;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
        this.name=name;
	}
	
	public int getDaysAttended(){
		return daysAttended;
	}
	
	public void setDaysAttended(int daysAttended){
        this.daysAttended=daysAttended;
	}
} 

class Classroom{
	Student[] students;
	int studentCount;
	
	Classroom(){
		students=new Student[10];
		studentCount=0;
	}
	
	public void addStudent(int studentID, String name, int daysAttended){
		if(studentCount<students.length){
			students[studentCount]=new Student(studentID, name, daysAttended);
			System.out.println("Student named "+students[studentCount].getName()+" is added.");
			studentCount++;
		}
		else{
			System.out.println("Classroom is full.");
		}
	}
	
	public void updateDaysAttended(int studentID, int days){
		boolean found=false;
		for(int i=0; i<studentCount; i++){
			if(students[i].getStudentID()==studentID){
				students[i].setDaysAttended(days);
				System.out.println("The attendace of Student ID: "+studentID+", is updated.");
				found=true;
				break;
			}
		}
		if(found==false){
			System.out.println("Student ID: "+studentID+", does not exist.");
		}
	}
	
	public void displayInfo(){
		System.out.println("Students info: ");
		for(int i=0; i<studentCount; i++){
			System.out.println((i+1)+". Student ID: "+students[i].getStudentID()+", Name: "+students[i].getName()+", Days attended: "+students[i].getDaysAttended());
		}
	}
}

class Main{	
	public static void main(String[] args){
		Classroom c1=new Classroom();
		c1.addStudent(101,"Alice Smith",12);
		c1.addStudent(102,"Bob Jones",15);
		c1.addStudent(103,"Carol Lee",10);
		c1.updateDaysAttended(102,16);
		c1.updateDaysAttended(104,10);
		c1.displayInfo();
	}
}