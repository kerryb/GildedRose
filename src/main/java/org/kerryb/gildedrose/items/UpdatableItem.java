package org.kerryb.gildedrose.items;
import org.kerryb.gildedrose.strategies.Strategy;

public abstract class UpdatableItem {
  public static final int MAX_QUALITY = 50;
  protected Item item;

  public static UpdatableItem forItem(final Item item) {
    return UpdateableItemFactory.forItem(item);
  }

  public UpdatableItem(Item item) {
    this.item = item;
  }

  public void update() {
    sellInAdjustmentStrategy().execute();
    qualityAdjustmentStrategy().execute();
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
}