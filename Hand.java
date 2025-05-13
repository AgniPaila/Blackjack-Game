//Agni Paila   

import java.util.ArrayList;
class Hand{
	
	private ArrayList <Card> myHandList=new ArrayList <Card>();
	private int sumOfHandValues;
	private Hand[] arrayOfTwoHands;
	
	public Hand(){
	}
	
	public Hand[] getArrayOfTwoHands(){
		return arrayOfTwoHands;
	}
	
	public void addCard(Card card){
		this.myHandList.add(card);
		sumOfHandValues+=card.getValue();
	}

	public int score(){
		for(int i=0; i<myHandList.size(); i++){
			if(myHandList.get(i).toString()=="A" && sumOfHandValues+10<=21){
				sumOfHandValues=sumOfHandValues+10;
			}
		}
		return sumOfHandValues;
	}

	public boolean canSplit(){
		if(myHandList.get(0).equals(myHandList.get(1))){
			return true;	
		}
		return false;
	}

	public Hand[] split(){
		arrayOfTwoHands=new Hand[2];
		Hand hand1=new Hand();
		Hand hand2=new Hand();
		hand1.addCard(myHandList.get(0));
		hand2.addCard(myHandList.get(1));
		arrayOfTwoHands[0]=hand1;
		arrayOfTwoHands[1]=hand2;
		return arrayOfTwoHands;
	}

	public boolean isBlackjack(){
		if(myHandList.size()==2 && sumOfHandValues==21){
			return true;
		}
		return false;
	}

	public boolean isBust(){
		if(sumOfHandValues>21){
			return true;
		}
		return false;
	}
	
	public String toString(){
		String s="";
		for(int i=0; i<myHandList.size(); i++){
			s+= myHandList.get(i)+"  ";
		}
		return s;
	}
	
	public static void main(String[] args){
		Hand myHand=new Hand();
		myHand.addCard(new Card("A"));
		myHand.addCard(new Card("A"));
		System.out.println(myHand);
		System.out.println(myHand.score());
		System.out.println(myHand.canSplit());
		Hand[] splitArray=new Hand[2];
		splitArray=myHand.split();
		System.out.println(splitArray[0]);
		System.out.println(splitArray[1]);
		splitArray[0].addCard(new Card("K"));
		System.out.println(splitArray[0]);
		System.out.println(splitArray[0].score());
		System.out.println(splitArray[0].isBlackjack());
		splitArray[0].addCard(new Card("A"));
		System.out.println(splitArray[0]);
		System.out.println(splitArray[0].score());
		splitArray[0].addCard(new Card("10"));
		System.out.println(splitArray[0]);
		System.out.println(splitArray[0].score());
		System.out.println(splitArray[0].isBust());
	}
}	
