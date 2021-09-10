/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.RelationalCalsses.ObserverDesignPattern;

/**
 *
 * @author Peter
 */
public interface Subject {
    void subscribe(observer Observer);
    void unsubscribe(observer Observer);
    void notifyAllSubscribers();
}
