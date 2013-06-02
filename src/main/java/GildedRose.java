import java.util.ArrayList;
import java.util.List;

public class GildedRose {
  static List<Item> items = null;

  public static void main(String[] args) {
    System.out.println("OMGHAI!");

    items = new ArrayList<Item>();
    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));

    updateQuality();
  }

  public static void updateQuality() {
    for (final Item item : items) {
      updateItemSellIn(item);
      updateItemQuality(item);
    }
  }

  private static void updateItemSellIn(final Item item) {
    if (!isLegendary(item)) {
      decrementSellIn(item);
    }
  }

  private static void decrementSellIn(final Item item) {
    item.setSellIn(item.getSellIn() - 1);
  }

  private static void updateItemQuality(final Item item) {
    if (improvesWithAge(item)) {
      updateImprovingWithAgeQuality(item);
    } else if (isBackstagePass(item)) {
      updateBackstagePassQuality(item);
    } else if (isConjured(item)) {
      updateConjuredItemQuality(item);
    } else if (!isLegendary(item)) {
      updateNormalItemQuality(item);
    }
  }

  private static void updateImprovingWithAgeQuality(final Item item) {
    if (item.getSellIn() < 0) {
      incrementQuality(item, 2);
    } else {
      incrementQuality(item, 1);
    }
  }

  private static void updateBackstagePassQuality(final Item item) {
    if (item.getSellIn() < 0) {
      item.setQuality(0);
    } else {
      incrementQuality(item, 1);
      if (item.getSellIn() < 11) {
        incrementQuality(item, 1);
      }

      if (item.getSellIn() < 6) {
        incrementQuality(item, 1);
      }
    }
  }

  private static void updateConjuredItemQuality(final Item item) {
    if (item.getSellIn() < 0) {
      decrementQuality(item, 4);
    } else {
      decrementQuality(item, 2);
    }    
  }

  private static void updateNormalItemQuality(final Item item) {
    if (item.getSellIn() < 0) {
      decrementQuality(item, 2);
    } else {
      decrementQuality(item, 1);
    }
  }

  private static boolean isBelowMaximumQuality(final Item item) {
    return item.getQuality() < 50;
  }

  private static boolean hasSomeQualityLeft(final Item item) {
    return item.getQuality() > 0;
  }

  private static void incrementQuality(final Item item, int amount) {
    if (isBelowMaximumQuality(item)) {
      item.setQuality(item.getQuality() + amount);
    }
  }

  private static void decrementQuality(final Item item, int amount) {
    if (hasSomeQualityLeft(item)) {
      item.setQuality(item.getQuality() - amount);
    }
  }

  private static boolean isBackstagePass(final Item item) {
    return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
  }

  private static boolean isLegendary(final Item item) {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }

  private static boolean isConjured(final Item item) {
    return "Conjured Mana Cake".equals(item.getName());
  }

  private static boolean improvesWithAge(final Item item) {
    return "Aged Brie".equals(item.getName());
  }
}