import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTestClass {

	@Test
	public void shouldAcceptCorrectPokerHands() {
		PokerHandEngine engine = new PokerHandEngine();

		boolean valid = engine.isValidHand("2D 9C AS AH AC");

		assertEquals(true, valid);
	}

	@Test
	public void shouldNotAcceptWrongPokerHands() throws Exception {
		PokerHandEngine engine = new PokerHandEngine();

		boolean valid = engine.isValidHand("2D 9C AS AH AC 2D");

		assertEquals(false, valid);
	}

	@Test
	public void shouldNotAcceptDuplicateCards() throws Exception {
		PokerHandEngine engine = new PokerHandEngine();

		boolean valid = engine.isValidHand("9C AS AS AC 2D");

		assertEquals(false, valid);
	}

	@Test
	public void shouldParseStringToHand() throws Exception {
		PokerHandEngine engine = new PokerHandEngine();
		Hand hand = engine.evaluateHand("2D 9C AS AH 7C");
		Hand testHand = new Hand(CardFigures.TWO.of(CardColors.DIAMONDS),
				CardFigures.NINE.of(CardColors.CLUBS),
				CardFigures.ACE.of(CardColors.SPADES),
				CardFigures.ACE.of(CardColors.HEARTS),
				CardFigures.SEVEN.of(CardColors.CLUBS));
		assertEquals(hand, testHand);
	}

	@Test
	public void shouldGiveAWinner() throws Exception {
		PokerHandEngine engine = new PokerHandEngine();
		Hand hand = engine.evaluateHand("2D 2H KS AH 7C");
		assertEquals(hand.getRank(), Ranks.ONE_PAIR);
	}

}
