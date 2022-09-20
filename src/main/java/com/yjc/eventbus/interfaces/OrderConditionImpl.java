package com.yjc.eventbus.interfaces;

import com.alibaba.cola.statemachine.Condition;
import org.springframework.util.ObjectUtils;

import java.util.Map;


public class OrderConditionImpl implements Condition<Map> {


    @Override
    public boolean isSatisfied(Map context) {
        String id = (String) context.get("id");
        if (ObjectUtils.isEmpty(id)){
            return false;
        }
        if (id.equals("3")){
            return true;
        }
        return false;
    }


}
