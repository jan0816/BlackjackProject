package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.hand.Hand;

public abstract class Player {
	private Hand hand;

	// METHODS

	public void checkCards() {

	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [hand=");
		builder.append(hand);
		builder.append("]");
		return builder.toString();
	}
}
