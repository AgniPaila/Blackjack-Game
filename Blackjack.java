//Agni Paila 

import java.util.Scanner;

class Blackjack{
	
	public static void main (String[] args){
		Scanner input =new Scanner(System.in);
		System.out.println("How many players you want to add?");
		int players=input.nextInt();
		BlackjackTable blackjackTable=new BlackjackTable(players);
		blackjackTable.play();	
	}
}
