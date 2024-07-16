package com.xiaogong.demo02;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-16
 */
public class ListAddTest {

    public static void main(String[] args) {
        XiaoGong xiaoGong = new XiaoGong();
        xiaoGong.setName("xiaogong");
        List<String> strings = new ArrayList<>();
        xiaoGong.setList(strings);
        System.out.println(xiaoGong);
        System.out.println("---------------------");
        List<String> list = xiaoGong.getList();
        list.add("xiaogong3");
        strings.add("xiaogong1");
        strings.add("xiaogong2");
        System.out.println(xiaoGong);
    }

@Data
@ToString
static class XiaoGong{

        private List<String> list;

        private String name;
}

}
