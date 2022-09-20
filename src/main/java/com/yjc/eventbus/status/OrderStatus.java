package com.yjc.eventbus.status;

import com.alibaba.cola.statemachine.State;
import com.alibaba.cola.statemachine.Transition;
import com.alibaba.cola.statemachine.Visitor;
import com.alibaba.cola.statemachine.impl.TransitionType;

import java.util.Collection;
import java.util.Optional;

public enum OrderStatus implements State {
    NORMAL,
    CLOSE,
    WAIT_RECEIVE,
    ;

    @Override
    public Object getId() {
        return null;
    }

    @Override
    public Transition addTransition(Object event, State target, TransitionType transitionType) {
        return null;
    }

    @Override
    public Optional<Transition> getTransition(Object event) {
        return Optional.empty();
    }

    @Override
    public Collection<Transition> getTransitions() {
        return null;
    }

    @Override
    public String accept(Visitor visitor) {
        return null;
    }
}
