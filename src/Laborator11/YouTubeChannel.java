package Laborator11;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {
    private String channelName;
    private String latestVideo;
    private List<Observer> observers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public void uploadVideo(String videoTitle) {
        this.latestVideo = videoTitle;
        System.out.println("\n[YouTubeChannel] Video incarcat: \"" + videoTitle + "\"");
        notifyObservers();
    }

    public String getChannelName() {
        return channelName;
    }

    public String getLatestVideo() {
        return latestVideo;
    }
}
