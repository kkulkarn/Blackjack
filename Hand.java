

import java.util.Vector;

public class Hand {

   private Vector<Card> hand;   // The cards in the hand.
   
   public Hand() {
           // Create a Hand object that is initially empty.
      hand = new Vector<Card>();
   }
   
   public void clear() {
         // Discard all the cards from the hand.
      hand.removeAllElements();
   }
   
   public void addCard(Card c) {
         
      if (c != null)
         hand.addElement(c);
   }
   
   public void removeCard(Card c) {
         // If the specified card is in the hand, it is removed.
      hand.removeElement(c);
   }
   
   public void removeCard(int position) {
         // If the specified position is a valid position in the hand,
         // then the card in that position is removed.
      if (position >= 0 && position < hand.size())
         hand.removeElementAt(position);
   }
   
   public int getCardCount() {
         // Return the number of cards in the hand.
      return hand.size();
   }
   
   public Card getCard(int position) {
          // Get the card from the hand in given position, where positions
          // are numbered starting from 0.  If the specified position is
          // not the position number of a card in the hand, then null
          // is returned.
      if (position >= 0 && position < hand.size())
         return (Card)hand.elementAt(position);
      else
         return null;
   }
   
   public void sortBySuit() {
         
      Vector newHand = new Vector();
      while (hand.size() > 0) {
         int pos = 0;  // Position of minimal card.
         Card c = (Card)hand.elementAt(0);  
         for (int i = 1; i < hand.size(); i++) {
            Card c1 = (Card)hand.elementAt(i);
            if ( c1.getSuit() < c.getSuit() ||
                    (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
                pos = i;
                c = c1;
            }
         }
         hand.removeElementAt(pos);
         newHand.addElement(c);
      }
      hand = newHand;
   }
   
   @SuppressWarnings("unchecked")
public void sortByValue() {

      @SuppressWarnings("rawtypes")
	Vector newHand = new Vector();
      while (hand.size() > 0) {
         int pos = 0;  // Position of minimal card.
         Card c = (Card)hand.elementAt(0);  
         for (int i = 1; i < hand.size(); i++) {
            Card c1 = (Card)hand.elementAt(i);
            if ( c1.getValue() < c.getValue() ||
                    (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
                pos = i;
                c = c1;
            }
         }
         hand.removeElementAt(pos);
         newHand.addElement(c);
      }
      hand = newHand;
   }
   
}
