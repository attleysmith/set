package com.asgames.set.domain.card.attributes;

public class AttributeFactory {

    public static Attribute[][] getAttributeValues() {
        return new Attribute[][]{
                Color.values(),
                Shape.values(),
                Texture.values(),
                Value.values()
        };
    }
}
