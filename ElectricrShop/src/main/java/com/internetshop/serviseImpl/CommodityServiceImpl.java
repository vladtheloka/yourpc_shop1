package com.internetshop.serviseImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import com.internetshop.dao.UserDao;
import com.internetshop.entity.Commodity;
import com.internetshop.entity.User;
import com.internetshop.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.internetshop.dao.CommodityDao;

import com.internetshop.validator.Validator;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommodityServiceImpl implements CommodityService {
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	@Qualifier("commodityValidator")
	private Validator computerCommodityValidator;
	@Autowired
	private UserDao userDao;
	

	public void save(Commodity commodity, MultipartFile computerImage) throws Exception {
		computerCommodityValidator.validate(commodity);
		commodityDao.saveAndFlush(commodity);
		String path = System.getProperty("catalina.home") + "/resources/"
				+ commodity.getModel() + "/" + computerImage.getOriginalFilename();
		commodity.setComputerPathImage("resources/" + commodity.getModel() + "/" + computerImage.getOriginalFilename());
		File filePath = new File(path);

		try {
			filePath.mkdirs();
			computerImage.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}

		commodityDao.save(commodity);
	}

	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	public Commodity findOne(int id) {
		
		return commodityDao.findOne(id);
	}

	public void delete(int id) {
	commodityDao.delete(id);
	}

	public void update(Commodity commodity, MultipartFile computerImage) {
		commodityDao.saveAndFlush(commodity);
		String path = System.getProperty("catalina.home") + "/resources/"
				+ commodity.getModel() + "/" + computerImage.getOriginalFilename();
		commodity.setComputerPathImage("resources/" + commodity.getModel() + "/" + computerImage.getOriginalFilename());
		File filePath = new File(path);

		try {
			filePath.mkdirs();
			computerImage.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	commodityDao.save(commodity);
	}

	@Override
	public Page<Commodity> findAllPages(Pageable pageable) {
		return commodityDao.findAll(pageable);
	}

	@Override
	public Commodity CommodityWithUser(int id) {
		return commodityDao.comCommodityWithUser(id);
	}

	@Override
	public void addToBucket(Principal principal, int id) {
		User user = userDao.userWithCommputerCommodities(Integer.parseInt(principal.getName()));
		Commodity commodity = commodityDao.getOne(id);
		user.getCommodities().add(commodity);
		userDao.save(user);
	}

	@Override
	public void deleteFromBucket(int userId, int comCommodityId) {
		User user = userDao.userWithCommputerCommodities(userId);
		Commodity commodity = commodityDao.comCommodityWithUser(comCommodityId);
		user.getCommodities().remove(commodity);
		userDao.save(user);
	}

	@Override
	public void update(Commodity commodity) {
		commodityDao.saveAndFlush(commodity);
	}

	@Override
	public List<Commodity> commodityByMaker(String search) {

		return commodityDao.commodityByMaker(search);
	}
}
