//Agni Paila   AM:4753

import java.util.Scanner;

class BlackjackTable{
	
	private River tableRiver=new River(6);
	private CasinoCustomer[] customers;
	private int participants;
	
	public BlackjackTable(int participants){
		this.participants=participants;
		CasinoCustomer[] customers=new CasinoCustomer[participants];
		for(int i=0; i<customers.length; i++){
			customers[i]=createCasinoCustomer();
		}
		this.customers=customers;
	}
	
	private CasinoCustomer createCasinoCustomer(){
		Scanner input =new Scanner(System.in);
		System.out.println("Please give me your name");
		String name=input.next();
		System.out.println("Please give me your available money");
		double money=input.nextDouble();
		CasinoCustomer casinoPlayer=new CasinoCustomer(name,money);
		return casinoPlayer;
	}
	
	public void play(){
		for(int i=0; i<customers.length; i++){
			while(customers[i].getMoney()>0){
				if(tableRiver.shouldRestart()){
					tableRiver.restart();
				}
				Round round=new Round(tableRiver);
				System.out.println("-----NEW ROUND-----");
				if(customers[i].getMoney()>0){
					round.addPlayer(customers[i]);
					round.playRound();
				}
			}
		}
	}
}