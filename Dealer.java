//Agni Paila  

class Dealer{
	
	private River currentRiver;
	private Hand currentHand;
	
	public Dealer(River currentRiver){
		this.currentRiver=currentRiver;
		currentHand=new Hand();   
		this.currentHand=currentHand;
	}
	
	public Hand getCurrentHand(){
		return currentHand;
	}
	
	public void draw(){
		this.currentHand.addCard(currentRiver.nextCard());
	}
	
	public void deal(Player player){
		player.getPlayerHand().addCard(currentRiver.nextCard());
	}
	
	public void play(){
		while(this.currentHand.score()<17){  
			this.currentHand.addCard(currentRiver.nextCard());
		}
	}
	
	public void settle(Player player){
		if (currentHand.score()< player.getPlayerHand().score() && player.getPlayerHand().score()<=21){
			System.out.println("player "+player.getPlayer()+" wins dealer");
			player.wins();
		}else if(player.getPlayerHand().score()<currentHand.score() && currentHand.score()<=21){ 
			System.out.println("dealer wins player "+player.getPlayer());
			player.loses();
		}else if(player.getPlayerHand().score()==currentHand.score() && currentHand.score()<=21 && player.getPlayerHand().score()<=21){
			System.out.println(player.getPlayer()+" tie with dealer! Nobody wins");
		}else if(currentHand.isBust()){
			if(!player.getPlayerHand().isBust()){
				System.out.println("dealer's hand is a bust, so player "+player.getPlayer()+" wins"); 
				player.wins();
			}else{
				System.out.println("dealer's hand is a bust, and player's "+player.getPlayer()+" hand too, nobody wins");
			}
		}
	}
	
	public String toString(){
		return "Dealer:"+currentHand;
	}
	
	public static void main(String[] args){
		River river1=new River(1);
		Dealer dealer1=new Dealer(river1);
		dealer1.play();
		System.out.println(dealer1);
		Player player1=new Player(new CasinoCustomer("agni",100.0));
		dealer1.deal(player1);
		dealer1.deal(player1);
		System.out.println(player1);
		dealer1.settle(player1);		
	}
}
