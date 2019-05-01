package test.team;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.team.Card;
import com.scorekeeper.model.team.CardImpl;

class CardTest
{	
	@Test
	void getterTests()
	{
		Card cardBlue = new CardImpl(1, "00:00:00");
		Card cardYellow = new CardImpl(2, "01:11:11");
		Card cardSecondYellow = new CardImpl(3, "05:05:42");
		Card cardRed = new CardImpl(4, "94:23:15");
		
		assertEquals(cardBlue.getCardType(), 1);
		assertEquals(cardBlue.getCardColor(), "Blue");
		assertEquals(cardBlue.getCardTime(), "00:00:00");
		
		assertEquals(cardYellow.getCardType(), 2);
		assertEquals(cardYellow.getCardColor(), "Yellow");
		assertEquals(cardYellow.getCardTime(), "01:11:11");
		
		assertEquals(cardSecondYellow.getCardType(), 3);
		assertEquals(cardSecondYellow.getCardColor(), "Second Yellow");
		assertEquals(cardSecondYellow.getCardTime(), "05:05:42");
		
		assertEquals(cardRed.getCardType(), 4);
		assertEquals(cardRed.getCardColor(), "Red");
		assertEquals(cardRed.getCardTime(), "94:23:15");
	}
	
	@Test
	void setterTests()
	{
		Card testCard = new CardImpl(1, "00:00:00");
		testCard.setCardType(2);
		assertEquals(testCard.getCardType(), 2);
		testCard.setCardType(3);
		assertEquals(testCard.getCardType(), 3);
		testCard.setCardType(4);
		assertEquals(testCard.getCardType(), 4);
		testCard.setCardType(1);
		assertEquals(testCard.getCardType(), 1);
		testCard.setCardType(5); //Fails
		assertEquals(testCard.getCardType(), 1);
		
		testCard.setCardColor("Yellow");
		assertEquals(testCard.getCardType(), 2);
		testCard.setCardColor("Second Yellow");
		assertEquals(testCard.getCardType(), 3);
		testCard.setCardColor("Red");
		assertEquals(testCard.getCardType(), 4);
		testCard.setCardColor("Blue");
		assertEquals(testCard.getCardType(), 1);
		testCard.setCardColor("Orange"); //Fails
		assertEquals(testCard.getCardType(), 1);
		
		testCard.setCardTime("00:00:01");
		assertEquals(testCard.getCardTime(), "00:00:01");
		testCard.setCardTime("00:10:01");
		assertEquals(testCard.getCardTime(), "00:10:01");
		testCard.setCardTime("00:10:61"); //Fails
		assertEquals(testCard.getCardTime(), "00:10:01");
		testCard.setCardTime("10:61:01"); //Fails
		assertEquals(testCard.getCardTime(), "00:10:01");
		testCard.setCardTime("109:10:01"); //Fails
		assertEquals(testCard.getCardTime(), "00:10:01");
		testCard.setCardTime("10:10:01");
		assertEquals(testCard.getCardTime(), "10:10:01");
	}
}
