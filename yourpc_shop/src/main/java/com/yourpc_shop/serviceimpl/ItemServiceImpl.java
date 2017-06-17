package com.yourpc_shop.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.yourpc_shop.validator.Validator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yourpc_shop.dao.ItemDao;
import com.yourpc_shop.entity.Item;
import com.yourpc_shop.service.ItemService;

import org.springframework.web.multipart.MultipartFile;

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

    public void add(Item item, MultipartFile multipartFile) throws Exception
    {
        validator.validate(item);
        String path = "E:\\Downloads\\apache-tomcat-8.0.43\\resources\\" +
                item.getName() + "\\" + multipartFile.getOriginalFilename();

        item.setPathImage("resources/" + item.getName() + "/" + multipartFile.getOriginalFilename());

        File file = new File(path);

        if(!file.exists())
        {
            file.mkdirs();
        }
        try
        {
            multipartFile.transferTo(file);
        }
        catch (IOException e)
        {
            System.out.println("error with file");
        }
        itemDao.save(item);
    }

    public void delete(int id)
    {
        itemDao.delete(id);
    }

    public void update(Item item, MultipartFile multipartFile)
    {
        String path = "E:\\Downloads\\apache-tomcat-8.0.43\\resources\\" +
                item.getName() + "\\" + multipartFile.getOriginalFilename();

        item.setPathImage("resources/" + item.getName() + "/" + multipartFile.getOriginalFilename());

        File file = new File(path);

        try
        {
            file.mkdirs();
            try
            {
                FileUtils.cleanDirectory
                        (new File(System.getProperty("catalina.home") + "/resources/"
                                + item.getName() + "/"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            multipartFile.transferTo(file);
        }
        catch (IOException e)
        {
            System.out.println("error with file");
        }
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

    @Override
    public Item itemWithUsers(int id)
    {
        return itemDao.itemWithUsers(id);
    }

    @Override
    public Page<Item> findAllPages(Pageable pageable)
    {
        return itemDao.findAll(pageable);
    }

    @Override
    public void update(Item item) {
        itemDao.save(item);
    }

}
