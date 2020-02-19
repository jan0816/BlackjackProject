package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.hand.*;

public class BlackjackPlayer extends Player {

	// FIELDS
	private BlackjackHand bjpHand;

	// METHODS

	// ctor
	public BlackjackPlayer() {
		bjpHand = new BlackjackHand();
	}

	public BlackjackHand getBjpHand() {
		return bjpHand;
	}

	public void showPlayerHand() {
		System.out.println("Player has been dealt : " + bjpHand.toString());
	}

	public void hit(Card card) {
		bjpHand.addCard(card);
	}

	public boolean stand() {
		return false;
	}

}
