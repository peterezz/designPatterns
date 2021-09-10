/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.RelationalCalsses.StrategyDesignPattern;

import javaapplication1.RelationalCalsses.User;

/**
 *
 * @author Peter
 */
public interface FileQueries {

    public boolean addUser(String Data);

    public boolean deleteUser(int id);

    void loadFromFile();

    boolean updateUser(int oldID, Student x);

    boolean updateUser(int oldID, Professor x);

    int getUserIndex(int id);

    public Student searchUser(int id);

    public Professor SearchUser(int id);

}
