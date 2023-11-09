package com.asgames.set.domain.card.attributes;

import com.asgames.set.domain.card.Card;

public enum Texture implements Attribute {
    EMPTY, STRIPED, FILLED;

    @Override
    public void setOnCard(Card card) {
        card.setTexture(this);
    }

    @Override
    public Card cloneCardWithIt(Card card) {
        return card.withTexture(this);
    }
}
