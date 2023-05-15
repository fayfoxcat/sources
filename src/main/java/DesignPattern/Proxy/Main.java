package DesignPattern.Proxy;

import DesignPattern.Proxy.dynamic.handler;
import DesignPattern.Proxy.method.Operating;
import DesignPattern.Proxy.target.Factory;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        /*目标对象实现的接口*/
        Class[] interfaces = { Operating.class};

        /*目标对象*/
        Factory factory = new Factory();

        /*获取动态代理对象*/
        Operating business = (Operating)Proxy.newProxyInstance( handler.class.getClassLoader(), interfaces, new handler(factory));

        /*执行动态代理方法*/
        float price = business.Sales(5);
        System.out.println(price);
        business.afterSale();

    }
}
