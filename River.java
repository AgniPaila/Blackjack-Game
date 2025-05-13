//Agni Paila  

import java.util.Random;

class River{
	
	private Card[] arrayCards;  //krataei ola ta xartia apo tis trapoules
	private int cardsLeft;  //posa xartia exoun meinei sto reuma
	private int numberOfCards;  //arithmos twn xartiwn arxika

	public River(int packOfCards){   //packOfCards=arithmos apo trapoules pou exei to reuma 
		this.numberOfCards=packOfCards*52;
		this.cardsLeft=packOfCards*52;
		String[] array={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		arrayCards=new Card[array.length*4*packOfCards];
		for(int i=0; i<this.arrayCards.length; i++){
			this.arrayCards[i]=new Card(array[i%13]);
		}
	}
	
	public Card nextCard(){
		if(this.cardsLeft==0){
			return null;
		}else{
			Random random = new Random();
			int randomValue=random.nextInt(cardsLeft);  
			Card temp=arrayCards[randomValue];
			arrayCards[randomValue]=arrayCards[cardsLeft-1];
			arrayCards[cardsLeft-1]=temp;
			cardsLeft=cardsLeft-1;
			return temp;     
		}  
	}
	
	public boolean shouldRestart(){
		if(cardsLeft<(numberOfCards/4)){       
			return true;
		}
		return false;
	}
	
	public void restart(){
		this.cardsLeft=this.numberOfCards;
	}
	
	public int getCardsLeft(){
		return this.cardsLeft;
	}
	
	/*public int getNumberOfCards(){
		return this.numberOfCards;
	}
	
	public String toString(){
		String x="";
		for(int i=0; i<numberOfCards; i++){
			x+=i+" "+ arrayCards[i]+"\n";
		}
		return x;
	}*/
	
	
	public static void main (String[] args){
		River myRiver=new River(1);
		//System.out.println(myRiver);
		while(!myRiver.shouldRestart()){
			System.out.println(myRiver.nextCard());  
		}
		myRiver.restart();
		System.out.println("-----");
		while(myRiver.getCardsLeft()!=0){
			System.out.println(myRiver.nextCard());  
		}
	}
}
