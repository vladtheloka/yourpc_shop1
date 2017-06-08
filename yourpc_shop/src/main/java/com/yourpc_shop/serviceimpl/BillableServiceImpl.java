package com.yourpc_shop.serviceimpl;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.yourpc_shop.dao.ItemDao;
import com.yourpc_shop.dao.UserDao;
import com.yourpc_shop.entity.User;
import com.yourpc_shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.yourpc_shop.dao.BillableDao;
import com.yourpc_shop.entity.Billable;
import com.yourpc_shop.entity.Item;
import com.yourpc_shop.service.BillableService;

@Service
public class BillableServiceImpl implements BillableService
{
    private final BillableDao billableDao;

    private final UserDao userDao;

    private final ItemDao itemDao;

    @Autowired
    public BillableServiceImpl(BillableDao billableDao, UserDao userDao, ItemDao itemDao)
    {
        this.billableDao = billableDao;
        this.userDao = userDao;
        this.itemDao = itemDao;
    }

    public void add(Billable billable)
    {
        billableDao.save(billable);
    }

    public void delete(int id)
    {
        billableDao.delete(id);
    }

    public void update(Billable billable)
    {
        billableDao.save(billable);
    }

    public Billable getOne(int id)
    {
        return billableDao.findOne(id);
    }

    public List<Billable> getAll()
    {
        return billableDao.findAll();
    }

    public Set<Billable> getBillableWithItems()
    {
        return billableDao.getBillableWithItems();
    }

    @Override
    public void addToCart(Principal principal, int id)
    {
        User user = userDao.userWithItems(Integer.parseInt(principal.getName()));
        Item item = itemDao.getOne(id);
        user.getItems().add(item);
        userDao.save(user);
    }

    @Override
    public void deleteFromCart(int userId, int itemId)
    {
        User user = userDao.userWithItems(userId);
        Item item = itemDao.itemWithUsers(itemId);
        user.getItems().remove(item);
        userDao.save(user);
    }

    @Override
    public void buy(int userId)
    {
        Billable billable = new Billable(LocalDateTime.now());
        billableDao.saveAndFlush(billable);
        User user = userDao.userWithItems(userId);
        billable.setUser(user);
        for (Item item: user.getItems())
        {
            billable.getItem().add(item);
            billableDao.save(billable);
        }

        user.getItems().clear();
        userDao.save(user);
    }
}