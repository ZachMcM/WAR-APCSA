import java.util.ArrayList;

class Deck {
  private ArrayList<Card> deck =  new ArrayList<Card>();
  private ArrayList<Card> originalDeck = new ArrayList<Card>();

  //creates new deck
  public Deck() {
    for (int i = 0; i < 4; i++) {
      String suit = "";
      if (i == 0) {
        suit = "heart";
      } else if (i == 1) {
        suit = "club";
      } else if (i == 2) {
        suit = "spade";
      } else {
        suit = "diamond";
      }
      for (int j = 1; j <= 13; j++) {
        if (j == 1) {
          deck.add(new Card(suit, "ace", j));
        } else if (j <= 10) {
          deck.add(new Card(suit, j, j));
        } else if (j == 11) {
          deck.add(new Card(suit, "jack", j));
        } else if (j == 12) {
          deck.add(new Card(suit, "queen", j));
        } else if (j == 13) {
          deck.add(new Card(suit, "king", j));
        }
      }
    }
  }

  //prints out the deck in the console for debugging
  public void displayDeck() {
    for (int i = 0; i < deck.size(); i++) {
      System.out.println(deck.get(i).toString());
    }
  }

  //shuffles deck
  public void shuffle() {
    for (int i = deck.size() - 1; i > 0; i--) {
      // Pick a random index from 0 to i
      int j = (int)(Math.random() * 52);
        
      // Swap arr[i] with the element at random index
      Card temp = deck.get(i);
      deck.set(i, deck.get(j));
      deck.set(j, temp);
    }
  }
  

  //deals top card
  public Card deal() {
    return deck.remove(0);
  }
  
  //reset to original 52
  public void resetDeck(){
    deck = originalDeck;
  }
  
}  