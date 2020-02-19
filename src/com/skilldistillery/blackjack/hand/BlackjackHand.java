package com.skilldistillery.blackjack.hand;

import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand {
	// FIELDS

	// METHODS

	// ctor
	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : getCards()) {
			handValue += card.getValue();
		}
		return handValue;
	}

	public boolean isBlackjack() {

		if (this.getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (this.getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}
}
