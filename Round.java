//Agni Paila   AM:4753

import java.util.ArrayList;
import java.util.Scanner;

class Round{
	
	private Dealer dealer;
	private ArrayList <Player> roundPlayers=new ArrayList <Player>();
	private ArrayList <Player> playersToSettle=new ArrayList <Player>();

	public Round(River river){
		Dealer dealer=new Dealer(river);
		this.dealer=dealer;
		this.roundPlayers=roundPlayers;
		this.playersToSettle=playersToSettle;
	}
	
	public void addPlayer(CasinoCustomer customer){
		this.roundPlayers.add(new Player(customer));
	}
	
	public void playRound(){
		for(int i=0; i<roundPlayers.size(); i++){   //oloi oi paiktes pontaroun
			roundPlayers.get(i).placeBet();
		}
		for(int j=0; j<roundPlayers.size(); j++){   //o dealer moirazei se olous ena xarti
			this.dealer.deal(roundPlayers.get(j));
		}
		dealer.draw();   //trabaei xarti k o dealer
		System.out.println(dealer);   //to typwnei
		for(int k=0; k<roundPlayers.size(); k++){  //janamoirazei se olous
			dealer.deal(roundPlayers.get(k));
		}
		dealer.draw();   //janatrabaei
		//System.out.println(dealer);
		for(int l=0; l<roundPlayers.size(); l++){   //typwnw ta xeria twn paiktwn
			System.out.println(roundPlayers.get(l));
		}
		if(dealer.getCurrentHand().isBlackjack()){  
			for(int m=0; m<roundPlayers.size(); m++){
				if(!roundPlayers.get(m).getPlayerHand().isBlackjack()){
					roundPlayers.get(m).loses();
					System.out.println("Round ends");
				}
			}
		}else{
			for(int n=0; n<roundPlayers.size(); n++){
				if(roundPlayers.get(n).getPlayerHand().isBlackjack()){
					roundPlayers.get(n).winsBlackjack();
				}else{
					playPlayer(n);
				}
			}
			dealer.play();
			System.out.println(dealer);
			for(int i=0; i<playersToSettle.size();i++){
				dealer.settle(playersToSettle.get(i));
				//System.out.println("player "+(i+1)+" to settle: "+playersToSettle.get(0));
			}
		}
	}
	
	private void playNormalHand(int n){
		Scanner input=new Scanner(System.in);
		System.out.println("do you want to hit? yes or no");
		String x =input.next();
		while(x.equals("yes")){
			dealer.deal(roundPlayers.get(n));
			System.out.println(roundPlayers.get(n));
			System.out.println("do you want to hit? yes or no");
			x =input.next();
		}
		if(roundPlayers.get(n).getPlayerHand().isBust()){
			roundPlayers.get(n).loses();
		}else{
			playersToSettle.add(roundPlayers.get(n));
		}
	}
	
	private void playDoubleHand(int n){
		roundPlayers.get(n).doubleBet();
		dealer.deal(roundPlayers.get(n));
		System.out.println(roundPlayers.get(n));
		if(!roundPlayers.get(n).getPlayerHand().isBust()){
			playersToSettle.add(roundPlayers.get(n));
		}else{
			roundPlayers.get(n).loses();
		}
	}
	
	private void playSplitHand(int n){
		roundPlayers.get(n).doubleBet();
		roundPlayers.get(n).getPlayerHand().split();
		//Hand[] splitArray=new Hand[2];
		//splitArray=roundPlayers.get(n).getPlayerHand().split();
		System.out.println("1st hand");
		Player playerSplit1=new Player(new CasinoCustomer(roundPlayers.get(n).getPlayer().toString(),roundPlayers.get(n).getBet()),roundPlayers.get(n).getPlayerHand().getArrayOfTwoHands()[0],roundPlayers.get(n).getBet()/2);
		playNormalHand(n);
		if(!playerSplit1.getPlayerHand().isBust()){
			playersToSettle.add(playerSplit1);
		}else{
			playerSplit1.loses();
		}
		System.out.println("2nd hand");
		Player playerSplit2=new Player(new CasinoCustomer(roundPlayers.get(n).getPlayer().toString(),roundPlayers.get(n).getBet()),roundPlayers.get(n).getPlayerHand().getArrayOfTwoHands()[1],roundPlayers.get(n).getBet()/2);
		playNormalHand(n);
		if(!playerSplit2.getPlayerHand().isBust()){
			playersToSettle.add(playerSplit2);
		}else{
			playerSplit2.loses();
		}
	}
	
	private void playPlayer(int n){
		if(roundPlayers.get(n).getPlayerHand().canSplit()){
			if(roundPlayers.get(n).wantsToSplit()){
				playSplitHand(n);
				return;
			}
		}else if(roundPlayers.get(n).wantsToDouble()){
			playDoubleHand(n);
			return;
		}else{
			playNormalHand(n);
		}
	}
	
	public static void main(String[] args){
		River river1=new River(6);
		Round round1=new Round(river1);
		CasinoCustomer customer1=new CasinoCustomer("agni",100.0);
		round1.addPlayer(customer1);
		round1.playRound();
	}
}