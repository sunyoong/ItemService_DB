package hello.itemservice.service;

import hello.itemservice.domain.Item;
import hello.itemservice.itemSearchCond.ItemSearchCond;
import hello.itemservice.itemUpdateDto.ItemUpdateDto;
import hello.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService1 implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void update(Long id, ItemUpdateDto itemUpdateDto) {
        itemRepository.update(id, itemUpdateDto);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findItems(ItemSearchCond itemSearchCond) {
        return itemRepository.findAll(itemSearchCond);
    }
}
