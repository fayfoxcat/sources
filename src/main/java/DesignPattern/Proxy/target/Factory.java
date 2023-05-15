package DesignPattern.Proxy.target;

import DesignPattern.Proxy.method.Operating;

/**
 * 目标对象：被代理对象
 */
public class Factory implements Operating {

    @Override
    public float Sales(int amount) {
        return amount * 100;
    }

    @Override
    public void afterSale() {
        System.out.println("激活订单售后！");
    }
}
