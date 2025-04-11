package org.example.exercises;

import java.util.Arrays;

public class OlxApp {

    public Item[] items;

    public OlxApp(Item[] items) {
        this.items = items;
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item("Mangoes", 10, 20)
        };

        OlxApp app = new OlxApp(items);
        app.updateQuality();

        System.out.println(app);
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isLegendary(item)) {
                updateItem(item);
                decreaseSellIn(item);
                handleExpiredItem(item);
            }
        }
    }

    private void updateItem(Item item) {
        if (isAgedItem(item)) {
            increaseQuality(item);

            if (isBackstagePass(item)) {
                if (item.sellIn < 11) increaseQuality(item);
                if (item.sellIn < 6) increaseQuality(item);
            }
        } else {
            decreaseQuality(item);
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn < 0) {
            if (isAgedItem(item)) {
                increaseQuality(item);
            } else if (isBackstagePass(item)) {
                item.quality = 0;
            } else {
                decreaseQuality(item);
            }
        }
    }

    private boolean isAgedItem(Item item) {
        return item.name.equals("Aged Wine") || isBackstagePass(item);
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("ColdPlay concert passes");
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("PokemonGo");
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
