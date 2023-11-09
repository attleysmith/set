package com.asgames.set.domain.deck;

import com.asgames.set.domain.card.Card;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(staticName = "create")
public class Deck {

    private final Map<Integer, Card> cards = new HashMap<>();

    public void add(Card card) {
        Card previous = cards.putIfAbsent(card.getNumber(), card);
        if (previous != null) {
            throw new IllegalArgumentException("Card already exists with the number " + card.getNumber());
        }
    }

    public Collection<Card> getCards() {
        return cards.values();
    }

    public Card getCard(Integer cardNumber) {
        return cards.get(cardNumber);
    }

    public void print() {
        cards.forEach((number, card) -> {
            System.out.println(card.toString());
        });
    }
}
