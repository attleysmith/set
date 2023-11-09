package com.asgames.set.domain.card.attributes;

import com.asgames.set.domain.card.Card;

public interface Attribute {

    void setOnCard(Card card);

    Card cloneCardWithIt(Card card);

    default boolean sameAttribute(Attribute otherAttribute) {
        return this.equals(otherAttribute);
    }
}
