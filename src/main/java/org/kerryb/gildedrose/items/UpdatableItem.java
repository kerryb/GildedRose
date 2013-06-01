package org.kerryb.gildedrose.items;
import org.kerryb.gildedrose.strategies.Strategy;

public abstract class UpdatableItem {

  protected Item item;

  public UpdatableItem(Item item) {
    this.item = item;
  }

  public void update() {
    sellInAdjustmentStrategy().run();
    qualityAdjustmentStrategy().run();
  }

  public static UpdatableItem forItem(final Item item) {
    if (isLegendary(item)) {
      return new LegendaryItem(item);
    } else if (isBackstagePass(item)) {
      return new BackStagePass(item);
    } else if (improvesWithAge(item)) {
      return new ImprovingWithAgeItem(item);
    } else {
      return new NormalItem(item);
    }
  }

  protected abstract Strategy sellInAdjustmentStrategy();

  protected abstract Strategy qualityAdjustmentStrategy();

  private static boolean isLegendary(final Item item) {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }

  private static boolean isBackstagePass(final Item item) {
    return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
  }

  private static boolean improvesWithAge(final Item item) {
    return "Aged Brie".equals(item.getName());
  }
}