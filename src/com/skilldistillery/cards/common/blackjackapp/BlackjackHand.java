package com.skilldistillery.cards.common.blackjackapp;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	public int getHandValue(List<Card> hand) {
		int handValue = 0;
		for (int i = 0; i < hand.size(); i++) {
			handValue += hand.get(i).getValue();
		}
		return handValue;
	}
	
	public int getHouseHandValue(List<Card> hand) {
		int houseHandValue = 0;
		for (int i = 0; i < hand.size(); i++) {
			houseHandValue += hand.get(i).getValue();
		}
		return houseHandValue;
	}

	public StringBuilder getHand(List<Card> hand) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hand.size(); i++) {
			sb.append(hand.get(i));
			sb.append(" ");
		}
		return sb;

	}

}
