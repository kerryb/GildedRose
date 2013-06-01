package org.kerryb.gildedrose;

import java.util.ArrayList;
import java.util.List;

import org.kerryb.gildedrose.items.Item;
import org.kerryb.gildedrose.items.UpdatableItem;

public class GildedRose {
  public static final int MAX_QUALITY = 50;

  static List<Item> items = null;

  public static void main(String[] args) {
    System.out.println("OMGHAI!");

    items = new ArrayList<Item>();
    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));

    updateQuality();
  }

  public static void updateQuality() {
    for (Item item : items) {
      UpdatableItem.forItem(item).update();
    }
  }
}