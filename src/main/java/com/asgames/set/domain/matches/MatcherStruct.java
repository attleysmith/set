package com.asgames.set.domain.matches;

import com.asgames.set.domain.card.Card;
import com.asgames.set.domain.deck.Deck;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(staticName = "create")
public class MatcherStruct {

    public Map<MatcherKey, Card> buildStruct(Deck deck) {
        Map<MatcherKey, Card> matchingMap = new HashMap<>();
        for (Card firstCard : deck.getCards()) {
            for (Card secondCard : deck.getCards()) {
                if (firstCard.equals(secondCard)) {
                    continue;
                }
                MatcherKey matcherKey = new MatcherKey(firstCard, secondCard);
                matchingMap.computeIfAbsent(matcherKey, key -> getMatchingCard(key, deck));
            }
        }
        return matchingMap;
    }

    private Card getMatchingCard(MatcherKey matcherKey, Deck deck) {
        Card result = null;
        for (Card matchingCard : deck.getCards()) {
            if (matcherKey.matches(matchingCard)) {
                result = matchingCard;
                break;
            }
        }
        if (result == null) {
            throw new IllegalStateException("No matching card for key " + matcherKey.toString());
        }
        return result;
    }

}
