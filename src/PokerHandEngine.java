import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PokerHandEngine {

	public boolean isValidHand(String string) {
		String[] split = string.split(" ");
		HashSet<String> hand = new HashSet<String>(Arrays.asList(split));

		return hand.size() == 5 && split.length == 5;
	}

	public Hand evaluateHand(String string) {
		List<Card> cards = new ArrayList<>(5);

		String[] split = string.split(" ");
		for (String splitResult : split) {
			cards.add(Card.forString(splitResult));
		}

		return new Hand(cards);
	}

}
