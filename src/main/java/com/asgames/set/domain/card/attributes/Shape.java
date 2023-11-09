package com.asgames.set.domain.card.attributes;

import com.asgames.set.domain.card.Card;

public enum Shape implements Attribute {
    WAVE, STADIUM, DIAMOND;

    @Override
    public void setOnCard(Card card) {
        card.setShape(this);
    }

    @Override
    public Card cloneCardWithIt(Card card) {
        return card.withShape(this);
    }
}
