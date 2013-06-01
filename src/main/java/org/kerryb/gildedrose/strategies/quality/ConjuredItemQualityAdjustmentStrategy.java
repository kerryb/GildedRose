package org.kerryb.gildedrose.strategies.quality;

import org.kerryb.gildedrose.items.UpdatableItem;
import org.kerryb.gildedrose.strategies.Strategy;

public class ConjuredItemQualityAdjustmentStrategy implements Strategy {
  private UpdatableItem item;

  public ConjuredItemQualityAdjustmentStrategy(UpdatableItem item) {
    this.item = item;
  }

  @Override
  public void run() {
    item.decreaseQualityBy(2);
  }
}