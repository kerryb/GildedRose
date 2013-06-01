package org.kerryb.gildedrose.items;
import org.kerryb.gildedrose.strategies.Strategy;
import org.kerryb.gildedrose.strategies.quality.FixedQualityAdjustmentStrategy;
import org.kerryb.gildedrose.strategies.sellin.NeverExpiringSellInAdjustmentStrategy;

public class LegendaryItem extends UpdatableItem {

  public LegendaryItem(final Item item) {
    super(item);
  }

  @Override
  protected Strategy sellInAdjustmentStrategy() {
    return new NeverExpiringSellInAdjustmentStrategy();
  }

  @Override
  protected Strategy qualityAdjustmentStrategy() {
    return new FixedQualityAdjustmentStrategy();
  }
}