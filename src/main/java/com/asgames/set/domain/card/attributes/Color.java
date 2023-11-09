package com.asgames.set.domain.card.attributes;

import com.asgames.set.domain.card.Card;

public enum Color implements Attribute {
    RED, GREEN, PURPLE;

    @Override
    public void setOnCard(Card card) {
        card.setColor(this);
    }

    @Override
    public Card cloneCardWithIt(Card card) {
        return card.withColor(this);
    }
}
