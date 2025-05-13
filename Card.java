//Agni Paila 

class Card
{
	private String numberFigure;
	private int value;
	
	public Card(String numberFigure){   
		this.numberFigure=numberFigure;
	}
	
	public Card(){
	}
	
	public int getValue(){	
		if (numberFigure=="10" || numberFigure=="J" || numberFigure=="Q" || numberFigure=="K"){
			this.value=10;
			return value;
		}else if(numberFigure=="A"){
			this.value=1;
			return value;
		}else if(numberFigure=="2"){
			this.value=2;
			return value;
		}else if(numberFigure=="3"){
			this.value=3;
			return value;
		}else if(numberFigure=="4"){
			this.value=4;
			return value;
		}else if(numberFigure=="5"){
			this.value=5;
			return value;
		}else if(numberFigure=="6"){
			this.value=6;
			return value;
		}else if(numberFigure=="7"){
			this.value=7;
			return value;
		}else if(numberFigure=="8"){
			this.value=8;
			return value;
		}else if(numberFigure=="9"){
			this.value=9;
			return value;
		}
		return(-1);
	}
	
	public boolean isAce(){
		if(numberFigure=="A"){
			return true;
		}
		return false;
	}
	
	public boolean equals(Card other){
		if(this.numberFigure.equals(other.numberFigure)){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return numberFigure;
	}
	
	/*public static void main(String[] args){
		Card c1=new Card("K");
		Card c2=new Card("5");
		Card c3=new Card("5");
		Card c4=new Card("K");
		Card c5=new Card("A");
		System.out.println(c1);
		System.out.println(c3);
		System.out.println(c1.getValue());
		System.out.println(c5.getValue());
		System.out.println(c2.isAce()+"\n"+c1.equals(c4)+"\n"+c1+" "+c2);
		System.out.println(c1.getValue()+c5.getValue());
	}*/
}
