package shopWork;

import productData.AdditionalMenuData;
import productData.MenuData;
import productData.OrderData;
import productData.SelectionMenuData;

public class AkamaruUdonShop extends Shop {

  AkamaruUdonShop(String shopName) {
    super(shopName);
  }

  MenuData menuData = new MenuData();
  SelectionMenuData selectionMenuData = new SelectionMenuData();
  AdditionalMenuData additionalData = new AdditionalMenuData();
  int totalFee = 0;

  @Override
  public void setMenu(){
    menuData.addData("かけ小", 300);
    menuData.addData("かけ中", 400);
    menuData.addData("かけ大", 500);
    menuData.addData("ざる小", 300);
    menuData.addData("ざる中", 400);
    menuData.addData("ざる大", 500);

    selectionMenuData.addData("かま玉", 0);
    selectionMenuData.addData("明太おろし", 0);
    selectionMenuData.addData("カレーうどん", 130);

    additionalData.addData("コロッケ", 120);
    additionalData.addData("かき揚げ", 140);
    additionalData.addData("鶏の唐揚げ", 100);
    additionalData.addData("ちくわ磯部揚げ", 110);
    additionalData.addData("おにぎり", 120);
    additionalData.addData("おいなり", 100);
  }

  @Override
  public String orderCheck(OrderData orderData) {
    //あかまるうどんの処理を記載
    System.out.println("◆◆"+shopName+"へようこそ◆◆");
    //うどんの種類を確認
    String message1 = "\r\nお好きなうどんの種類を選び、番号を入力してください\r\n";
    totalFee = checkMenuData(menuData, message1, orderData);
    if(totalFee < 0) {
      orderData.setOrderMessage("\r\nなにも注文をしなかった\r\n");
      return null;
    }else {
      orderData.setOrderMessage(shopName.concat("にて\r\n"));
    }

    //うどんのお好みを確認
    String message2 = "\r\nうどんのお好みを選び、番号を入力してください\r\n";
    totalFee += checkSelectionMenuData(selectionMenuData, message2, orderData);
    if(orderData.getOrder() !=null) {
      orderData.addOrderMessage("\r\n"+orderData.getOrder());
    }

    //追加メニューの確
    String message3 = "\r\nお好きな追加メニューを選び、番号を入力してください\r\n";
    totalFee += checkAdditionalMenuData(additionalData, message3, orderData);
    if(orderData.getOrder() !=null) {
      orderData.addOrderMessage("\r\n"+orderData.getOrder());
    }
    return orderData.getOrderMessage();
  }


  @Override
  public int doAccounting() {
    //会計
    System.out.println("\r\n◆◆  お会計  ◆◆");
    System.out.println("小計　｜" + totalFee + "円");
    int consumptionTax = (int) (totalFee * 0.08);
    System.out.println("消費税｜" + consumptionTax + "円");
    System.out.println("合計　｜" + (totalFee + consumptionTax) + "円");
    System.out.println("となります");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\r\n◆◆" + shopName + "へのご利用ありがとうございました◆◆");
    System.out.println("◆◆またのご来店をお待ちしております◆◆");
    return totalFee + consumptionTax;
  }

}
