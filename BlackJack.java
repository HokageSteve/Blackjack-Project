import java.util.ArrayList;

public class BlackJack {

    public static void main(String [] strArgs) {
        BlackJack objGame = new BlackJack();
        objGame.playRound();
    }

    public Player dealerLogic(Player objDealer, Deck objDeck) {
        return dealerLogic(objDealer, objDeck, 16);
    }

    public Player dealerLogic(Player objDealer, Deck objDeck, int intStop) {
        while(objDealer.getTotalFaceValue() <= intStop &&
            objDealer.getNumberOfCards() < 4) {
            objDealer.addCard(objDeck.getCard());        
        }
        return objDealer;
    }

    public void playRound() {
       int b1, b2, d1 = 0;
        Deck objDeck = new Deck();
        objDeck.shuffle();

        ArrayList<Player> aryPlayers = new ArrayList<Player>();
        aryPlayers.add(new Player());
        aryPlayers.add(new Player());
        b1 = aryPlayers.get(0).getMoney();
        b2 = aryPlayers.get(1).getMoney();
        aryPlayers.get(0).setMoney(b1);
        aryPlayers.get(1).setMoney(b2);
        Player objDealer = new Player("Dealer");
        
        objDealer.setMoney(objDealer.getMoney());
        aryPlayers.add(objDealer);

        while(b1 != 0 || b2 != 0){
       
        int intCurrentPlayer = 0;
        int intCounter = 0;
        
        while(intCounter < 2) {
            intCurrentPlayer = 0;
            while(intCurrentPlayer < aryPlayers.size()) {
                aryPlayers.get(intCurrentPlayer).addCard(objDeck.getCard());
                intCurrentPlayer++;
               
            }
            intCounter++;
        }

        intCurrentPlayer = 0;
        while(intCurrentPlayer < aryPlayers.size()) {
            if(aryPlayers.get(intCurrentPlayer).hasMoney()) {
                aryPlayers.get(intCurrentPlayer).inputBet();    
            }
            intCurrentPlayer++;
}

        this.dealerLogic(objDealer, objDeck);
         int player1 = aryPlayers.get(0).getTotalFaceValue();
        int player2 = aryPlayers.get(1).getTotalFaceValue();
        int dealer = objDealer.getTotalFaceValue();
        int f1 = 0,f2 = 0;
        
        if(player1 > player2 && player1 > dealer){
        	System.out.println("\nPlayer 1 wins the round\n");
        	f1 = 1;
        }else if(player2 > player1 && player2 > dealer){
        	System.out.println("\nPlayer 2 wins the round\n");
        	f2 = 2;
        }else if(dealer > player1 && dealer > player2){
        	System.out.println("\nDealer wins the round\n");
        }else if(dealer == player1){
        	System.out.println("\nPlayer 1 and dealer have tied\n");
        }else if(dealer == player2){
        	System.out.println("\nPlayer 2 and dealer have tied\n");
        }else if(player1 == player2){
        	System.out.println("\nPlayer 1 and Player2 have tied\n");
        }
        
        if(f1 == 1){
        	b1 = aryPlayers.get(0).getMoney() + aryPlayers.get(1).getBet();
        	d1 = objDealer.getMoney() - aryPlayers.get(0).getBet()
       			 + aryPlayers.get(1).getBet();
        }else if(f2 == 2){
        	b2 = aryPlayers.get(0).getMoney() + aryPlayers.get(0).getBet();
        	d1 = objDealer.getMoney() + aryPlayers.get(0).getBet()
       			 - aryPlayers.get(1).getBet();
        }else{
        	 b1 = aryPlayers.get(0).getMoney() - aryPlayers.get(0).getBet();
        	 b2 = aryPlayers.get(1).getMoney() - aryPlayers.get(1).getBet();
        	 d1 = objDealer.getMoney() + aryPlayers.get(0).getBet()
        			 + aryPlayers.get(1).getBet();
}

        System.out.println(aryPlayers);

        if(objDeck.shouldShuffle()) {
            objDeck.shuffle();

          if(b1 == 5000){
        	System.out.println("\nPlayer 1 has the money. End to this round");
        	break;
        }else if(b2 == 5000){
        	System.out.println("\nPlayer 2 has the money. End to this round");
        	break;
        }else  if(d1 == 5000){
        	System.out.println("\nDealer has all money. End to this round");
        	break;
        }
        
        if(b1 == 0 && b2 == 0){
        	System.out.println("\nPlayer 1 and Player 2 have no money. End to this round");
        	break;
        }else if(b1 == 0){
        	System.out.println("\nPlayer 1 has no money. End to this round");
        	break;
        }else if(b2 == 0){
        	System.out.println("\nPlayer 2 has no money. End to this round");
        	break; 
    }
}