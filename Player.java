//Agni Paila   

import java.util.Scanner;

class Player{

	private CasinoCustomer player;  
	private Hand playerHand;    
	private double bet;      

	public Player(CasinoCustomer player){
		this.player=player;
		Hand playerHand=new Hand();
		this.playerHand=playerHand;
		this.bet=bet;
	}
	
	public Player(CasinoCustomer player, Hand playerHand, double bet){
		this.player=player;
		this.playerHand=playerHand;
		this.bet=bet;
	}
	
	public Player(){
	}
	
	public CasinoCustomer getPlayer(){
		return player;
	}
	
	public Hand getPlayerHand(){
		return playerHand;
	}
	
	public double getBet(){
		return bet;
	}
	
	public void wins(){
		player.collectBet(bet);
		System.out.println("you win");
	}
	
	public void winsBlackjack(){
		player.collectBet(1.5*bet);
		System.out.println("you win blackjack");
	}
	
	public void loses(){
		player.payBet(bet);
		System.out.println("you lost");
	}
	
	public void placeBet(){
		System.out.println("economic situation:"+this.player.getMoney());
		Scanner input= new Scanner(System.in);
		System.out.println("put a bet");
		double x=input.nextDouble();
		while(x<1.0){
			System.out.println("please put an acceptable bet");
			x=input.nextDouble();
		}
		if(player.canCover(x)){
			this.bet=x;
		}else{
			System.out.println("you can not cover this bet");
		}
	}
	
	public void doubleBet(){
		this.bet=2.0*bet;
	}
	
	public boolean wantsToDouble(){
		if(this.player.getMoney()>=2.0*this.bet){
			System.out.println("Do you want to double your bet? (yes or no)");
			Scanner input=new Scanner(System.in);
			String x=input.next();
			if(x.equals("yes")){
				System.out.println("you have doubled your bet");
				return true;
			}else if(x.equals("no")){
				System.out.println("you didn't want to double your bet");
				return false;
			}
		}
		System.out.println("you don't have enough money to double your bet");
		return false;
	}
	
	public boolean wantsToSplit(){
		if(player.getMoney()>=2.0*this.bet){
			System.out.println("Do you want to split? (yes or no)");
			Scanner input=new Scanner(System.in);
			String x=input.next();
			if(x.equals("yes")){
				System.out.println("you splitted your hand");
				return true;
			}else if(x.equals("no")){
				System.out.println("you didn't want to split your hand");
				return false;
			}
		}
		System.out.println("you don't have enough money to split your hand");
		return false;
	}
	
	public String toString(){
		return "player's name:"+this.player+"  ----hand:"+playerHand;
	}
	
	public static void main (String[] args){
		CasinoCustomer customer1=new CasinoCustomer("agni",50.0);
		Player player1=new Player(customer1);
		player1.placeBet();		
		player1.getPlayer().printState();
		player1.wantsToSplit();
		player1.getPlayer().printState();
		player1.wantsToDouble();
		player1.getPlayer().printState();
		player1.wins();
		player1.getPlayer().printState();
		player1.winsBlackjack();
		player1.getPlayer().printState();
		player1.loses();
		player1.getPlayer().printState();
	}
}
