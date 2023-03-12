package hello.itemservice.controller;

import hello.itemservice.domain.Item;
import hello.itemservice.service.ItemService;
import hello.itemservice.itemSearchCond.ItemSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public String items(@ModelAttribute("itemSearch")ItemSearchCond itemSearchCond, Model model){
       List<Item> items = itemService.findItems(itemSearchCond);
       model.addAttribute("items", items);
       return "items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model){
        Item item = itemService.findById(itemId).get();
        model.addAttribute("item", item);
        return "item";
    }

    @GetMapping("add")
    public String addForm(){
        return "addForm";
    }

    @PostMapping("add")
    public String addItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes){
        Item savedItem = itemService.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/items/${itemId}";
    }




}
