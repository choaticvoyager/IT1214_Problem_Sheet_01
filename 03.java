class BankAccount{
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	BankAccount(int accountNumber, String accountHolder, double balance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber){
		this.accountNumber=accountNumber;
	}

	public String getAccountHolder(){
		return accountHolder;
	}
	
	public void setAccountHolder(String accountHolder){
		this.accountHolder=accountHolder;
	}

	public double getBalance(){
		return balance;
	}
	
	public void setBalance(double balance){
		this.balance=balance;
	}
	
	public void withdraw(double amount){
		if(balance>=amount){
			balance=balance-amount;
			System.out.println("Withdrawal successful! Account balance: "+balance);
		}
		else{
			throw new IllegalArgumentException("Insufficient balance!");
		}
	}
}

class Bank{
	BankAccount[] accounts;
	int accountCount;
	
	Bank(){
		accounts=new BankAccount[5];
		accountCount=0;
	}
	
	public void addAccount(int accountNumber, String accountHolder, double balance){
		accounts[accountCount] = new BankAccount(accountNumber,accountHolder,balance);
		accountCount++;
		System.out.println(accountHolder+" created an account.");
	}
	
	public void moneyWithdrawal(int accountNumber, double amount){
		try{
			for(int i=0; i<accountCount; i++){
				if(accounts[i].getAccountNumber()==accountNumber){
					accounts[i].withdraw(amount);
					break;
				}
			}
		}
		catch(IllegalArgumentException e){
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public void displayInfo(){
		System.out.println("Accounts info: ");
		for(int i=0; i<accountCount; i++){
			System.out.println((i+1)+". Account Number: "+accounts[i].getAccountNumber()+", Account Holder: "+accounts[i].getAccountHolder()+", Balance: "+accounts[i].getBalance());
		}
	}
}

class BankingDemo{
	public static void main(String[] args){
		Bank bank1=new Bank();
		bank1.addAccount(1001,"Alice",5000.00);
		bank1.addAccount(1002,"Bob",3000.00);
		bank1.moneyWithdrawal(1001,6000.00);
		bank1.moneyWithdrawal(1002,1000.00);
		bank1.displayInfo();
	}
}