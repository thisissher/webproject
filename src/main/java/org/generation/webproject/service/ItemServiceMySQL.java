package org.generation.webproject.service;

import org.generation.webproject.repository.*;
import org.generation.webproject.repository.entity.Item;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ItemServiceMySQL implements ItemService {

    //which class object is this class dependent on?
    //This ItemServiceMySQL class has to depend on another class object to perform
    // actions (e.g. save, delete, all, findItemById
    //dependent object class is the CRUDRepository class that is provided by Spring boot
    //to perform dependency injection -> access the CRUDRepository class through the
    // ItemRepository interface that we have created

    private final ItemRepository itemRepository;

    //Dependency Injection of another class object to this class object can be done with
    // @Autowired annotation
    public ItemServiceMySQL(@Autowired ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item)
    {
        return itemRepository.save(item);
    }

    @Override
    public void delete(int itemId)
    {
        itemRepository.deleteById(itemId);
    }

    @Override
    public List<Item> all()
    {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Item findById(int itemId)
    {
        Optional<Item> item = itemRepository.findById(itemId);
        Item itemResponse = item.get();
        return itemResponse;
    }
}
