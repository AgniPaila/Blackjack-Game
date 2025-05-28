# 🃏 Blackjack Game (21)
## 📌 Description
A console-based implementation of the popular casino card game Blackjack (also known as 21) written in Java.

## 📝 Game Rules
- Get a hand value as close to 21 as possible without going over, and higher than the dealer's total.
- All the rules of the game can be found here: https://bicyclecards.com/how-to-play/blackjack/
  
### 🃏 Card Values
- Number cards (2–10): Numerical value.
- Face cards (J, Q, K): 10 points.
- Ace (A or 1): Counts as **1 or 11**, whichever benefits the player most.

### 💰 Betting
- Players place a **bet** at the start of each round.
- Payouts:
  - **Blackjack (21 with 2 cards)** pays **1.5×** the bet.
  - Winning normally pays **1×** the bet.
  - A tie returns the original bet.

### 🎲 Dealing
- Dealer deals **one face-up card** to each player and to themselves.
- Then, **a second card** is dealt to each:
  - **Players** receive a second face-up card.
  - **Dealer** receives a second card **face-down**.

### 🔍 Blackjack Check
- Dealer checks for **blackjack** after initial deal:
  - If **dealer has blackjack**, all players lose **unless** they also have blackjack (in which case it's a tie).
  - If a **player has blackjack** and the dealer does not, the player wins **1.5×** their bet.

### 🧍 Player Actions
- **Split**: If dealt two cards of the same rank, player can split into two hands.
- **Double Down**: Player doubles their bet, receives **one more card**, then must stand.
- **Hit**: Take an additional card.
- **Stand**: Stop taking cards and keep current hand.
- **Bust**: If hand exceeds 21, the player **automatically loses**.

### 🧑‍⚖️ Dealer's Turn
- Dealer reveals face-down card.
- Dealer must draw cards until their total is **17 or more**.
- If dealer busts (goes over 21), all remaining players win.

### 🏆 Round Results
- Player wins if:
  - They have **higher total than dealer** (and ≤21), or
  - Dealer **busts**.
- Player loses if:
  - They **bust**, or
  - Dealer has a **higher total** (and ≤21).
- Tie if:
  - Both player and dealer have the **same total**.

## 🛠️ How to Run
Compile the Java files:
javac *.java

Run the main method in Round (or test individual components):
java Round

## 🔁 Dependencies
No external libraries required

## 📘 Course Info
Course: Τεχνικές Αντικειμενοστρεφούς Προγραμματισμού (Object Oriented Programming Techniques - 1st year)
