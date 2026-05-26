package Laborator11;

public class Main {
    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel("TechTalk");

        MediaInterested subscriber1 = new MediaInterested("Alice");
        MediaInterested subscriber2 = new MediaInterested("Bob");

        // Primul uploadVideo - 2 observatori inregistrati
        channel.register(subscriber1);
        channel.register(subscriber2);
        channel.uploadVideo("Introduction to Design Patterns");

        // Al doilea uploadVideo - doar 1 observator
        channel.unregister(subscriber2);
        channel.uploadVideo("Observer Pattern Tutorial");
    }
}
