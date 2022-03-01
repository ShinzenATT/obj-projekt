package Model;

import Model.objects.Card;
import Model.objects.Hand;
import Model.objects.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class GameTrackerTest {


    @Test
    //Testing for next player
    public void playerTest(){
        Player player1 = new Player("Player1", 100);
        Player player2 = new Player("Player2", 100);
        GameTracker testGame = new GameTracker(player1, player2);
        assertEquals(true, testGame.hasNext());
    }

    @Test
    //Testing for a next turn
    public void turnTest(){
        Player player1 = new Player("Player1", 100);
        Player player2 = new Player("Player2", 100);
        GameTracker testGame = new GameTracker(player1, player2);
        assertThat(testGame.getTurnOrder(), instanceOf(List.class));
    }


    @Test
    //Testing for next card
    public void cardTest(){
        Player player1 = new Player("Player1", 100);
        Player player2 = new Player("Player2", 100);
        GameTracker testGame = new GameTracker(player1, player2);
        assertThat(testGame.nextCard(), instanceOf(Hand.class));
    }

    //Testing for dealers hand


    //Testing for getting the correct turn order

}
