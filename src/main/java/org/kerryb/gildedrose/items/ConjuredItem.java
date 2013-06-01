package org.kerryb.gildedrose.items;

import org.kerryb.gildedrose.strategies.Strategy;
import org.kerryb.gildedrose.strategies.quality.ConjuredItemQualityAdjustmentStrategy;
import org.kerryb.gildedrose.strategies.sellin.DefaultSellInAdjustmentStrategy;

public class ConjuredItem extends UpdatableItem {
  public ConjuredItem(final Item item) {
    super(item);
  }

  @Override
  protected Strategy sellInAdjustmentStrategy() {
    return new DefaultSellInAdjustmentStrategy(this);
  }

  @Override
  protected Strategy qualityAdjustmentStrategy() {
    return new ConjuredItemQualityAdjustmentStrategy(this);
  }
}