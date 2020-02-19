package com.skilldistillery.blackjack.hand;

import java.util.*;

import com.skilldistillery.blackjack.cards.Card;

public abstract class Hand {
	// FIELDS

	protected List<Card> cards;

	// METHODS

	public Hand() {
		setCards(new ArrayList<Card>());
	}

	public void addCard(Card card) {
		getCards().add(card);
	}

	public void clear() {
		setCards(new ArrayList<Card>());
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		// builder.append("Hand [cards=");
		builder.append(getCards());
		// builder.append("]");
		return builder.toString();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
