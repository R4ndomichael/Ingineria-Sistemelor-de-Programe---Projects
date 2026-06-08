package ro.ulbs.proiectaresoftware.lab11;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("Tech Explained");

        MediaInterested media1 = new MediaInterested("CNN");
        MediaInterested media2 = new MediaInterested("FoxNews");

        // Primul uploadVideo - 2 observatori inregistrati
        channel.register(media1);
        channel.register(media2);
        channel.uploadVideo("Observer Pattern in Java");

        // Al doilea uploadVideo - doar 1 observator
        channel.unregister(media2);
        channel.uploadVideo("Singleton Pattern in Java");
    }
}
