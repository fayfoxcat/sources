package DesignPattern.Proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理实现InvocationHandler方法
 */
public class handler implements InvocationHandler {

    private final Object target;

    public handler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        Object result = method.invoke(target, args);
        /*增加方法：增加25 运费*/
        return (Float) result + 25;
    }
}
