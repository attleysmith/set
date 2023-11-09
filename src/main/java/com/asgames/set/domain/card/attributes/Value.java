package com.asgames.set.domain.card.attributes;

import com.asgames.set.domain.card.Card;

public enum Value implements Attribute {
    ONE, TWO, THREE;

    @Override
    public void setOnCard(Card card) {
        card.setValue(this);
    }

    @Override
    public Card cloneCardWithIt(Card card) {
        return card.withValue(this);
    }
}
