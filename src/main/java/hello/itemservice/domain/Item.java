package hello.itemservice.domain;

import lombok.Data;

@Data
public class Item {

    private Long id;

    private String itemName;
    private Integer price;
    private String quantity;

    public Item(){
    }

    public Item(String itemName, Integer price, String quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }




}
