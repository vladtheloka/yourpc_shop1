package com.yourpc_shop.validator.billable;

import com.yourpc_shop.dao.BillableDao;
import com.yourpc_shop.entity.Billable;
import com.yourpc_shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillableValidator implements Validator
{
    private final BillableDao billableDao;

    @Autowired
    public BillableValidator(BillableDao billableDao)
    {
        this.billableDao = billableDao;
    }

    @Override
    public void validate(Object o) throws Exception
    {
        Billable billable = (Billable) o;

        if(billable.getName().isEmpty())
        {
            throw new BillableException(BillableValidationMessages.EMPTY_NAME_FIELD);
        }

        else if(billableDao.findByName(billable.getName()) != null)
        {
            throw new BillableException(BillableValidationMessages.BILLABLENAME_ALREADY_EXIST);
        }
    }
}