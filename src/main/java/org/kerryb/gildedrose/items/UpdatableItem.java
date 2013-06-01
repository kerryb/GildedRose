package org.kerryb.gildedrose.items;
import org.kerryb.gildedrose.strategies.Strategy;

public abstract class UpdatableItem {
  public static final int MAX_QUALITY = 50;

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
    } else if (isConjured(item)) {
      return new ConjuredItem(item);
    } else {
      return new NormalItem(item);
    }
  }

  protected abstract Strategy sellInAdjustmentStrategy();

  protected abstract Strategy qualityAdjustmentStrategy();

  public boolean hasExpired() {
    return item.getSellIn() <= 0;
  }

  public boolean mustBeSoldInTheNext(int days) {
    return item.getSellIn() <= days;
  }

  public void decreaseSellIn() {
    item.setSellIn(item.getSellIn() - 1);
  }

  public void setQualityToZero() {
    item.setQuality(0);
  }

  public void decreaseQualityBy(final int amount) {
    int newQuality = item.getQuality() - amount;
    item.setQuality(Math.max(newQuality, 0));
  }

  public void increaseQualityBy(int amount) {
    int newQuality = item.getQuality() + amount;
    item.setQuality(Math.min(newQuality, MAX_QUALITY));
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