package com.gupao.pattern.strategy.pay;

import com.gupao.pattern.strategy.PayState;

public interface Payment {

    PayState pay(String uid, double amount);
}
