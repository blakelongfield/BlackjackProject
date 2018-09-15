package com.skilldistillery.cards.common.blackjackapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;
import com.skilldistillery.cards.common.Suit;

public class BlackjackApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Deck deck = new Deck();
		Hand playerHand = new BlackjackHand();
		Hand houseHand = new BlackjackHand();

		System.out.println("Would you like to begin a game of blackjack? y/n");
		System.out.print(">>:");
		String input = sc.next();

		if (input.equals("y")) {
			deck.shuffle();
			playerHand.addCard(deck.dealCard());
			playerHand.addCard(deck.dealCard());
//			System.out.println("Your cards are: " + playerHand.toString());
//			System.out.println("Your hand value: " + playerHand.getHandValue() + "\n");

			houseHand.addCard(deck.dealCard());
			System.out.println("The house turns it's first card over and deals a...");
			System.out.println(houseHand.toString());
			System.out.println("House hand value: " + houseHand.getHandValue());

			playPlayerHand(playerHand, deck);
			if (playerHand.getHandValue() > 21) {
				System.out.println("Haha, you busted!");
			} else {
				playDealerHand(houseHand, deck);
			}
			//decide who wins.
		}
	}

	private static void playDealerHand(Hand houseHand, Deck deck2) {
		System.out.println(houseHand.toString());
		System.out.println(houseHand.getHandValue());

		while (houseHand.getHandValue() <= 16) {
			houseHand.addCard(deck2.dealCard());
			System.out.println(houseHand.toString());
			System.out.println(houseHand.getHandValue());

		}
	}

	private static void playPlayerHand(Hand playerHand, Deck remainingDeck) {
		Scanner sc = new Scanner(System.in);
		System.out.println("your cards are: " + playerHand.toString());
		System.out.println(playerHand.getHandValue());

		System.out.println("Would you like to [h]it or [s]tay?");
		String inputHitOrStay = sc.next();

		while (playerHand.getHandValue() <= 21 && inputHitOrStay.equals("h")) {
			playerHand.addCard(remainingDeck.dealCard());
			System.out.println("your cards are: " + playerHand.toString());
			System.out.println(playerHand.getHandValue());
			if (playerHand.getHandValue() > 21) {
				break;
			}
			System.out.println("Would you like to [h]it or [s]tay?");
			inputHitOrStay = sc.next();
		}

	}
}
