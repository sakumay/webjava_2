import java.util.ArrayList;

abstract class ItemData {

  ArrayList<String> itemNames = new ArrayList<String>();
  ArrayList<Integer> itemPrices = new ArrayList<Integer>();

  protected void addData(String name,int price) {
    itemNames.add(name);
    itemPrices.add(price);
  }

  protected String getName(int number) {
    return itemNames.get(number);
  }

  protected int getPrice(int number) {
    return itemPrices.get(number);
  }

  protected int getSize() {
    return itemNames.size();

  }
}
