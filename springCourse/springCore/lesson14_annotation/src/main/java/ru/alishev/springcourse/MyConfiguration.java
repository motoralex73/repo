package ru.alishev.springcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("ru.alishev.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class MyConfiguration {
    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }
    @Bean
    public PopMusic popMusic() {
        return new PopMusic();
    }
    @Bean
    public MusicTypes listMusicType() {
        return new MusicTypes() {
            @Override
            public List<MusicOfOneType> getListTypeMusic() {
                List<MusicOfOneType> list = new ArrayList<>();
                list.add(new ClassicalMusic());
                list.add(new RockMusic());
                list.add(new PopMusic());
                return list;
            }
        };
    }
    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(listMusicType().getListTypeMusic());
    }
    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }

}
