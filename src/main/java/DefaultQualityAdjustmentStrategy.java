public class DefaultQualityAdjustmentStrategy implements Strategy {
  private Item item;

  public DefaultQualityAdjustmentStrategy(final Item item) {
    this.item = item;
  }

  @Override
  public void run() {
    if (hasSomeQualityLeft()) {
      decrementQuality();
    }

    if (hasExpired()) {
      if (hasSomeQualityLeft()) {
        decrementQuality();
      } else {
        item.setQuality(0);
      }
    }
  }

  private boolean hasExpired() {
    return item.getSellIn() < 0;
  }

  private boolean hasSomeQualityLeft() {
    return item.getQuality() > 0;
  }

  private void decrementQuality() {
    item.setQuality(item.getQuality() - 1);
  }
}