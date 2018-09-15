package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Deck {
	private List<Card> cards;

	public Deck() {
		this.cards = createDeck();
	}

	public List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void bust() {
		System.out.println("You have gone over 21, Would you like to play again? y/n");
	}

	public Card hit() {
			Card hitCard = null;
			hitCard = dealCard();
			
			return hitCard;
			
		}

		public void dealDealerHand(List<Card> houseHand) {
			houseHand.add(dealCard());
			
			System.out.println("The house flips over his card and its a...");
			System.out.println(houseHand.get(1));
			System.out.println("The house has the cards" + houseHand + "with a value of");
			
			
		}
}
