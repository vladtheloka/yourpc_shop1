package com.internetshop.serviseImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.internetshop.dao.CountryDao;
import com.internetshop.dao.MakerDao;
import com.internetshop.entity.Country;
import com.internetshop.entity.Maker;
import com.internetshop.service.CountryService;
import com.internetshop.validator.Validator;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private MakerDao makerDao;
	@Autowired
	@Qualifier("countryValidator")
	private Validator countryValidator;

	public void save(Country country, MultipartFile countryImage) throws Exception {
		countryValidator.validate(country);
		countryDao.saveAndFlush(country);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ country.getName() + "/" + countryImage.getOriginalFilename();

		country.setPathImage("resources/" + country.getName() + "/" + countryImage.getOriginalFilename());

		File filePath = new File(path);

		try {
			filePath.mkdirs();
			countryImage.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}

		countryDao.save(country);
	}

	public List<Country> findAll() {

		return countryDao.findAll();
	}

	public Country findOne(int id) {

		return countryDao.findOne(id);
	}

	public void delete(int id) {
		Country country = countryDao.countryWithMakers(id);
		
		for (Maker maker : country.getMakers()) {

			maker.setCountry(null);
			makerDao.saveAndFlush(maker);

		}

		countryDao.delete(id);
	}

	public void update(Country country) {
		countryDao.save(country);
	}

}
