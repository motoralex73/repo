package ru.alishev.springcourse;

import java.util.ArrayList;
import java.util.List;

//@Component
public class RockMusic implements MusicOfOneType {
    //@Autowired
    private List<MusicOfOneType> musicOfOneTypes;

    @Override
    public List<String> getSong() {
        List<String> list = new ArrayList<>();
        list.add("RockMusic1");
        list.add("RockMusic2");
        list.add("RockMusic3");
        return list;
    }
}
