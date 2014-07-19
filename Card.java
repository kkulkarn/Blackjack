

public class Card {
	
    private Card[] deck;   // An array of 52 Cards, representing the deck.
    private int cardsUsed; // How many cards have been dealt from the deck.

    public final static int SPADES = 0,       
                            HEARTS = 1,
                            DIAMONDS = 2,
                            CLUBS = 3;
                            
    public final static int ACE = 1,          
                            JACK = 11,        
                            QUEEN = 12,       
                            KING = 13;
                            
    private final int suit;   
                              
    private final int value;  
                             
    public Card(int theValue, int theSuit) {
        value = theValue;
        suit = theSuit;
   
    }
        
    public Card() {
		// TODO Auto-generated constructor stub
        deck = new Card[52];
        // this loop will give an option to player to select the # of decks he wants to play with..
/*        // deckCount = x; 
        // for (int i = 0; i <= x; i++)
        {
            suit = 0;
            value = 1;
            int cardCt = 0; // How many cards have been created so far.
            for ( int suit = 0; suit <= 3; suit++ ) {
               for ( int value = 1; value <= 13; value++ ) {
                  deck[cardCt] = new Card(value,suit);
                  cardCt++;
               }
            }
            cardsUsed = 0;  
        }*/
        suit = 0;
        value = 1;
        int cardCt = 0; // How many cards have been created so far.
        for ( int suit = 0; suit <= 3; suit++ ) {
           for ( int value = 1; value <= 13; value++ ) {
              deck[cardCt] = new Card(value,suit);
              cardCt++;
           }
        }
        cardsUsed = 0;     
	}

	public int getSuit() {
        return suit;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getSuitAsString() {
        switch ( suit ) {
           case SPADES:   return "Spades";
           case HEARTS:   return "Hearts";
           case DIAMONDS: return "Diamonds";
           case CLUBS:    return "Clubs";
           default:       return "??";
        }
    }
    
    public String getValueAsString() {
        switch ( value ) {
           case 1:   return "Ace";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Jack";
           case 12:  return "Queen";
           case 13:  return "King";
           default:  return "Something errored";
        }
    }
    
    public String toString() {
        return getValueAsString() + "  " + getSuitAsString().toUpperCase();
    	//return Integer.toString(suit) + Integer.toString(value);
    }
    
 
 public void shuffle() {
     for ( int i = 51; i > 0; i-- ) {
         int rand = (int)(Math.random()*(i+1));
         Card temp = deck[i];
         deck[i] = deck[rand];
         deck[rand] = temp;
     }
     cardsUsed = 0;
 }
 
 public int cardsLeft() {
     return 52 - cardsUsed;
 }
 
 public Card dealCard() {
       // Deals one card from the deck and returns it.
     if (cardsUsed == 52)
        shuffle();
     cardsUsed++;
     return deck[cardsUsed - 1];
 }    


} // end 
