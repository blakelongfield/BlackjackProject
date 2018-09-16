package com.skilldistillery.cards.common.blackjackapp;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Deck deck = new Deck();
		Hand playerHand = new BlackjackHand();
		Hand houseHand = new BlackjackHand();

		System.out.println("Would you like to begin a game of blackjack? y/n");
		System.out.print(">>:");
		String input = sc.next();

		while (!input.equals("y")) {
			System.out.println("Please enter a valid response.");
			input = sc.next();
		}
		if (input.equals("y")) {
			deck.shuffle();
			playerHand.addCard(deck.dealCard());
			playerHand.addCard(deck.dealCard());

			houseHand.addCard(deck.dealCard());
			System.out.println("\nThe house flips one card over and then deals themself a..");
			System.out.println(houseHand.toString());
			System.out.println("House hand value: " + houseHand.getHandValue());

			playPlayerHand(playerHand, deck);
			if (playerHand.getHandValue() > 21) {
				System.out.println("\nYou busted!");
			} else {
				playDealerHand(houseHand, deck);
			}
			if (houseHand.getHandValue() == playerHand.getHandValue()) {
				System.out.println("\nHouse hand value: " + houseHand.getHandValue());
				System.out.println("Player hand value: " + playerHand.getHandValue());
				System.out.println("The game is a push and the game ends.");
			}
			if (houseHand.getHandValue() > playerHand.getHandValue() && houseHand.getHandValue() <= 21) {
				System.out.println("\nHouse hand value: " + houseHand.getHandValue());
				System.out.println("Player hand value: " + playerHand.getHandValue());
				System.out.println("\nThe house always wins!");
			}
			if (playerHand.getHandValue() > houseHand.getHandValue() && playerHand.getHandValue() <= 21) {
				System.out.println("You win!");
			}
		}
	}

	private static void playDealerHand(Hand houseHand, Deck deck2) {
		// System.out.println(houseHand.toString());
		// System.out.println(houseHand.getHandValue());
		System.out.println("\nYou decide to stay and the dealer begins their turn.");
		System.out.println("The dealer turns their other card over revealing their full hand..");

		while (houseHand.getHandValue() <= 16) {
			houseHand.addCard(deck2.dealCard());
			System.out.println(houseHand.toString());
			System.out.println(houseHand.getHandValue());
			if (houseHand.getHandValue() <= 16) {
				System.out.println("The dealer has less than 17 and must hit");
				System.out.println("The dealer deals a card and their full deck is shown..");
			}
			if (houseHand.getHandValue() > 21) {
				System.out.println("\nThe dealer busted and you win!!");
			}
		}
	}

	private static void playPlayerHand(Hand playerHand, Deck remainingDeck) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("You're dealt a " + playerHand.toString());
		System.out.println("Your hand value: " + playerHand.getHandValue() + "\n");

		System.out.println("Would you like to [h]it or [s]tay?");
		String inputHitOrStay = sc.next();
		
		while (playerHand.getHandValue() <= 21 && inputHitOrStay.equals("h")) {
			playerHand.addCard(remainingDeck.dealCard());
			System.out.println("your cards are: " + playerHand.toString());
			System.out.println("Your hand value: " + playerHand.getHandValue());
			if (playerHand.getHandValue() > 21) {
				break;
			}
			System.out.println("Would you like to [h]it or [s]tay?");
			inputHitOrStay = sc.next();
		}
	}
}
