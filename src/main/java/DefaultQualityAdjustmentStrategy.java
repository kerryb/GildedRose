public class DefaultQualityAdjustmentStrategy implements Strategy {
  private Item item;

  public DefaultQualityAdjustmentStrategy(final Item item) {
    this.item = item;
  }

  @Override
  public void run() {
    item.setQuality(Math.max(item.getQuality() - decrement(), 0));
  }

  private int decrement() {
    if (hasExpired()) {
      return 2;
    } else {
      return 1;
    }
  }

  private boolean hasExpired() {
    return item.getSellIn() < 0;
  }
}