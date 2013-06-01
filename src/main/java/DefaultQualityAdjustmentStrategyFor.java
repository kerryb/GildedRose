
public class DefaultQualityAdjustmentStrategyFor implements Strategy {

  private Item item;

  public DefaultQualityAdjustmentStrategyFor(final Item item) {
    this.item = item;
  }

  @Override
  public void run() {
    if (getsBetterWithAge(item)) {
      increaseQuality(item, qualityIncrement(item));
    } else {
      if (!isLegendary(item) && hasSomeQualityLeft(item)) {
        decrementQuality(item);
      }
    }
    
    if (hasExpired(item)) {
      if (getsBetterWithAge(item) && !isBackstagePass(item)) {
        if (isBelowMaximumQuality(item)) {
          increaseQuality(item, 1);
        }
      } else {
        if (!isBackstagePass(item) && !isLegendary(item)
            && hasSomeQualityLeft(item)) {
          decrementQuality(item);
        } else {
          item.setQuality(item.getQuality() - item.getQuality());
        }
      }
    }
  }

  private boolean hasExpired(final Item item) {
    return item.getSellIn() < 0;
  }

  private boolean hasSomeQualityLeft(final Item item) {
    return item.getQuality() > 0;
  }

  private boolean isBelowMaximumQuality(final Item item) {
    return item.getQuality() < GildedRose.MAX_QUALITY;
  }

  private boolean isBackstagePass(final Item item) {
    return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
  }

  private boolean isLegendary(final Item item) {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }

  private boolean getsBetterWithAge(final Item item) {
    return "Aged Brie".equals(item.getName()) || isBackstagePass(item);
  }

  private void decrementQuality(final Item item) {
    item.setQuality(item.getQuality() - 1);
  }

  private void increaseQuality(final Item item, int increment) {
    int newQuality = item.getQuality() + increment;
    item.setQuality(Math.min(newQuality, GildedRose.MAX_QUALITY));
  }

  private int qualityIncrement(Item item) {
    if (isBackstagePass(item)) {
      if (item.getSellIn() <= 5) {
        return 3;
      } else if (item.getSellIn() <= 10) {
        return 2;
      }
    }
    return 1;
  }
}
