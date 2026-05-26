package Laborator11;

public class MediaInterested implements Observer {
    private String name;

    public MediaInterested(String name) {
        this.name = name;
    }

    @Override
    public void update(YouTubeChannel channel) {
        System.out.println(name + " notificat: canalul \"" + channel.getChannelName()
                + "\" a incarcat: \"" + channel.getLatestVideo() + "\"");
    }
}
