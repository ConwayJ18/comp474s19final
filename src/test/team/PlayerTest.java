package test.team;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.team.CardImpl;
import com.scorekeeper.model.team.Player;
import com.scorekeeper.model.team.PlayerImpl;

class PlayerTest {
	
	
	@Test
	void getterTests()
	{
		Player testPlayer = new PlayerImpl("Conway", 83, true);
		assertEquals(testPlayer.getName(), "Conway");
		assertEquals(testPlayer.getNumber(), 83);
		assertEquals(testPlayer.inPlay(), true);
		assertEquals(testPlayer.inPenaltyBox(), false);
		assertEquals(testPlayer.getPlayTime(), "0:0:0");
		assertEquals(testPlayer.getPenaltyTime(), "0:0:0");
		assertEquals(testPlayer.getPlusMinus(), 0);
		assertEquals(testPlayer.getBlueCards(), 0);
		assertEquals(testPlayer.getYellowCards(), 0);
		assertEquals(testPlayer.getRedCards(), 0);
	}
	
	@Test
	void setterTests()
	{
		Player testPlayer = new PlayerImpl("", 0, false);
		testPlayer.setName("Conway");
		assertEquals(testPlayer.getName(), "Conway");
		testPlayer.setNumber(83);
		assertEquals(testPlayer.getNumber(), 83);
		testPlayer.setNumber(109); //Fails
		assertEquals(testPlayer.getNumber(), 83);
		testPlayer.putInPlay();
		assertEquals(testPlayer.inPlay(), true);
		testPlayer.removeFromPlay();
		assertEquals(testPlayer.inPlay(), false);
		testPlayer.sendToPenaltyBox();
		assertEquals(testPlayer.inPenaltyBox(), true);
		testPlayer.releaseFromPenaltyBox();
		assertEquals(testPlayer.inPenaltyBox(), false);
		testPlayer.incrementPlayTime();
		assertEquals(testPlayer.getPlayTime(), "0:0:1");
		testPlayer.incrementPenaltyTime();
		assertEquals(testPlayer.getPenaltyTime(), "0:0:1");
		testPlayer.incrementPlusMinus();
		assertEquals(testPlayer.getPlusMinus(), 10);	
		testPlayer.decrementPlusMinus();
		assertEquals(testPlayer.getPlusMinus(), 0);
		testPlayer.addCard(new CardImpl(1, "00:00:10"));
		assertEquals(testPlayer.getBlueCards(), 1);	
		testPlayer.addCard(new CardImpl(2, "00:00:20"));
		assertEquals(testPlayer.getYellowCards(), 1);
		testPlayer.addCard(new CardImpl(3, "00:00:30"));
		assertEquals(testPlayer.getYellowCards(), 2);
		assertEquals(testPlayer.getRedCards(), 1);
		testPlayer.addCard(new CardImpl(4, "00:00:40"));
		assertEquals(testPlayer.getRedCards(), 2);
	}
}
