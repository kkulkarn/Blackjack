import java.io.IOException;

public class PlayBlackjack{
    
       public static void main(String[] args) throws IOException {
          
          System.out.println("Welcome to the game of blackjack.");
          System.out.println();
          
          @SuppressWarnings("unused")
		boolean endResult ;
          int chips = 100;
          while (true) {
              System.out.println("You have " + chips + " chips.");
              int bet;
			do {
                 System.out.println("How many chips do you want to bet?  (Enter 0 to end.)");
                 TextIO.put("? ");
                 bet = System.in.read();
                 if (bet < 0 || bet > chips)
                     System.out.println("Your bet must be between 0 and " + chips + '.');
              } while (bet < 0 || bet > chips);
              if (bet == 0)
                 break;
              endResult = playBlackjack();
              if (endResult)
                  chips = chips + bet;
               else
                  chips = chips - bet;
               System.out.println();
               if (chips == 0) {
                  System.out.println("Looks like you've are out of chips!");
                  break;
               }
           }
           
           System.out.println();
           System.out.println("You leave with " + chips + " chips. ");
        
        }               
       
          
       
       static boolean playBlackjack() throws IOException {
             // Let the user play one game of Blackjack.
             // Return true if the user wins, false if the user loses.
    
          Card deck = new Card();                  // Init deck of cards
          BlackjackHand dealerHand = new BlackjackHand();   // Randomized drawing for dealer
          BlackjackHand userHand = new BlackjackHand();     // Randomized drawing for user
          
          /*  Shuffle the deck, then deal two cards to each player. */
          
          deck.shuffle();
          dealerHand.addCard( deck.dealCard() );
          dealerHand.addCard( deck.dealCard() );
          userHand.addCard( deck.dealCard() );
          userHand.addCard( deck.dealCard() );
          
          System.out.println();
          

          // If the dealer gets a Blackjack
          if (dealerHand.getBlackjackValue() == 21) {
               System.out.println("Dealer has the " + dealerHand.getCard(0)
                                       + " and the " + dealerHand.getCard(1) + ".");
               System.out.println("User has the " + userHand.getCard(0)
                                         + " and the " + userHand.getCard(1) + ".");
               System.out.println();
               System.out.println("Dealer has Blackjack.  Dealer wins.");
               return false;
          }
          // If the player gets a BlackJack
          if (userHand.getBlackjackValue() == 21) {
               System.out.println("Dealer has the " + dealerHand.getCard(0)
                                       + " and the " + dealerHand.getCard(1) + ".");
               System.out.println("User has the " + userHand.getCard(0)
                                         + " and the " + userHand.getCard(1) + ".");
               System.out.println();
               System.out.println("You have Blackjack.  You win.");
               return true;
          }

          while (true) {
              
               System.out.println();
               System.out.println("Your cards are:");
               for ( int i = 0; i < userHand.getCardCount(); i++ )
                  System.out.println("    " + userHand.getCard(i));
               System.out.println("Your total is " + userHand.getBlackjackValue());
               System.out.println();
               System.out.println("Dealer is showing the " + dealerHand.getCard(0));
               System.out.println();
               TextIO.put("Hit (H/h) or Stand (S/s)? ... Q/q to Quit");
               char userAction;  // User's response, 'H' or 'S'.
               do {
            	   userAction = ((char) System.in.read()).toUpperCase();
            	   userAction = userAction.toUpperCase();
                  if (userAction != 'H' && userAction != 'S' && userAction != 'Q')
                     TextIO.put("Please respond H or S:  ");
               } while (userAction != 'H' && userAction != 'S' && userAction != 'Q');
    
               // If the user Hits, draw a card, else user Stands, start dealers draws
    
               if ( userAction == 'S' ) { // Stand option
                   break;
               }
               else if (userAction == 'Q') // Quit option
               {
                   System.out.println("Thanks for playing..");
            	   System.exit(0);
               }
               else {  // H option & the whole 9 yards
                   Card newCard = deck.dealCard();
                   userHand.addCard(newCard);
                   System.out.println();
                   System.out.println("User hits.");
                   System.out.println("New card is the " + newCard);
                   System.out.println("Total :: " + userHand.getBlackjackValue());
                   if (userHand.getBlackjackValue() > 21) {
                       System.out.println();
                       System.out.println("Oops busted, try again !!!");
                       System.out.println("Dealer's other card was :: " 
                                                          + dealerHand.getCard(1));
                       return false;  
                   }
               }
               
          } 
    
          System.out.println();
          System.out.println("User stands.");
          System.out.println("Dealer's cards are");
          System.out.println("    " + dealerHand.getCard(0));
          System.out.println("    " + dealerHand.getCard(1));
          // Logic for user stands & the dealer draws cards
          while (dealerHand.getBlackjackValue() <= 16) {
             Card newCard = deck.dealCard();
             System.out.println("Dealer hits and gets the " + newCard);
             dealerHand.addCard(newCard);
             if (dealerHand.getBlackjackValue() > 21) {
                System.out.println();
                System.out.println("Dealer busted ");
                return true;
             }
          }
          System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());
          
          /* To determine who wins based on both not gone bust */
          
          System.out.println();
          if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
             System.out.println("Dealer wins on a tie.  You lose.");
             return false;
          }
          else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
             System.out.println("Dealer wins, " + dealerHand.getBlackjackValue() 
                              + " points to " + userHand.getBlackjackValue() + ".");
             return false;
          }
          else {
             System.out.println("You win, " + userHand.getBlackjackValue() 
                              + " points to " + dealerHand.getBlackjackValue() + ".");
             return true;
          }
    
       }  
    
    
    } // end 
