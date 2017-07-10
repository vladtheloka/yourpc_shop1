package com.internetshop.dto;

import com.internetshop.entity.Categories;
import com.internetshop.entity.Commodity;
import com.internetshop.entity.Maker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 24.06.2017.
 */
public class DtoUtilMapper {

    public static List<CategoriesDto> categoriesToDtos(List<Categories> categories) {
        List<CategoriesDto> categoriesDtos = new ArrayList<>();

        for (Categories categories1: categories) {
            CategoriesDto categoriesDto = new CategoriesDto();
            categoriesDto.setId(categories1.getId());
            categoriesDto.setName(categories1.getName());
            categoriesDtos.add(categoriesDto);
        }

    return categoriesDtos;
    }
/*SEARCH*/
    public static Categories categories (Categories categories){
        return new Categories(categories.getName());
    }
    public static Maker maker (Maker maker){
        return new Maker(maker.getName());
    }



    public static CommodityDto commodityDto (Commodity commodity){
        return new CommodityDto(commodity.getId(),maker(commodity.getMaker()),commodity.getComputerPathImage(),categories(commodity.getCategories()),
                commodity.getModel(),commodity.getPrice());
    }


    public static List<CommodityDto> commoditiesToDtos(List<Commodity> commodities){
        List<CommodityDto> commodityDtos = new ArrayList<>();
        for (Commodity commodity: commodities
             ) {
            CommodityDto commodityDto = commodityDto(commodity);
            commodityDtos.add(commodityDto);
        }


        return commodityDtos;
    }
/*SEARCH*/

}






