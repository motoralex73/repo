package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

//@Component
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
    private List<MusicOfOneType> musicOfOneTypes;

    public MusicPlayer(List<MusicOfOneType> musicOfOneTypes) {
        this.musicOfOneTypes = musicOfOneTypes;
    }

    public String playMusic() {
        MusicOfOneType musicOfOneTypeOne;

        Random rand = new Random();
        musicOfOneTypeOne = musicOfOneTypes.get(rand.nextInt(3));
        String randomElement = musicOfOneTypeOne.getSong().get(rand.nextInt(3));//music.getSong().get(rand.nextInt(music.getSong().size()));

        return "Playing: " + randomElement;
    }
    @PostConstruct
    public void showPlayerInfo() {
        System.out.println("Our player have name: "+getName()+" volume: "+getVolume());
    }
}
