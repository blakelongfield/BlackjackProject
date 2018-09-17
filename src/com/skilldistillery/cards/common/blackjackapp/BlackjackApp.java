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

		System.out.println("Would you like to start a game of blackjack? y/n");
		System.out.print(">>:");
		String input = sc.next();
		
		while (true) {
		if (input.equals("n")) {
			System.exit(0);		//exits program entirely
		}
		while (!input.equals("y")) {
			System.out.println("Please enter a valid response.");
			input = sc.next();
		}
		if (input.equals("y")) {
			deck.shuffle();		//shuffle deck
			
			playerHand.addCard(deck.dealCard());			//add first card to player deck
			playerHand.addCard(deck.dealCard());			//add second card to player deck

			houseHand.addCard(deck.dealCard());				//add first card to house deck
			System.out.println("\nThe house flips one card over and then deals themself a..");
			System.out.println(houseHand.toString());		
			System.out.println("House hand value: " + houseHand.getHandValue());

			playPlayerHand(playerHand, deck);
			if (playerHand.getHandValue() > 21) {
				System.out.println("\nYou busted!");		//exits the game if the user busts
			} else {
				playDealerHand(houseHand, deck);			
			}
			if (houseHand.getHandValue() == playerHand.getHandValue()) {
				System.out.println("*************************");
				System.out.println("\nHouse hand value: " + houseHand.getHandValue());
				System.out.println("Player hand value: " + playerHand.getHandValue());
				System.out.println("The game ends in a push.");
			}
			if (houseHand.getHandValue() > playerHand.getHandValue() && houseHand.getHandValue() <= 21) {
				System.out.println("*************************");
				System.out.println("\nHouse hand value: " + houseHand.getHandValue());
				System.out.println("Player hand value: " + playerHand.getHandValue());
				System.out.println("\nThe house always wins!");
			}
			if (playerHand.getHandValue() > houseHand.getHandValue() && playerHand.getHandValue() <= 21) {
				System.out.println("*************************");
				System.out.println("\nHouse hand value: " + houseHand.getHandValue());
				System.out.println("Player hand value: " + playerHand.getHandValue());
				System.out.println("\n*************");
				System.out.println("*           *");
				System.out.println("*  You win! *");
				System.out.println("*           *");
				System.out.println("*************");
			}
		} System.out.println("Would you like to play again? y/n");
		playerHand.clearHand();
		houseHand.clearHand();
		input = sc.next();
		if (deck.checkDeckSize() < 45) {
			deck.createDeck();
		}
		
		}
}

	private static void playDealerHand(Hand houseHand, Deck deck2) {
		System.out.println("\nYou decide to stay and the dealer begins their turn.");
		System.out.println("The dealer turns their other card over revealing their full hand..");

		while (houseHand.getHandValue() <= 16) {
			houseHand.addCard(deck2.dealCard());
			System.out.println(houseHand.toString());
			System.out.println("House hand value: " + houseHand.getHandValue() + "\n");
			if (houseHand.getHandValue() <= 16) {
				System.out.println("The dealer has less than 17 and must hit");
				System.out.println("The dealer deals a card and they now have...");
			}
			if (houseHand.getHandValue() > 21) {
				System.out.println("*************************");
				System.out.println("\nThe dealer busts..");
				System.out.println("\n*************");
				System.out.println("*           *");
				System.out.println("*  You win! *");
				System.out.println("*           *");
				System.out.println("*************");
			}
		}
	}

	private static void playPlayerHand(Hand playerHand, Deck remainingDeck) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nYou're dealt a " + playerHand.toString());
		System.out.println("Your hand value: " + playerHand.getHandValue() + "\n");
		System.out.println("Would you like to [h]it or [s]tay?");
		String inputHitOrStay = sc.next();
		
		while (playerHand.getHandValue() <= 21 && inputHitOrStay.equals("h")) {
			playerHand.addCard(remainingDeck.dealCard());
			System.out.println("\nThe dealer deals you another card...");
			System.out.println("Your cards are: " + playerHand.toString());
			System.out.println("Your hand value: " + playerHand.getHandValue());
			if (playerHand.getHandValue() > 21) {
				break;
			}
			System.out.println("\nWould you like to [h]it or [s]tay?");
			inputHitOrStay = sc.next();
		}
	}
}
