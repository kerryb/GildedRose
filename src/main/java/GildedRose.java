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
      degradeQuality(item);
      decrementSellIn(item);
      adjustQuality(item);
    }
  }

  private static void degradeQuality(final Item item) {
    if (!getsBetterWithAge(item)) {
      if (item.getQuality() > 0) {
        if (!isLegendary(item)) {
          item.setQuality(item.getQuality() - 1);
        }
      }
    } else {
      if (isBelowMaximumQuality(item)) {
        item.setQuality(item.getQuality() + 1);

        if (isBackstagePass(item)) {
          if (item.getSellIn() < 11) {
            if (isBelowMaximumQuality(item)) {
              item.setQuality(item.getQuality() + 1);
            }
          }

          if (item.getSellIn() < 6) {
            if (isBelowMaximumQuality(item)) {
              item.setQuality(item.getQuality() + 1);
            }
          }
        }
      }
    }
  }

  private static void decrementSellIn(final Item item) {
    if (!isLegendary(item)) {
      item.setSellIn(item.getSellIn() - 1);
    }
  }

  private static void adjustQuality(final Item item) {
    if (item.getSellIn() < 0) {
      if ("Aged Brie".equals(item.getName())) {
        if (isBelowMaximumQuality(item)) {
          item.setQuality(item.getQuality() + 1);
        }
      } else {
        if (!isBackstagePass(item)) {
          if (item.getQuality() > 0) {
            if (!isLegendary(item)) {
              item.setQuality(item.getQuality() - 1);
            }
          }
        } else {
          item.setQuality(item.getQuality() - item.getQuality());
        }
      }
    }
  }

  private static boolean isBackstagePass(final Item item) {
    return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
  }

  private static boolean isBelowMaximumQuality(final Item item) {
    return item.getQuality() < 50;
  }

  private static boolean isLegendary(final Item item) {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }

  private static boolean getsBetterWithAge(final Item item) {
    return "Aged Brie".equals(item.getName()) ||
        isBackstagePass(item);
  }

}