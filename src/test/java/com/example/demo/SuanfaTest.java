package com.example.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

import org.junit.jupiter.api.Test;


public class SuanfaTest extends BaseTest{

    //朱亮
    
    @Test
    void isValid() {
        String s = "({})";
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (length != s.length());
        boolean isValid = s.length() == 0;
        System.out.println(isValid);
    }
    
    @Test
    void isValid2() {
        String s = "(}){";
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parentMap = new HashMap<>();
        parentMap.put(')', '(');
        parentMap.put('}', '{');
        parentMap.put(']', '[');
        boolean isValid = true;
        char[] array = s.toCharArray();
         for (char c : array) {
            if (!parentMap.containsKey(c)) {
                stack.push(c);
            }else if(stack.isEmpty() || !Objects.equals(stack.pop(), parentMap.get(c))){
                isValid = false;
                break;
            }
        }
       isValid = isValid ? stack.isEmpty() : isValid;
       System.err.println(isValid);
    }
    
    
    @Test
    public void getPerson(){
        
        int number = 7;
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=1;i<=number;i++){
        list.add(i);
        }
        while(list.size()!=0){
        System.out.print(list.element()+" ");//输出第一个元素，其实就是报数为1的人
        if(list.size()==1) break;//如果链表大小为1，退出循环，如果为1了，接下来就不能执行下面的两个删除了
        list.removeFirst();//出列了，把它删除
        list.addLast(list.element());//删除了第一个，报数为2的人变为列表第一个，加入到列表最后，实际上也就是移到最后了
        list.removeFirst();//已经把它加到最后了，这里删除它
        }
    }
    
    static class Parent{
        static {
            System.out.println(1);
        }
        {
            System.out.println(2);
        }
        public Parent() {
            System.out.println(3);
        }
    }
    static class Parent2 extends Parent{
        static {
            System.out.println(4);
        }
        public Parent2() {
            System.out.println(6);
        }
        {
            System.out.println(5);
        }
    }
    
    @Test
    public void getPerson3(){
        new Parent2();
    }
    @Test
    public void getPerson9(){
            // TODO Auto-generated method stub
              List<String> math = new LinkedList<>();
              math.add("1");
              math.add("2");
              math.add("3");
              math.add("4");
              math.add("5");
            //  math.add("6");
            //  math.add("7");
          
            StringBuffer st = new StringBuffer();
            int flag = 1;
            String tmpstr = "";
            // 取出报1的
            for(int i = 0; i<math.size();i++){
              if(flag==1){
                st.append(math.get(i));
                st.append(",");
                flag=2;
              }
               // 报2放后面
              else if(flag==2){
                tmpstr = math.get(i);
                math.add(tmpstr);
                flag=1;
              }
            }
            // 处理数据的过程
            math.stream().forEach(e ->System.out.println(e));
             // 取出数据的顺序
            System.out.println(st.toString());
            
    }
    @Test
    public void getPerson4(){
       List<Integer> list = new LinkedList<>();
       list.add(1);
       list.add(1);
       list.add(1);
       System.out.println(list);
    }
    @Test
    public void getPerson5(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aaaaaa");
        map.put(2, "bbbbbb");
        System.out.println(map);
    }
}
