package Collection.Collection2;

import java.util.Vector;

/**
 * 5)	使用冒泡排序Vector<String>：{“1”, “4”, “64”, “2”, “35”, “4”, “7”}排序
 * 冒泡排序法使用的方法是交换排序。其基本思路是：对数组中尚未排序的各元素，依次比较相邻的两个元素的大小，若前面的元素大于后面的元素，就交换这两元素，经过第一轮比较排序后，便可把最小的元素排好。然后再用同样的方法把剩下的元素逐个进行比较，就可排好数组各元素的顺序。
 * (考察点：Vector基本操作  预计时间：60分钟) 。
 */
public class Homework2 {
    public static void main(String[] args) {
        String data = "“1”, “4”, “64”, “2”, “35”, “4”, “7”";
        data = data.replaceAll("“","");
        data = data.replaceAll("”","");
        String[] spiltdata = data.split(", ");
        Vector<Integer> ve =new Vector<>();
        for(String temp:spiltdata)
        {
            ve.add(Integer.parseInt(temp));
        }
        sort(ve);
        System.out.println(ve);


    }

    public static void sort(Vector<Integer> ve)
    {
        for(int i = 0;i<ve.size();i++)
        {
            for(int j  =i+1;j<ve.size();j++)
            {
                if(ve.get(i)>ve.get(j))
                {
                    int temp = ve.get(i);
                    ve.set(i,ve.get(j));
                    ve.set(j,temp);
                }
            }
        }
    }


}
