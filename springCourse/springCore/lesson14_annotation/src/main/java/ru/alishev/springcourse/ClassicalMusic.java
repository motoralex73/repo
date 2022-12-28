package ru.alishev.springcourse;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

//@Component
public class ClassicalMusic implements MusicOfOneType {
    //@Autowired
    private MusicOfOneType musicOfOneType;
    @Override
    public List<String> getSong() {
        List<String> list = new ArrayList<>();
        list.add("ClassicalMusic1");
        list.add("ClassicalMusic2");
        list.add("ClassicalMusic3");
        return list;
    }
    @PostConstruct
    public void methodPostConstruct() {
        System.out.println("postConstract method");
    }
    @PreDestroy
    public void methodPreDestroy() {
        System.out.println("preDestroyMethod");
    }

}
