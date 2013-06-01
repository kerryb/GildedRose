public class BackstagePassQualityAdjustmentStrategy implements Strategy {
  private Item item;

  public BackstagePassQualityAdjustmentStrategy(final Item item) {
    this.item = item;
  }

  @Override
  public void run() {
    if (hasExpired()) {
      item.setQuality(0);
    } else {
      int newQuality = item.getQuality() + qualityIncrement();
      item.setQuality(Math.min(newQuality, GildedRose.MAX_QUALITY));
    }
  }

  private boolean hasExpired() {
    return item.getSellIn() <= 0;
  }

  private int qualityIncrement() {
    if (item.getSellIn() <= 5) {
      return 3;
    } else if (item.getSellIn() <= 10) {
      return 2;
    } else {
      return 1;
    }
  }
}