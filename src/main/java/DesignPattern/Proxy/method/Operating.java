package DesignPattern.Proxy.method;

/**
 * 操作类
 */
public  interface Operating {

    /*销售方法*/
    float Sales(int amount);

    /*售后方法*/
    void afterSale();
}
