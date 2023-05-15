package DesignPattern.Proxy.statical;

import DesignPattern.Proxy.method.Operating;

/**
 * 代理对象：淘宝天猫
 */
public class Taobao implements Operating {

    @Override
    public float Sales(int amount) {
        return 0;
    }

    @Override
    public void afterSale() {

    }
}
