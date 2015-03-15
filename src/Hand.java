import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hand {

	Set<Card> cards = new HashSet<>();

	public Hand(Card... cards) {
		this(Arrays.asList(cards));
	}

	public Hand(List<Card> cards) {
		this.cards.addAll(cards);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}

	public Ranks getRank() {
		Map<CardFigures, Integer> map = new HashMap<>();
		for (Card c : cards) {
			Integer count = map.get(c.getCardFigures());
			if (count == null) {
				map.put(c.getCardFigures(), 1);
			} else {
				map.put(c.getCardFigures(), count + 1);
			}
		}
		Collection<Integer> values = map.values();
		if (values.contains(2) && values.size() == 4) {
			return Ranks.ONE_PAIR;
		} else {
			return null;
		}

	}

}
