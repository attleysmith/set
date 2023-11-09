package com.asgames.set.domain.deck;

import com.asgames.set.domain.card.Card;
import com.asgames.set.domain.card.attributes.Attribute;

import static com.asgames.set.domain.card.attributes.AttributeFactory.getAttributeValues;
import static java.util.Arrays.copyOfRange;

public class DeckBuilder {

    public static Deck build() {
        Deck deck = Deck.create();
        Card cardTemplate = Card.empty();
        int counter = 0;

        setAttributes(deck, cardTemplate, counter, getAttributeValues());

        return deck;
    }

    private static int setAttributes(Deck deck, Card cardTemplate, int counter, Attribute[]... attributeValues) {
        for (Attribute attribute : attributeValues[0]) {
            if (attributeValues.length == 1) {
                putCard(deck, cardTemplate, ++counter, attribute);
            } else {
                attribute.setOnCard(cardTemplate);

                Attribute[][] remainingAttributeValues = copyOfRange(attributeValues, 1, attributeValues.length);
                counter = setAttributes(deck, cardTemplate, counter, remainingAttributeValues);
            }
        }
        return counter;
    }

    private static void putCard(Deck deck, Card cardTemplate, int number, Attribute attribute) {
        Card card = attribute.cloneCardWithIt(cardTemplate);
        card.setNumber(number);
        deck.add(card);
    }
}
