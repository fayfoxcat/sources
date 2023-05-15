package Interview.HUAWEI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据(用于不同的调查)，希望大家能正确处理)。
 */
public class DeDuplicationSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=bf.readLine())!=null)
        {
            boolean[] stu=new boolean[1001];
            StringBuilder sb=new StringBuilder();
            int n=Integer.parseInt(str);
            for(int i=0;i<n;i++)
                stu[Integer.parseInt(bf.readLine())]=true;
            for(int i=0;i<1001;i++)
                if(stu[i])
                    sb.append(i).append("\n");
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}
