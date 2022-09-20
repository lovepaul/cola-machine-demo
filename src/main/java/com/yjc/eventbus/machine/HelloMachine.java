package com.yjc.eventbus.machine;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.yjc.eventbus.events.OperaOrderEvent;
import com.yjc.eventbus.interfaces.OrderConditionImpl;
import com.yjc.eventbus.status.OrderStatus;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class HelloMachine {

    public StateMachine test1() {

        StateMachineBuilder<OrderStatus, OperaOrderEvent, Map> builder = StateMachineBuilderFactory.create();
        builder.internalTransition()
                .within(OrderStatus.NORMAL)
                .on(OperaOrderEvent.CREATE)
                .perform(action1());

        builder.externalTransition()
                .from(OrderStatus.NORMAL)
                .to(OrderStatus.CLOSE)
                .on(OperaOrderEvent.ADMIN_CLOSE)
                .perform(action1());

        builder.externalTransition()
                .from(OrderStatus.NORMAL)
                .to(OrderStatus.WAIT_RECEIVE)
                .on(OperaOrderEvent.ADMIN_PUSH)
                .perform(action1());

        builder.externalTransition()
                .from(OrderStatus.NORMAL)
                .to(OrderStatus.WAIT_RECEIVE)
                .on(OperaOrderEvent.AUTO_PUSH)
                .perform(action1());

        builder.externalTransition()
                .from(OrderStatus.WAIT_RECEIVE)
                .to(OrderStatus.CLOSE)
                .on(OperaOrderEvent.ADMIN_CLOSE)
                .perform(action1());

        builder.externalTransition()
                .from(OrderStatus.WAIT_RECEIVE)
                .to(OrderStatus.CLOSE)
                .on(OperaOrderEvent.USER_CLOSE)
                .when(new OrderConditionImpl())
                .perform(action1());


        StateMachine<OrderStatus, OperaOrderEvent, Map> stateMachine = builder.build("333" + "2");
        return stateMachine;
    }

    public Action<OrderStatus, OperaOrderEvent, Map> action1() {

        return (from, to, event, ctx) -> {
            System.out.println(" from:" + from + " to:" + to + " on:" + event);
            ctx.put("result", "4");
        };

    }


}
