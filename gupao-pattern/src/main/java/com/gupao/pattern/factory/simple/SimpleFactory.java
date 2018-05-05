package com.gupao.pattern.factory.simple;

import com.gupao.pattern.factory.Mengniu;
import com.gupao.pattern.factory.Milk;
import com.gupao.pattern.factory.Yili;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-05 9:44
 * @version:
 **/
public class SimpleFactory {

    public Milk getMilk(String name) {
        if ("蒙牛".equals(name)) {
            return new Mengniu();
        } else if ("伊利".equals(name)) {
            return new Yili();
        } else {
            System.out.println("不能生产您所需的产品");
            return null;
        }
    }
}
