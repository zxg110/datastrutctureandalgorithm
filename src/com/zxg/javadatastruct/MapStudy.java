package com.zxg.javadatastruct;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Java Map Interface Study
 */
public class MapStudy {
    public static void main(String[] args) {
        MapStudy study = new MapStudy();
        study.studyNavigableMap();
    }

    /**
     * 导航Map接口，实现类为TreeMap
     * https://blog.csdn.net/u010126792/article/details/62236367
     */
    public void studyNavigableMap() {
        NavigableMap<String, Integer> navigatorTreeMap = new TreeMap<>();
        // 增加元素
        navigatorTreeMap.put("aa", 11);
        navigatorTreeMap.put("bb", 22);
        navigatorTreeMap.put("cc", 33);
        navigatorTreeMap.put("dd", 44);
        navigatorTreeMap.put("ee", 55);
        navigatorTreeMap.put("ff", 55);
        navigatorTreeMap.put("gg", 55);
        //返回大于等于cc的键 不存在返回null result:cc
        System.out.println(navigatorTreeMap.ceilingKey("cc"));
        //返回阉割大于cc的最大键，不存在返回null result:dd
        System.out.println(navigatorTreeMap.higherKey("cc"));
        //返回小于等于cc的键 不存在返回null result:cc
        System.out.println(navigatorTreeMap.floorKey("cc"));
        //返回严格大于cc的最大键，不存在返回null result:bb
        System.out.println(navigatorTreeMap.lowerKey("cc"));
        //返回此映射的部分视图，其键值严格小于 toKey。不存在返回null
        //result: aa bb cc
        SortedMap<String, Integer> headMap = navigatorTreeMap.headMap("dd");
        for (Map.Entry<String, Integer> entry : headMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
        //返回该Map的逆序Map
        NavigableMap<String, Integer> descendMap = navigatorTreeMap.descendingMap();
        for (Map.Entry<String, Integer> entry : descendMap.entrySet()) {
            System.out.println("descendMap key:" + entry.getKey() + ",descendMap value:" + entry.getValue());
        }

    }


}
