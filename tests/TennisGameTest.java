import static org.junit.Assert.*;
import org.junit.Test;

public class TennisGameTest {

    @Test
    public void testInitialScore() {
        TennisGame game = new TennisGame();
        assertEquals("Initial score should be 'love - love'", "love - love", game.getScore());
    }

    @Test
    public void testPlayer1ScoresOnce() throws TennisGameException {
        TennisGame game = new TennisGame();
        game.player1Scored();
        assertEquals("Score should be '15 - love' after Player 1 scores once", "love - 15", game.getScore());
    }

    @Test
    public void testPlayer2ScoresOnce() throws TennisGameException {
        TennisGame game = new TennisGame();
        game.player2Scored();
        assertEquals("Score should be 'love - 15' after Player 2 scores once", "15 - love", game.getScore());
    }

    @Test
    public void testPlayersTieAt15() throws TennisGameException {
        TennisGame game = new TennisGame();
        game.player1Scored();
        game.player2Scored();
        assertEquals("Score should be '15 - 15'", "15 - 15", game.getScore());
    }

    @Test
    public void testPlayersTieAt30() throws TennisGameException {
        TennisGame game = new TennisGame();
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        assertEquals("Score should be '30 - 30'", "30 - 30", game.getScore());
    }

    @Test
    public void testDeuceCondition() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 3; i++) {
            game.player1Scored();
            game.player2Scored();
        }
        assertEquals("Score should be 'deuce' when both players have 3 points and are tied", "deuce", game.getScore());
    }

    @Test
    public void testPlayer1Advantage() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 3; i++) {
            game.player1Scored();
            game.player2Scored();
        }
        game.player1Scored();
        assertEquals("Score should be 'player1 has advantage'", "player1 has advantage", game.getScore());
    }

    @Test
    public void testPlayer2Advantage() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 3; i++) {
            game.player1Scored();
            game.player2Scored();
        }
        game.player2Scored();
        assertEquals("Score should be 'player2 has advantage'", "player2 has advantage", game.getScore());
    }

    @Test
    public void testPlayer1Wins() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 4; i++) {
            game.player1Scored();
        }
        assertEquals("Score should be 'player1 wins'", "player1 wins", game.getScore());
    }

    @Test
    public void testPlayer2Wins() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 4; i++) {
            game.player2Scored();
        }
        assertEquals("Score should be 'player2 wins'", "player2 wins", game.getScore());
    }

    @Test(expected = TennisGameException.class)
    public void testPlayer1ScoresAfterGameEnded() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 4; i++) {
            game.player1Scored();
        }
        game.player1Scored(); // Should throw an exception
    }

    @Test(expected = TennisGameException.class)
    public void testPlayer2ScoresAfterGameEnded() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 4; i++) {
            game.player2Scored();
        }
        game.player2Scored(); // Should throw an exception
    }

    @Test
    public void testPlayer1Reaches40() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 3; i++) {
            game.player1Scored();
        }
        assertEquals("Score should be '40 - love'", "love - 40", game.getScore());
    }

    @Test
    public void testPlayer2Reaches40() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 3; i++) {
            game.player2Scored();
        }
        assertEquals("Score should be 'love - 40'", "40 - love", game.getScore());
    }

    @Test
    public void testPlayer1WinsAfterAdvantage() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 3; i++) {
            game.player1Scored();
            game.player2Scored();
        }
        game.player1Scored();
        game.player1Scored(); // Wins after advantage
        assertEquals("Score should be 'player1 wins'", "player1 wins", game.getScore());
    }

    @Test
    public void testPlayer2WinsAfterAdvantage() throws TennisGameException {
        TennisGame game = new TennisGame();
        for (int i = 0; i < 3; i++) {
            game.player1Scored();
            game.player2Scored();
        }
        game.player2Scored();
        game.player2Scored(); // Wins after advantage
        assertEquals("Score should be 'player2 wins'", "player2 wins", game.getScore());
    }
}
