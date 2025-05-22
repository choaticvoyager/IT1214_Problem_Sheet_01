class Ticket{
	private int ticketNumber;
	private String customerName;
	private int seatNumber;
	
	Ticket(int ticketNumber, String customerName, int seatNumber){
		this.ticketNumber=ticketNumber;
		this.customerName=customerName;
		this.seatNumber=seatNumber;
	}
	
	public int getTicketNumber(){
		return ticketNumber;
	}
	
	public void setTicketNumber(int ticketNumber){
		this.ticketNumber=ticketNumber;
	}
	
	public String getCustomerName(){
		return customerName;
	}
	
	public void setCustomerName(String customerName){
		this.customerName=customerName;
	}
	
	public int getSeatNumber(){
		return seatNumber;
	}
	
	public void setSeatNumber(int seatNumber){
		this.seatNumber=seatNumber;
	}
}

class BookingSystem{
	Ticket[] tickets;
	int max=10;
	
	BookingSystem(){
		tickets= new Ticket[max];
	}
	
	public void bookTicket(int ticketNumber, String customerName, int seatNumber){
		//For checking valid seat number
		if(seatNumber<1 || seatNumber>max){
			System.out.println("Invalid seat number!");
			return;
		}

		for(int i=0; i<max; i++){
			//To book a ticket with seat availability
			if(tickets[i]==null){
				tickets[i]=new Ticket(ticketNumber,customerName,seatNumber);
				System.out.println("Ticket booked successfully for "+customerName+"!");
				return;
			}
			//Prevent double booking of seat 
			else if(tickets[i]!=null && tickets[i].getSeatNumber()==seatNumber){
				System.out.println("Seat "+seatNumber+" is already booked!");
				return;
			}
		}
		System.out.println("All seats are booked. Booking failed!");
	}
	
	public void cancelTicket(int ticketNumber){
		for(int i=0; i<max; i++){
			if(tickets[i]!=null && tickets[i].getTicketNumber()==ticketNumber){
				tickets[i]=null;
				System.out.println("Ticket "+ticketNumber+" is cancelled.");
				return;
			}
		}
		System.out.println("Invalid ticket number!");
	}
	
	public void displayInfo(){
		boolean booked=false;		

		System.out.println("Current Bookings: ");
		for(int i=0; i<max; i++){
			if(tickets[i]!=null){
				System.out.println(" Ticket Number: "+tickets[i].getTicketNumber()+", Customer Name: "+tickets[i].getCustomerName()+", Seat Number: "+tickets[i].getSeatNumber());
				booked=true;
			}
		}
		
		if(booked==false){
			System.out.println(" No bookings found!");
		}
	}
}

class BookingDemo{
	public static void main(String[] args){
		BookingSystem booking=new BookingSystem();
		booking.bookTicket(1,"Alice",1);
		booking.bookTicket(2,"Bob",2);
		booking.bookTicket(3,"John",3);
		booking.cancelTicket(2);
		booking.bookTicket(4,"David",2);
		booking.displayInfo();
	}
}