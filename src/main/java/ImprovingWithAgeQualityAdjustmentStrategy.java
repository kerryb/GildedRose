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
