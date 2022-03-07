package model;

import model.objects.*;

/**
 * Class that keeps track of the current game of blackjack.
 * @author Alen
 * @version 2022-03-07
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class GameTracker implements Iterator<Hand> {
    private final List<Hand> turnOrder;
    private int turnTracker = 0;
    private Deck deck;

    public GameTracker(Player... players){
        turnOrder = new ArrayList<>();
        for (Player p: players){
            turnOrder.add(new Hand(p));
        }

        Collections.shuffle(turnOrder);

        // Dealer is always last
        turnOrder.add(new Hand(new Dealer()));

        turnOrder.get(0).toggleActive();

        deck = new Deck();

        for (Hand h: turnOrder) {
            h.addCard(deck.next());
            h.addCard(deck.next());
        }

    }

    /**
     * Checks if the game has more rounds.
     *
     * @return Check result if game has more rounds.
     */
    @Override
    public boolean hasNext() {
        return turnTracker < turnOrder.size();
    }

    /**
     * Gets the hand that is next in turnOrder
     *
     * @return next hand in turnOrder
     */
    @Override
    public Hand next() {
        if(turnTracker > 0) {
            turnOrder.get(turnTracker - 1).toggleActive();
        }
        turnOrder.get(turnTracker).toggleActive();
        return turnOrder.get(turnTracker++);

    }

    /**
     * Gets the next card from the deck
     *
     * @return the next card from deck
     */
    public Card nextCard(){
        return deck.next();
    }

    /**
     * Gets the turnorder of the game.
     *
     * @return The turn order of the game.
     */
    public List<Hand> getTurnOrder(){
        return Collections.unmodifiableList(turnOrder);
    }

    /**
     * Gets the turntracker.
     *
     * @return The turntracker of the game.
     */
    public int getTurnTracker(){ return turnTracker; }

    public void insertNext(Hand hand){
        turnOrder.add(turnTracker, hand);
    }

}
