package ru.alishev.springcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    @Autowired
    private Music music;
    @Override
    public List<String> getSong() {
        List<String> list = new ArrayList<>();
        list.add("ClassicalMusic1");
        list.add("ClassicalMusic2");
        list.add("ClassicalMusic3");
        return list;
    }
}
