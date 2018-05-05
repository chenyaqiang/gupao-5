package com.gupao.pattern.factory.abstr;

import com.gupao.pattern.factory.Milk;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-05 9:55
 * @version:
 **/
public abstract class AbstractFactory {

    abstract Milk getYili();

    abstract Milk getMengniu();
}
