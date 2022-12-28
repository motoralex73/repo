package ru.alishev.springcourse;

import java.util.ArrayList;
import java.util.List;

//@Component
public class PopMusic implements MusicOfOneType {
    //@Autowired
    private MusicOfOneType musicOfOneType;
    @Override
    public List<String> getSong() {
        List<String> list = new ArrayList<>();
        list.add("PopMusic1");
        list.add("PopMusic2");
        list.add("PopMusic3");
        return list;
    }
}
