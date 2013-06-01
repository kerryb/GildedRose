import java.util.ArrayList;
import java.util.List;

public class GildedRose {
  public static final int MAX_QUALITY = 50;

  static List<Item> items = null;

  public static void main(String[] args) {
    System.out.println("OMGHAI!");

    items = new ArrayList<Item>();
    items.add(new NormalItem("+5 Dexterity Vest", 10, 20));
    items.add(new ImprovingItem("Aged Brie", 2, 0));
    items.add(new NormalItem("Elixir of the Mongoose", 5, 7));
    items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new ConjuredItem("Conjured Mana Cake", 3, 6));

    updateQuality();
  }

  public static void updateQuality() {
    for (Item item : items) {
      sellInAdjustmentStrategyFor(item).run();
      qualityAdjustmentStrategyFor(item).run();
    }
  }

  private static Strategy sellInAdjustmentStrategyFor(final Item item) {
    if (isLegendary(item)) {
      return new NeverExpiringSellinAdjustmentStrategy();
    } else {
      return new DefaultSellInAdjustmentStrategy(item);
    }
  }

  private static Strategy qualityAdjustmentStrategyFor(final Item item) {
    return new DefaultQualityAdjustmentStrategyFor(item);
  }

  private static boolean isLegendary(final Item item) {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }
}