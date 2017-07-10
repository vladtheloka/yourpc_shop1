package com.internetshop.serviseImpl;

import java.util.List;

import com.internetshop.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.internetshop.dao.CommodityDao;
import com.internetshop.dao.MakerDao;
import com.internetshop.entity.Maker;
import com.internetshop.service.MakerService;
import com.internetshop.validator.Validator;


@Service
public class MakerServiceImpl implements MakerService {
	@Autowired
	private MakerDao makerDao;
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	@Qualifier("makerValidator")
	private Validator validator;

	public void save(Maker maker) throws Exception {
		validator.validate(maker);
		makerDao.save(maker);
	}

	public List<Maker> findAll() {

		return makerDao.findAll();
	}

	public Maker findOne(int id) {

		return makerDao.findOne(id);
	}

	public void delete(int id) {
		Maker maker = makerDao.makerWithComCommodity(id);

		for (Commodity commodity : maker.getCommodities()) {
			commodity.setMaker(null);
			commodityDao.saveAndFlush(commodity);
		}

		makerDao.delete(id);
	}

	public void update(Maker maker) {
		makerDao.save(maker);
	}

}
