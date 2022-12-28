package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    public String getName() {
        return name;
    }
    public int getVolume() {
        return volume;
    }
    private Music music1;
    private Music music2;
    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music music1,
                       @Qualifier("rockMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic(TypeMusic typeMusic) {
        Music music;
        if (typeMusic == TypeMusic.CLASSICAL) music = music1;
        else music = music2;

        Random rand = new Random();
        String randomElement = music.getSong().get(rand.nextInt(music.getSong().size()));

        return "Playing: " + randomElement;
    }
    @PostConstruct
    public void showPlayerInfo() {
        System.out.println("Our player have name: "+getName()+" volume: "+getVolume());
    }
}
