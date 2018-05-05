package com.gupao.pattern.factory.func;

import com.gupao.pattern.factory.Milk;
import com.gupao.pattern.factory.Yili;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-05 9:52
 * @version:
 **/
public class YiliFactory implements Factory{

    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
