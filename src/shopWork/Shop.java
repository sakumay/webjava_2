package shopWork;

import java.util.Scanner;
import productData.AdditionalMenuData;
import productData.MenuData;
import productData.OrderData;
import productData.SelectionMenuData;

public abstract class Shop {

  private static int totalFee;
  protected String shopName;

  Shop(String shopName) {
    this.shopName = shopName;
  }

  public abstract void setMenu();

  public abstract String orderCheck(OrderData orderData);

  public abstract int doAccounting();

  public int checkMenuData(MenuData menuData,String message, OrderData orderData){
    boolean errorMassageFlg = false;
    boolean continueFlg = true;
    int fee = 0;
    while (continueFlg) {
      System.out.println(message);
      SelectItemPrice selectItem = new SelectItemPrice();
      if(selectItem.select(menuData,errorMassageFlg)) {
        if(selectItem.getPrice() < 0) {
          return selectItem.getPrice();
        }else {
          fee = selectItem.getPrice();
          if(selectItem.getNeme() != null) {
            orderData.setOrder(selectItem.getNeme());
          }
          continueFlg = false;
        }
      }else {
        errorMassageFlg = true;
      }
    }
    return fee;
  }

  public int checkSelectionMenuData(SelectionMenuData selectionMenuData, String message, OrderData orderData){
    boolean errorMassageFlg = false;
    boolean continueFlg = true;
    int fee = 0;

    orderData.setOrder(null);

    while (continueFlg) {
      System.out.println("\r\nお好きなセットメニューを選び、番号を入力してください\r\n");

      SelectItemPrice selectItem = new SelectItemPrice();
      if(selectItem.select(selectionMenuData,errorMassageFlg)) {
        if(selectItem.getPrice() < 0) {
          continueFlg = false;
        }else {
          fee += selectItem.getPrice();
          if(selectItem.getNeme() != null) {
            if(orderData.getOrder() != null) {
              orderData.setOrder(orderData.getOrder().concat(","));
              orderData.setOrder(orderData.getOrder().concat(selectItem.getNeme()));
            }else {
              orderData.setOrder(selectItem.getNeme());
            }
          }
          continueFlg = false;
        }
      }else {
        errorMassageFlg = true;
      }
    }
    return fee;
  }

  public int checkAdditionalMenuData(AdditionalMenuData additionalData, String message, OrderData orderData){
    boolean errorMassageFlg = false;
    boolean continueFlg = true;
    int fee = 0;

    orderData.setOrder(null);

    while (continueFlg) {
      System.out.println("\r\nお好きなセットメニューを選び、番号を入力してください\r\n");

      SelectItemPrice selectItem = new SelectItemPrice();
      if(selectItem.select(additionalData,errorMassageFlg)) {
        if(selectItem.getPrice() < 0) {
          continueFlg = false;
        }else {
          fee += selectItem.getPrice();
          if(selectItem.getNeme() != null) {
            if(orderData.getOrder() != null) {
              orderData.setOrder(orderData.getOrder().concat(","));
              orderData.setOrder(orderData.getOrder().concat(selectItem.getNeme()));
            }else {
              orderData.setOrder(selectItem.getNeme());
            }
          }
        }
      }else {
        errorMassageFlg = true;
      }
    }
    return fee;
  }

  public String getInputData() {
    Scanner scan = new Scanner(System.in);
    String input = scan.next();

    if (input.isEmpty()) {
      input = "b";
    }
    return input;
  }

}
