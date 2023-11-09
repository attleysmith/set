package com.asgames.set.domain.matches;

import com.asgames.set.domain.card.Card;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode()
public class MatcherKey {
    private final Card firstCard;
    private final Card secondCard;

    @EqualsAndHashCode.Exclude
    private final boolean sameColor;
    @EqualsAndHashCode.Exclude
    private final boolean sameShape;
    @EqualsAndHashCode.Exclude
    private final boolean sameTexture;
    @EqualsAndHashCode.Exclude
    private final boolean sameValue;

    public MatcherKey(Card firstCard, Card secondCard) {
        this.firstCard = firstCard;
        this.secondCard = secondCard;

        sameColor = firstCard.getColor().sameAttribute(secondCard.getColor());
        sameShape = firstCard.getShape().sameAttribute(secondCard.getShape());
        sameTexture = firstCard.getTexture().sameAttribute(secondCard.getTexture());
        sameValue = firstCard.getValue().sameAttribute(secondCard.getValue());
    }

    public boolean matches(Card card) {
        if (this.contains(card)) {
            return false;
        }
        if (sameColor && !(firstCard.matchingColor(card) && secondCard.matchingColor(card))) {
            return false;
        } else if (!sameColor && (firstCard.matchingColor(card) || secondCard.matchingColor(card))) {
            return false;
        }
        if (sameShape && !(firstCard.matchingShape(card) && secondCard.matchingShape(card))) {
            return false;
        } else if (!sameShape && (firstCard.matchingShape(card) || secondCard.matchingShape(card))) {
            return false;
        }
        if (sameTexture && !(firstCard.matchingTexture(card) && secondCard.matchingTexture(card))) {
            return false;
        } else if (!sameTexture && (firstCard.matchingTexture(card) || secondCard.matchingTexture(card))) {
            return false;
        }
        if (sameValue && !(firstCard.matchingValue(card) && secondCard.matchingValue(card))) {
            return false;
        } else if (!sameValue && (firstCard.matchingValue(card) || secondCard.matchingValue(card))) {
            return false;
        }
        return true;
    }

    private boolean contains(Card card) {
        return firstCard.equals(card) || secondCard.equals(card);
    }

    @Override
    public String toString() {
        return "MatcherKey{" +
                "firstCard=" + firstCard +
                ", secondCard=" + secondCard +
                '}';
    }
}
