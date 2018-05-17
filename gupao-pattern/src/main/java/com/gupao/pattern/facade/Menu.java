package com.gupao.pattern.facade;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 */
public class Menu {

    private List<String> list = new ArrayList<>();


    public List twoMeetTwoVegetable(){
        list.add(new Beef().toString());
        list.add(new Pork().toString());
        list.add(new Tomato().toString());
        list.add(new Potato().toString());
        return list;

    }

    public List twoMeetOneVegetable(){
        list.add(new Beef().toString());
        list.add(new Pork().toString());
        list.add(new Tomato().toString());
        return list;
    }
}
