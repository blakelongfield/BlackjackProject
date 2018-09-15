package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	public Hand() {
		
	}

	public int getHandValue(ArrayList<Card> hand) {
		int handValue = 0;
		for (int i = 0; i < hand.size(); i++) {
			handValue += hand.get(i).getValue();
		}
		return handValue;
	}
	
	public void addCard(int card) {
		
	}
	
	public void clearHand() {
		
	}
	
	public List<Card> getCards() {
		return null;
		
	}

//	@Override
////	public String toString() {
//	//	return "Cards: " + getCards() + " with a value of " + getHandValue();
//	}
	
	
	
}
