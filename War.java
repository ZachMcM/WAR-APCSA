import java.util.ArrayList;

class War {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Card> player1 = new ArrayList<Card>();
        ArrayList<Card> player2 = new ArrayList<Card>();
        for (int i = 0; i < 26; i++) {
            player1.add(deck.deal());
            player2.add(deck.deal());
        }
        int round = 1;
        while (player1.size() > 0 && player2.size() > 0) {
            System.out.println("Round " + round);
            System.out.println("Player 1: " + player1.get(0).toString());
            System.out.println("Player 2: " + player2.get(0).toString());
            if (player1.get(0).getValue() > player2.get(0).getValue()) {
                System.out.println("Player 1 wins the round!");
                player1.add(player1.remove(0));
                player1.add(player2.remove(0));
            } else if (player1.get(0).getValue() < player2.get(0).getValue()) {
                System.out.println("Player 2 wins the round!");
                player2.add(player2.remove(0));
                player2.add(player1.remove(0));
            } else {
                System.out.println("WAR!");
                ArrayList<Card> warPile1 = new ArrayList<Card>();
                ArrayList<Card> warPile2 = new ArrayList<Card>();
                warPile1.add(player1.remove(0));
                warPile2.add(player2.remove(0));
                while (player1.get(0).getValue() == player2.get(0).getValue()) {
                    System.out.println("Player 1: " + player1.get(0).toString());
                    System.out.println("Player 2: " + player2.get(0).toString());
                    System.out.println("WAR!");
                    warPile1.add(player1.remove(0));
                    warPile2.add(player2.remove(0));
                }
                if (player1.get(0).getValue() > player2.get(0).getValue()) {
                    System.out.println("Player 1 wins the war!");
                    player1.addAll(warPile1);
                    player1.addAll(warPile2);
                    player1.add(player1.remove(0));
                    player1.add(player2.remove(0));
                } else {
                    System.out.println("Player 2 wins the war!");
                    player2.addAll(warPile1);
                    player2.addAll(warPile2);
                    player2.add(player2.remove(0));
                    player2.add(player1.remove(0));
                }
            }
            round++;
        }
        if (player1.size() == 0) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Player 1 wins!");
        }
    }
}