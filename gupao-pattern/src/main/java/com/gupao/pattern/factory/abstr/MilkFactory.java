package com.gupao.pattern.factory.abstr;

import com.gupao.pattern.factory.Mengniu;
import com.gupao.pattern.factory.Milk;
import com.gupao.pattern.factory.Yili;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-05 9:59
 * @version:
 **/
public class MilkFactory extends AbstractFactory {

    @Override
    Milk getYili() {
        return new Yili();
    }

    @Override
    Milk getMengniu() {
        return new Mengniu();
    }
}
