package com.skilldistillery.cards.common.blackjackapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;
import com.skilldistillery.cards.common.Suit;

public class BlackjackApp {

	Deck deck = new Deck();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Card card = new Card(null, null);

		BlackjackApp bjApp = new BlackjackApp();
		BlackjackHand genericHand = new BlackjackHand();
		BlackjackHand genericHouseHand = new BlackjackHand();

		List<Card> playerHand = new ArrayList<Card>();
		List<Card> houseHand = new ArrayList<Card>();

		System.out.println("Would you like to begin a game of blackjack? y/n");
		System.out.print(">>:");
		String input = sc.next();
		bjApp.deck.createDeck();

		if (input.equals("y")) {
			bjApp.deck.shuffle();
			playerHand.add(bjApp.deck.dealCard());

			System.out.println("You're dealt...");
			playerHand.add(bjApp.deck.dealCard());
			System.out.println(genericHand.getHand(playerHand));
			int handValue = genericHand.getHandValue(playerHand);
			System.out.println("Your hand value: " + handValue + "\n");

			houseHand.add(bjApp.deck.dealCard());
			System.out.println("The house deals a...");
			System.out.println(houseHand.get(0));

			System.out.println("Would you like to [h]it or [s]tay?");
			String inputHitOrStay = sc.next();

			boolean enterLoop = true;
			
			while (enterLoop && handValue < 21) {

				if (inputHitOrStay.equals("h")) {
					playerHand.add(bjApp.deck.dealCard());
					System.out.println(genericHand.getHand(playerHand) + "\n");
					handValue = genericHand.getHandValue(playerHand);
					System.out.println("Your hand value: " + handValue + "\n");
					if (handValue > 21) {
						bjApp.deck.bust();
					System.out.println("Would you like to [h]it or [s]tay?");
					inputHitOrStay = sc.next();
					}
				}
				if (inputHitOrStay.equals("s")) {
					System.out.println("You decide to stay with a hand value of: " + handValue);
					System.out.println("The house flips over their other card..");
					System.out.println(houseHand.add(bjApp.deck.dealCard()));
					
					System.out.println("The dealer now has a " + houseHand + " with a value of " + genericHouseHand.getHouseHandValue(houseHand));
					enterLoop = false;
					break;
				} else {
					System.out.println("Please enter a valid response");
				}

			}
		
		}
	}
}
