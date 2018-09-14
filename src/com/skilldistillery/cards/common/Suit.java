package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts"), 
	SPADES("Spades"), 
	CLUBS("Clubs"), 
	DIAMONDS("Diamonds");

	Suit(String name) {
		this.name = name;
	}

	private final String name;

	@Override
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
}
