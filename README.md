# gupao

## gupao-pattren 23种设计模式

##### 设计模式分为三大类
**创建型模式**，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式

**结构型模式**，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式

**行为型模式**，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式

##### 设计模式的六大原则
**1.开闭原则（Open Close Principle）**
>开闭原则就是说对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。所以一句话概括就是：为了使程序的扩展性好，易于维护和升级。

**2.里氏替换原则（Liskov Substitution Principle）**
>任何基类可以出现的地方，子类一定可以出现。里氏替换原则是继承复用的基石，只有当衍生类可以替换基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。里氏代换原则是对“开-闭”原则的补充。实现“开闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。里氏替换原则中，子类对父类的方法尽量不要重写和重载。因为父类代表了定义好的结构，通过这个规范的接口与外界交互，子类不应该随便破坏它。

**3.依赖倒转原则（Dependence Inversion Principle）**
>面向接口编程，依赖于抽象而不依赖于具体。写代码时用到具体类时，不与具体类交互，而与具体类的上层接口交互。

**4.接口隔离原则（Interface Segregation Principle）**
>每个接口中不存在子类用不到却必须实现的方法，如果有就将接口拆分，这样比使用单个接口要好。还是一个降低类之间的耦合度的意思，从这儿我们看出，其实设计模式就是一个软件的设计思想，从大型软件架构出发，为了升级和维护方便。所以上文中多次出现：降低依赖，降低耦合。

**5.迪米特法则（最少知道原则）（Demeter Principle）**
>一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。

**6.合成复用原则（Composite Reuse Principle）**
>原则是尽量使用合成/聚合的方式，而不是使用继承

##### 设计模式之间的关系图
![](http://cmsblogs.com/wp-content/uploads/2014/02/57a92d42-4d84-3aa9-a8b9-63a0b02c2c36_thumb.jpg)
