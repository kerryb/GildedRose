public class DefaultQualityAdjustmentStrategy implements Strategy {

  private Item item;

  public DefaultQualityAdjustmentStrategy(final Item item) {
    this.item = item;
  }

  @Override
  public void run() {
    if (getsBetterWithAge()) {
      increaseQuality(item, qualityIncrement());
    } else {
      if (hasSomeQualityLeft()) {
        decrementQuality();
      }
    }

    if (hasExpired()) {
      if (getsBetterWithAge() && !isBackstagePass()) {
        if (isBelowMaximumQuality()) {
          increaseQuality(item, 1);
        }
      } else {
        if (!isBackstagePass() && hasSomeQualityLeft()) {
          decrementQuality();
        } else {
          item.setQuality(0);
        }
      }
    }
  }

  private boolean hasExpired() {
    return item.getSellIn() < 0;
  }

  private boolean hasSomeQualityLeft() {
    return item.getQuality() > 0;
  }

  private boolean isBelowMaximumQuality() {
    return item.getQuality() < GildedRose.MAX_QUALITY;
  }

  private boolean isBackstagePass() {
    return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
  }

  private boolean getsBetterWithAge() {
    return "Aged Brie".equals(item.getName()) || isBackstagePass();
  }

  private void decrementQuality() {
    item.setQuality(item.getQuality() - 1);
  }

  private void increaseQuality(final Item item, int increment) {
    int newQuality = item.getQuality() + increment;
    item.setQuality(Math.min(newQuality, GildedRose.MAX_QUALITY));
  }

  private int qualityIncrement() {
    if (isBackstagePass()) {
      if (item.getSellIn() <= 5) {
        return 3;
      } else if (item.getSellIn() <= 10) {
        return 2;
      }
    }
    return 1;
  }
}