package com.internetshop.controller;

import com.internetshop.dto.CommodityDto;
import com.internetshop.dto.DtoUtilMapper;
import com.internetshop.editors.CategoriesEditor;
import com.internetshop.editors.MakerEditor;
import com.internetshop.entity.Categories;
import com.internetshop.entity.Commodity;
import com.internetshop.entity.Maker;
import com.internetshop.service.CategoriesService;
import com.internetshop.service.CommodityService;
import com.internetshop.service.MakerService;
import com.internetshop.validator.CommodityValidator.CommodityValidationMessages;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
public class CommodityController {

    @Autowired
    private CommodityService comodityService;
    @Autowired
    private MakerService makerService;
    @Autowired
    private CategoriesService categoriesService;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Maker.class, new MakerEditor());
        binder.registerCustomEditor(Categories.class, new CategoriesEditor());
    }


    @GetMapping("/Commodity")
    public String registration(Model model, @PageableDefault Pageable pageable) {
        model.addAttribute("ComComodities", comodityService.findAllPages(pageable));
        model.addAttribute("makers", makerService.findAll());
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("commodity", new Commodity());
        return "views-admin-commodity";
    }

    @PostMapping("/Commodity")
    public String registration(@ModelAttribute("computer") Commodity commodity, Model model, @RequestParam MultipartFile computerImage) {
        try {
            comodityService.save(commodity, computerImage);
        } catch (Exception e) {
            if (e.getMessage().equals(CommodityValidationMessages.EMPTY_MODEL_FIELD)
                    || e.getMessage().equals(CommodityValidationMessages.MODEL_ALREADY_EXIST)) {
                model.addAttribute("modelException", e.getMessage());
            } else if (e.getMessage().equals(CommodityValidationMessages.PRICE_MUST_BE_BIGGER_THAN_0)) {
                model.addAttribute("priceExceptio", e.getMessage());
            } else if (e.getMessage()
                    .equals(CommodityValidationMessages.NUMBER_OF_COMMODITY_MUST_BE_BIGGER_THAN_0)) {
                model.addAttribute("numberException", e.getMessage());
            }
            model.addAttribute("makers", makerService.findAll());
            model.addAttribute("categories", categoriesService.findAll());
            return "views-admin-commodity";
        }
        return "redirect:/Commodity";
    }


    @GetMapping("/deleteCommodity/{id}")
    public String deleteComputerCommodity(@PathVariable int id) {
        comodityService.delete(id);
        return "redirect:/Commodity";

    }

    @GetMapping("/updateCommodity/{id}")
    public String updateUserPage(Model model, @PathVariable int id) {
        model.addAttribute("commodityUpdate", comodityService.findOne(id));
        model.addAttribute("makers", makerService.findAll());
        model.addAttribute("categories", categoriesService.findAll());
        return "views-update-updateComputerCommodity";
    }

    @PostMapping("/updateCommodity/{id}")
    public String updateComputerCommodity(@ModelAttribute("commodityUpdate") Commodity commodity, @RequestParam MultipartFile computerImage) {
       if (computerImage.isEmpty()){
           comodityService.update(commodity);
       }else{
            comodityService.update(commodity, computerImage);
        }
        return "redirect:/Commodity";
    }
    @PostMapping("/searchCommodity")
    public @ResponseBody List<CommodityDto> search (@RequestBody String searchble){
        return DtoUtilMapper.commoditiesToDtos(comodityService.commodityByMaker(searchble));
    }

}
