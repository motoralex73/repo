package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {
    @Autowired
    private List<Music> music;

    @Override
    public List<String> getSong() {
        List<String> list = new ArrayList<>();
        list.add("RockMusic1");
        list.add("RockMusic2");
        list.add("RockMusic3");
        return list;
    }
}
