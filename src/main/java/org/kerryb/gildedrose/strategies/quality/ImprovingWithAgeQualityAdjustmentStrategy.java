package org.kerryb.gildedrose.strategies.quality;
import org.kerryb.gildedrose.GildedRose;
import org.kerryb.gildedrose.items.Item;
import org.kerryb.gildedrose.strategies.Strategy;


public class ImprovingWithAgeQualityAdjustmentStrategy implements Strategy {
  private Item item;

  public ImprovingWithAgeQualityAdjustmentStrategy(final Item item) {
    this.item = item;
  }

  public void run() {
    if (item.getQuality() < GildedRose.MAX_QUALITY) {
      item.setQuality(item.getQuality() + 1);
    }
  }
}
