package org.kerryb.gildedrose.items;

public class UpdateableItemFactory {
  public static UpdatableItem forItem(final Item item) {
    if (isLegendary(item)) {
      return new LegendaryItem(item);
    } else if (isBackstagePass(item)) {
      return new BackStagePass(item);
    } else if (improvesWithAge(item)) {
      return new ImprovingWithAgeItem(item);
    } else if (isConjured(item)) {
      return new ConjuredItem(item);
    } else {
      return new NormalItem(item);
    }
  }

  private static boolean isLegendary(final Item item) {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }

  private static boolean isBackstagePass(final Item item) {
    return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
  }

  private static boolean improvesWithAge(final Item item) {
    return "Aged Brie".equals(item.getName());
  }

  private static boolean isConjured(final Item item) {
    return "Conjured Mana Cake".equals(item.getName());
  }
}