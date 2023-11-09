package com.asgames.set;

import com.asgames.set.domain.card.Card;
import com.asgames.set.domain.deck.Deck;
import com.asgames.set.domain.deck.DeckBuilder;
import com.asgames.set.domain.matches.MatcherKey;
import com.asgames.set.domain.matches.MatcherStruct;

import java.util.Map;

public class SetApplication {

    public static void main(String[] args) {
        Deck deck = DeckBuilder.build();
        deck.print();
        System.out.println("--------------------------------------------------------------------------------");
        Map<MatcherKey, Card> matcherStruct = MatcherStruct.create().buildStruct(deck);
//        for (Map.Entry<MatcherKey, Card> matcherKeyCardEntry : matcherStruct.entrySet()) {
//            System.out.println(matcherKeyCardEntry.getKey().toString());
//            System.out.println(matcherKeyCardEntry.getValue().toString());
//            System.out.println("++++++++++++++++++++++++++++++++++++++++");
//        }
//        System.out.println("--------------------------------------------------------------------------------");

        System.out.print("  -");
        for (int i = 1; i <= 81; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 1; i <= 81; i++) {
            System.out.printf("%3d", i);
            for (int j = 1; j <= 81; j++) {
                Card matchingCard = matcherStruct.get(new MatcherKey(deck.getCard(i), deck.getCard(j)));
                if (matchingCard == null) {
                    System.out.print("  -");
                } else {
                    System.out.printf("%3d", matchingCard.getNumber());
                }
            }
            System.out.println();
        }

    }

}
