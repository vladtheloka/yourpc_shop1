package com.yourpc_shop.serviceimpl;

import java.util.List;

import com.yourpc_shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc_shop.dao.ItemDao;
import com.yourpc_shop.entity.Item;
import com.yourpc_shop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService
{
    private final ItemDao itemDao;

    private final Validator validator;

    @Autowired
    public ItemServiceImpl(ItemDao itemDao, @Qualifier("itemValidator") Validator validator)
    {
        this.itemDao = itemDao;
        this.validator = validator;
    }

    public void add(Item item) throws Exception
    {
        validator.validate(item);
        itemDao.save(item);
    }

    public void delete(int id)
    {
        itemDao.delete(id);
    }

    public void update(Item item)
    {
        itemDao.save(item);
    }

    public Item getOne(int id)
    {
        return itemDao.findOne(id);
    }

    public List<Item> getAll()
    {
        return itemDao.findAll();
    }
}
