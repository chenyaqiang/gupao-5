package com.gupao.pattern.facade;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 */
public class Menu {


    public List taocanA(){
        List<String> list = new ArrayList<>();
        list.add(new Beef().toString());
        list.add(new Pork().toString());
        list.add(new Tomato().toString());
        list.add(new Potato().toString());
        return list;
    }

    public List taocanB(){
        List<String> list = new ArrayList<>();
        list.add(new Beef().toString());
        list.add(new Pork().toString());
        list.add(new Tomato().toString());
        return list;
    }

}
