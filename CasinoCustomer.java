//Agni Paila   AM:4753

class CasinoCustomer{
	
	private String name;
	private double money;
	
	public CasinoCustomer(String name, double money){
		this.name=name;
		this.money=money;
	}
	
	public double getMoney(){
		return this.money;
	}
	
	public void payBet(double bet){
		this.money=money-bet;
	}
	
	public void collectBet(double bet){
		this.money=money+bet;
	}
	
	public boolean canCover(double bet){
		if(bet<=this.money){      
			return true;
		}
		return false;
	}
	
	public boolean isBroke(){
		if(money<1.0){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return this.name; 
	}
	
	public void printState(){
		System.out.println("Costumer's name: "+this.name+" with "+this.money+" money.");
	}
	
	public static void main(String[] args){
		CasinoCustomer costumer1=new CasinoCustomer("agni",100.00);
		System.out.println(costumer1);
		costumer1.payBet(20.0);
		costumer1.collectBet(10.0);
		System.out.println(costumer1.canCover(30.0));
		costumer1.payBet(30.0);
		costumer1.printState();
		System.out.println(costumer1.isBroke());
		System.out.println(costumer1.canCover(61.0));
		costumer1.payBet(60.0);
		System.out.println(costumer1.isBroke());
		costumer1.printState();
	}
}