package Collection.Collection2;

import java.util.*;

/**
 * 7)	依次向Set中加入字符串{“1”, “42”, “24”, “2”, “5”, “16”, “7”}，删除里面数值小于5的元素，并且按照输入顺序将剩余元素打印在控制台。
 * （考察点：Set的遍历、删除  预计时间：40分钟）。Map基本操作  预计时间：80分钟）
 */
public class Homework3
{
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        String data = "“1”, “42”, “24”, “2”, “5”, “16”, “7”";
        data = data.replaceAll("“","");
        data = data.replaceAll("”","");
        String[] spiltdata = data.split(", ");
        for(String temp:spiltdata)
        {
            set.add(Integer.parseInt(temp));
        }
        Iterator<Integer> it = set.iterator();


        while (it.hasNext())
        {
            int temp = it.next();
            if((temp<5))
            {
                /**
                 * 触发ConcurrentMODificationException
                 */
                //set.remove(temp);

                it.remove();
            }
        }
        it= set.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }


    }

}
