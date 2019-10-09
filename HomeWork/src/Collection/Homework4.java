package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//3)	有这样一个List<String>：{"1", "4", "4", "2", "5", "4", "7"}，
// 删除里面所有的"4"和"2",并且把"5"改为"9"。（考察点：list的删除、遍历  预计时间；40分钟）
public class Homework4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(new String[]{"1", "4", "4", "2", "5", "4", "7"}));
        list.removeAll(Arrays.asList(new String[]{"4","2"}));
        Collections.replaceAll(list,"5","9");
        System.out.println(list);
    }
}
