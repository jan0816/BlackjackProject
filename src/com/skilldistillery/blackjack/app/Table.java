package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.players.*;

public class Table {
	private Deck deck = new Deck();
	private Dealer dealer = new Dealer();
	private BlackjackPlayer BJPlayer = new BlackjackPlayer();
	private Scanner kb = new Scanner(System.in);

	public Table() {

	}

	public static void main(String[] args) {
		Table app = new Table();
		app.displayMenu();
	}

	public void displayMenu() {
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("Welcome to Blackjack!!!");
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.print("Enter your name: ");
		String name = kb.nextLine();
		System.out.print(name + ", Would you like to 1. Play or 2. Quit? ");
		int choice = kb.nextInt();
		if (choice == 1) {
			run();
		} else if (choice == 2) {
			System.out.println("Thanks for playing. Goodbye!");
		} else {
			System.err.println("Please enter 1 to play or 2 to quit.");
		}
	}

	public void run() {
		boolean continueBJ = true;
		do {
			dealer.shuffleDeck();
			System.out.println("\nDealer is shuffling cards now..");
			System.out.println("\nDealing cards...");
			dealer.dealPlayer(BJPlayer);
			dealer.dealDealer(dealer.getDeck().dealCard());
			System.out.println();
			dealer.dealPlayer(BJPlayer);
			dealer.dealDealer(dealer.getDeck().dealCard());
			BJPlayer.showPlayerHand();
			dealer.showDealerHandX();
			System.out.println();
			System.out.println("Your total is: " + BJPlayer.getBjpHand().getHandValue() + "\n");

			while (true) {
				System.out.print("Do you want to hit? Y or N \n******************");
				String hitAnswer = kb.next();
				if (hitAnswer.equals("Y") || hitAnswer.equals("y") || hitAnswer.equalsIgnoreCase("Yes")) {
					dealer.dealPlayer(BJPlayer);
					BJPlayer.showPlayerHand();
					if (BJPlayer.getBjpHand().isBust()) {
						System.out.println("******************");
						System.out.println("\nMONKEY! SORRY YOU BUSTED.");
						break;
					} else if (BJPlayer.getBjpHand().isBlackjack()) {
						System.out.println("******************");
						System.out.println("You got 21!!");
						System.out.println("******************");
						break;
					}
					System.out.println("Your total is: " + BJPlayer.getBjpHand().getHandValue() + "\n");
				} else {
					break;
				}
			}
			while (dealer.dealerCheckHand().getHandValue() <= 17) {
				dealer.dealDealer(dealer.getDeck().dealCard());
				//dealer.showDealerHand2();
			}
			while (true) {
				System.out.println(dealer.dealerCheckHand().getCards());
				break;
			}
			if (BJPlayer.getBjpHand().getHandValue() > dealer.dealerCheckHand().getHandValue()
					&& !BJPlayer.getBjpHand().isBust()) {
				System.out.print("Dealer's Hand: ");
				dealer.showDealerHand2();
				System.out.println("WINNER, WINNER, CHICKEN DINNER!");
				System.out.println("\nDo you want to play again? Y or N ");
				String playAgain = kb.next();
				if (playAgain.equalsIgnoreCase("N")) {
					continueBJ = false;
				}
			} else if (BJPlayer.getBjpHand().getHandValue() < dealer.dealerCheckHand().getHandValue()) {
				if (dealer.dealerCheckHand().isBust()) {
					System.out.println("******************");
					System.out.println("THE HOUSE BUSTED!");
					System.out.println("WINNER, WINNER, CHICKEN DINNER!");
					System.out.println("******************");
				} else {
					System.out.println("******************");
					System.out.println("LOOKS LIKE THE HOUSE WON THIS TIME.");
					System.out.println("******************");
				}
				System.out.println("Do you want to play again? Y or N ");
				String playAgain = kb.next();
				if (playAgain.equalsIgnoreCase("N")) {
					continueBJ = false;
				}
			} else if (BJPlayer.getBjpHand().getHandValue() == dealer.dealerCheckHand().getHandValue()) {
				System.out.println("******************");
				System.out.println("YOU TIED WITH THE DEALER..WAH WAH WAH... ");
				System.out.println("******************");
				System.out.println("Do you want to play again? Y or N ");
				String playAgain = kb.next();
				if (playAgain.equalsIgnoreCase("N")) {
					continueBJ = false;
				}
			}

			dealer.clearHand();
			BJPlayer.getBjpHand().clear();

		} while (continueBJ);
		System.err.println("Thanks for playing! If you need help: "
				+ "\nThe National Problem Gambling Helpline, operated by the National Council on Problem Gambling (NCPG),"
				+ "\nis available to you and can be reached via phone or text at 1-800-522-4700");

	}

}
//purposely chose to use a sys err for a bright message. Wish the formatting would have been a bit cleaner but will figure it out another time.