package Collection;

import java.util.*;

//2)	判断一个List<String>是否含有相同元素。提示：可以有两种方法实现。
//（考察点：list的常用方法、遍历  预计时间：40分钟）
public class Homework3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList(new String[]{"1","2"}));
        if(chongfu(list))
        {
            System.out.println("重复了");
        }
        else {
            System.out.println("没重复");
        }
    }



    public static boolean chongfu(List<String> list)
    {
        HashSet<String>  hs =new HashSet<>();
        Iterator<String> it = list.iterator();
        while(it.hasNext())
        {
            if(!hs.add(it.next()))
            {
                return true;
            }
        }
        return false;
    }
}
