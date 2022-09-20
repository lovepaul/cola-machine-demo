package com.yjc.eventbus;

import com.alibaba.cola.statemachine.StateMachine;
import com.yjc.eventbus.events.OperaOrderEvent;
import com.yjc.eventbus.machine.OrderMachine;
import com.yjc.eventbus.status.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class EventBusApplicationTests {

	@Autowired
	OrderMachine helloMachine;

	@Test
	void contextLoads() {
		StateMachine orderStateMachine = OrderMachine.getOrderStateMachine();
		String s = orderStateMachine.generatePlantUML();
		System.out.println(s);

	}

	@Test
	void contextLoads2() {
		StateMachine helloMachine = OrderMachine.getOrderStateMachine();
		String s = helloMachine.generatePlantUML();
		System.out.println(s);
		HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
		objectObjectHashMap.put("id","3");
		Object o = helloMachine.fireEvent(OrderStatus.WAIT_RECEIVE, OperaOrderEvent.USER_CLOSE, objectObjectHashMap);
		Object id = objectObjectHashMap.get("id");
		System.out.println(id.toString());

	}


}
