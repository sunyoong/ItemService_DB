package hello.itemservice.repository.memory;

import hello.itemservice.domain.Item;
import hello.itemservice.itemSearchCond.ItemSearchCond;
import hello.itemservice.itemUpdateDto.ItemUpdateDto;
import hello.itemservice.repository.ItemRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemoryItemRepository implements ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = findById(itemId).orElseThrow();
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    // Optional 을 반환해야 하기 때문에 ofNullarble 사용
    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // ItmeSearchCond 검색 조건을 받아서 내부에서 데이터를 검색하는 기능 == db where 절
    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        // itemName이나 maxPrice 가 null 또는 비었으면 해당 조건을 무시.
        // 값이 있을 때만 필터링 한 후 검색.
        return store.values().stream()
                .filter(item -> {
                    if (ObjectUtils.isEmpty(itemName)) {
                        return true;
                    }
                    return item.getItemName().contains(itemName);
                }).filter(item -> {
                    if (maxPrice == null) {
                        return true;
                    }
                    return item.getPrice() <= maxPrice;
                })
                .collect(Collectors.toList());
    }

    // 메모리에 저장된 item 을 모두 삭제해서 초기화함. (테스트 용도로 사용)
    public void clearStore(){
        store.clear();
    }

}
