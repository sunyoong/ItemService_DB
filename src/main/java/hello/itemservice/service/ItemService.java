package hello.itemservice.service;

import hello.itemservice.domain.Item;
import hello.itemservice.itemSearchCond.ItemSearchCond;
import hello.itemservice.itemUpdateDto.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long id, ItemUpdateDto itemUpdateDto);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearchCond);


}
