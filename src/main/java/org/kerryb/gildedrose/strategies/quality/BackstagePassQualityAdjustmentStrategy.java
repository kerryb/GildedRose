package org.kerryb.gildedrose.strategies.quality;
import org.kerryb.gildedrose.items.UpdatableItem;
import org.kerryb.gildedrose.strategies.Strategy;

public class BackstagePassQualityAdjustmentStrategy implements Strategy {
  private UpdatableItem item;

  public BackstagePassQualityAdjustmentStrategy(final UpdatableItem item) {
    this.item = item;
  }

  @Override
  public void execute() {
    if (item.hasExpired()) {
      item.setQualityToZero();
    } else {
      item.increaseQualityBy(qualityIncrement());
    }
  }

  private int qualityIncrement() {
    if (item.mustBeSoldInTheNext(5)) {
      return 3;
    } else if (item.mustBeSoldInTheNext(10)) {
      return 2;
    } else {
      return 1;
    }
  }
}