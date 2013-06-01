import java.util.ArrayList;
import java.util.List;

public class GildedRose {
  // Made default visibility as a step towards testability
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
    for (Item item : items) {
      adjustQuality(item);
      decrementSellIn(item);
      adjustQualityAgainForSomeReason(item);
    }
  }

  private static void adjustQuality(final Item item) {
    if (getsBetterWithAge(item)) {      
      if (isBelowMaximumQuality(item)) {
        incrementQuality(item);

        if (isBackstagePass(item)) {
          if (item.getSellIn() < 11 && isBelowMaximumQuality(item)) {
            incrementQuality(item);
          }

          if (item.getSellIn() < 6 && isBelowMaximumQuality(item)) {
            incrementQuality(item);
          }
        }
      }
    } else {
      if (!isLegendary(item) && hasSomeQualityLeft(item)) {
        decrementQuality(item);
      }
    }
  }

  private static void decrementSellIn(final Item item) {
    if (!isLegendary(item)) {
      item.setSellIn(item.getSellIn() - 1);
    }
  }

  private static void adjustQualityAgainForSomeReason(final Item item) {
    if (hasExpired(item)) {
      if (getsBetterWithAge(item) && !isBackstagePass(item)) {
        if (isBelowMaximumQuality(item)) {
          incrementQuality(item);
        }
      } else {
        if (!isBackstagePass(item) && !isLegendary(item) && hasSomeQualityLeft(item)) {
          decrementQuality(item);
        } else {
          item.setQuality(item.getQuality() - item.getQuality());
        }
      }
    }
  }

  private static boolean hasExpired(final Item item) {
    return item.getSellIn() < 0;
  }

  private static boolean hasSomeQualityLeft(final Item item) {
    return item.getQuality() > 0;
  }

  private static boolean isBelowMaximumQuality(final Item item) {
    return item.getQuality() < 50;
  }

  private static boolean isBackstagePass(final Item item) {
    return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
  }

  private static boolean isLegendary(final Item item) {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }

  private static boolean getsBetterWithAge(final Item item) {
    return "Aged Brie".equals(item.getName()) || isBackstagePass(item);
  }

  private static void incrementQuality(final Item item) {
    item.setQuality(item.getQuality() + 1);
  }

  private static void decrementQuality(final Item item) {
    item.setQuality(item.getQuality() - 1);
  }
}