package com.asgames.set.domain.card;

import com.asgames.set.domain.card.attributes.Color;
import com.asgames.set.domain.card.attributes.Shape;
import com.asgames.set.domain.card.attributes.Texture;
import com.asgames.set.domain.card.attributes.Value;
import lombok.*;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor(staticName = "empty")
public class Card {
    private Integer number;
    @With
    @EqualsAndHashCode.Exclude
    private Color color;
    @With
    @EqualsAndHashCode.Exclude
    private Shape shape;
    @With
    @EqualsAndHashCode.Exclude
    private Texture texture;
    @With
    @EqualsAndHashCode.Exclude
    private Value value;

    public boolean matchingColor(Card card) {
        return this.color.sameAttribute(card.getColor());
    }

    public boolean matchingShape(Card card) {
        return this.shape.sameAttribute(card.getShape());
    }

    public boolean matchingTexture(Card card) {
        return this.texture.sameAttribute(card.getTexture());
    }

    public boolean matchingValue(Card card) {
        return this.value.sameAttribute(card.getValue());
    }
}
