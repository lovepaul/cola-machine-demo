package com.yjc.eventbus;

import com.alibaba.cola.statemachine.StateMachine;
import com.yjc.eventbus.events.OperaOrderEvent;
import com.yjc.eventbus.machine.OrderMachine;
import com.yjc.eventbus.status.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
public class TestController {


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String a(){
        StateMachine orderStateMachine = OrderMachine.getOrderStateMachine();
        String s = orderStateMachine.generatePlantUML();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("id","3");
        Object o = orderStateMachine.fireEvent(OrderStatus.WAIT_RECEIVE, OperaOrderEvent.USER_CLOSE, objectObjectHashMap);
        Object id = objectObjectHashMap.get("id");
        System.out.println(id.toString());
        return s;
    }
}
