package hello.itemservice.repository;

import hello.itemservice.domain.Item;
import hello.itemservice.itemSearchCond.ItemSearchCond;
import hello.itemservice.itemUpdateDto.ItemUpdateDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond cond);
}
