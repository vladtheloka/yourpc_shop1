package com.internetshop.service;

import java.security.Principal;
import java.util.List;

import com.internetshop.entity.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface CommodityService {
	void save(Commodity commodity, MultipartFile computerImage) throws Exception;

	List<Commodity> findAll();

	Commodity findOne(int id);

	void delete(int id);

	void update(Commodity commodity);

	void update(Commodity commodity, MultipartFile computerImage);

	Commodity CommodityWithUser(int id);

	Page<Commodity> findAllPages(Pageable pageable);

	void addToBucket(Principal principal, int id);

	void deleteFromBucket(int userId, int comCommodityId);

	List<Commodity> commodityByMaker(String search);
}
