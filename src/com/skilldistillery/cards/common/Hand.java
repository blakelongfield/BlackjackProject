package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	private List<Card> cards = new ArrayList<Card>();

	public Hand() {

	}

	public int getHandValue() {
		int handValue = 0;
		for (int i = 0; i < cards.size(); i++) {
			handValue += cards.get(i).getValue();
		}
		return handValue;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void clearHand() {
		cards.clear();
	}

	public List<Card> getCards() {
		return null;

	}

	@Override
	public String toString() {
		String s = "";
		for (Card card : cards) {
			s = s + card.toString() + ", ";
		}
		return s;
	}

	public boolean didIBust() {
		if (getHandValue() > 21) {
			return true;
		}
		return false;

	}

	public boolean doIHaveBlackjackBoolean(Hand playerHand) {
		if (getHandValue() == 21 && cards.size() == 2) {
			return true;
		}
		return false;
	}

	public StringBuilder doIHaveBlackjack(Hand playerHand) {
		StringBuilder sb = new StringBuilder();
		if (getHandValue() != 21) {
			return null;
		}
		else if (getHandValue() == 21 && cards.size() == 2) {
				sb.append("BLACKJACK!");
				sb.append("\n*************");
				sb.append("*           *");
				sb.append("*  You win! *");
				sb.append("*           *");
				sb.append("*************");
				return sb;
			}
		else {
			return null;
		}

	}

}
