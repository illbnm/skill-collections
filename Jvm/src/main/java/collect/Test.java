package collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: dongmengyang
 */
public class Test {

    public static void main(String[] args) {



        //底层使用静态内部私有类  元素个数固定,可更改,但是不能增加或者删除.会抛异常,因为使用的AbstractList的add
        List<String> list2 = Arrays.asList();
        list2.add("test2");
        // 使用场景if或者else逻辑的情况下需要返回空list的时候
        // 如果直接使用new ArrayList 会有对象的创建
        // Collections.emptyList() 无序进行对象创建
        // 也不推荐使用Arrays.asList() 中间或有 new
        // (考虑极致性能)
        List<String> list = Collections.emptyList();
        list.add("test");

        //调用过clear()方法,需要对list重用,可以直接使用,以为size没有删除


        // batchRemove 双指针
        

    }

}
