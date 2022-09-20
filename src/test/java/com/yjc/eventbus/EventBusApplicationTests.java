package com.yjc.eventbus;

import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.yjc.eventbus.events.OperaOrderEvent;
import com.yjc.eventbus.machine.HelloMachine;
import com.yjc.eventbus.status.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class EventBusApplicationTests {

	@Autowired
	HelloMachine helloMachine;

	@Test
	void contextLoads() {
		StateMachine stateMachine = helloMachine.test1();

		String s = stateMachine.generatePlantUML();
		System.out.println(s);
		HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
		Object o = stateMachine.fireEvent(OrderStatus.NORMAL, OperaOrderEvent.AUTO_PUSH, objectObjectHashMap);
		stateMachine.generatePlantUML();

	}

	@Test
	void contextLoads2() {
		StateMachine stateMachine = helloMachine.test1();

		String s = stateMachine.generatePlantUML();
		System.out.println(s);
		HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
		objectObjectHashMap.put("id","3");
		Object o = stateMachine.fireEvent(OrderStatus.WAIT_RECEIVE, OperaOrderEvent.USER_CLOSE, objectObjectHashMap);
		Object id = objectObjectHashMap.get("id");
		System.out.println(id.toString());

	}


}
