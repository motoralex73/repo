package ru.alishev.springcourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
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
    @PostConstruct
    public void methodPostConstruct() {
        System.out.println("postConstract method");
    }
    @PreDestroy
    public void methodPreDestroy() {
        System.out.println("preDestroyMethod");
    }

}
