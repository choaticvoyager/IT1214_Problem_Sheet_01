class Vehicle{
	private String licensePlate;
	private String ownerName;
	private int hoursParked;
	
	Vehicle(String licensePlate, String ownerName, int hoursParked){
		this.licensePlate=licensePlate;
		this.ownerName=ownerName;
		this.hoursParked=hoursParked;
	}
	
	public String getLicensePlate(){
		return licensePlate;
	}
	
	public void setLicensePlate(String licensePlate){
		this.licensePlate=licensePlate;
	}
	
	public String getOwnerName(){
		return ownerName;
	}
	
	public void setOwnerName(String ownerName){
		this.ownerName=ownerName;
	}
	
	public int getHoursParked(){
		return hoursParked;
	}
	
	public void setHoursParked(int hoursParked){
		this.hoursParked=hoursParked;
	}
}

class ParkingLot{
	Vehicle[] vehicles;
	int vehicleCount;
	
	ParkingLot(){
		vehicles= new Vehicle[5];
		vehicleCount=0;
	}
	
	public void addVehicle(String licensePlate, String ownerName, int hoursParked){
		if(vehicleCount<vehicles.length){
			vehicles[vehicleCount]= new Vehicle(licensePlate, ownerName, hoursParked);
			System.out.println(ownerName+" parked the vehicle.");
			vehicleCount++;
		}
		else{
			System.out.println("Vehicle lot is full.");
		}
	}
	
	public void removeVehicle(String licensePlate){
		boolean found=false;
		for(int i=0; i<vehicleCount; i++){
			if(vehicles[i].getLicensePlate().equals(licensePlate)){
				vehicles[i]=null;
				for(int j=i; j<vehicleCount-1; j++){
					vehicles[j]=vehicles[j+1];
				}
				vehicles[vehicleCount-1]=null;
				vehicleCount--;
				System.out.println("Vehicle licensed "+licensePlate+", is removed.");
				found=true;
				break;
			}
		}
		if(found==false){
			System.out.println("Match not found.");
		}
	}
	public void displayInfo(){
		System.out.println("Parked vehicles info: ");
		for(int i=0; i<vehicleCount; i++){
			System.out.println((i+1)+". License: "+vehicles[i].getLicensePlate()+", Owner: "+vehicles[i].getOwnerName()+", Hours: "+vehicles[i].getHoursParked());
		}
	}
} 

class Main{
	public static void main(String[] args){
		ParkingLot lot1=new ParkingLot();
		lot1.addVehicle("ABC123","John Doe",2);
		lot1.addVehicle("XYZ789","Jane Smith",4);
		lot1.addVehicle("LMN456","Bob Brown",1);
		lot1.removeVehicle("XYZ789");
		lot1.displayInfo();
		lot1.removeVehicle("JKL258");
	}
}