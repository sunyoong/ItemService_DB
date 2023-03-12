package hello.itemservice.itemUpdateDto;

import lombok.Data;

// 상품을 수정할 때 사용하는 객체
// 기능은 없고 데이터를 전달할 때 사용하는 객체.

@Data
public class ItemUpdateDto {
    private String itemName;
    private Integer price;
    private String quantity;

    public ItemUpdateDto(){

    }

    public ItemUpdateDto(String itemName, Integer price, String quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
