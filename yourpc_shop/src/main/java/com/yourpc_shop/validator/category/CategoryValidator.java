package com.yourpc_shop.validator.category;

import com.yourpc_shop.entity.Category;
import com.yourpc_shop.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class CategoryValidator implements Validator
{
    @Override
    public void validate(Object o) throws Exception
    {
        Category category = (Category) o;

        if(category.getName().isEmpty())
        {
            throw new CategoryException(CategoryValidationMessages.EMPTY_CATEGORY_FIELD);
        }
    }
}
