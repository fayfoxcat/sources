package DesignPattern.Generic.Method;

import DesignPattern.Generic.api.Plant;

public class Method {

    public static <T extends Plant<? super T>> void methodA(T args){

    }

    public static <T extends Plant<T>> void methodB(T args){

    }
}
