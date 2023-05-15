package Interview.HUAWEI;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String next = scanner.next().toLowerCase();
            String[] split = next.split("");
            for (String str:split){
                for(String s:split){
                    if (str<s){

                    }else{
                        continue;
                    }
                }
            }
        }*/
        List<Object> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            int value = scanner.nextInt();
        String[] split = next.split(",");
            for (String str:split){
                if (str.contains("-")){
                    String[] range = str.split("-");
                    for (int i = Integer.parseInt(range[0]);i<Integer.parseInt(range[1]);i++) {
                        if (i==value&&i==Integer.parseInt(range[0])&&Integer.parseInt(range[0])+1==Integer.parseInt(range[1])){
                            list.add((i+1)+"-"+Integer.parseInt(range[1]));
                            break;
                        }else if(i==value&&i==Integer.parseInt(range[1])&&Integer.parseInt(range[0])+1==Integer.parseInt(range[1])){
                            list.add(Integer.parseInt(range[0])+"-"+(i-1));
                            break;
                        }else if(i==value&&i!=Integer.parseInt(range[0])&&i!=Integer.parseInt(range[1])){
                            list.add(Integer.parseInt(range[0])+"-"+(i-1));
                            list.add((i+1)+"-"+Integer.parseInt(range[1]));
                            break;
                        }
                    }
                    list.add(Integer.parseInt(range[0])+"-"+Integer.parseInt(range[1]));
                }else{
                    list.add(str);
                }
            }

            System.out.println(list);

    }
}
