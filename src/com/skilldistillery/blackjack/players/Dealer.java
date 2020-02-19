package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.*;
import com.skilldistillery.blackjack.hand.BlackjackHand;

public class Dealer extends Player {
	private Deck deck;
	private BlackjackHand hand;

	public Dealer() {
		deck = new Deck();
		hand = new BlackjackHand();
	}

	// DEALING CARDS TO PLAYER
	public void dealPlayer(BlackjackPlayer bjPlayer) {
		bjPlayer.hit(deck.dealCard());
	}

	// DEALING CARDS TO DEALER
	public void dealDealer(Card card) {
		hand.addCard(deck.dealCard());
	}

	// DEALER CHECKING THEIR HAND
	public BlackjackHand dealerCheckHand() {
		return hand;
	}

	// shuffle method
	public void shuffleDeck() {
		deck.shuffle();
	}

	public void clearHand() {
		hand = new BlackjackHand();
	}

	public Deck getDeck() {
		return deck;
	}

	// FIRST CARD HIDDEN
	public void showDealerHandX() {
		System.out.println("Dealer's first card is marked with an X:\n [X] " + "[" + hand.getCards().get(1) + "]");
	}

	// BOTH DEALER CARDS SHOWN
	public void showDealerHand2() {
		System.out.println(hand.toString());
	}
	
//	public void dealerHit(Card card) {
//		dealerHit(deck.dealCard());
//		
//	}

}
