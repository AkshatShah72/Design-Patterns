import java.util.*;

interface Observer {
    public void update(String name, String message);
}

interface Subject {
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void notifyObservers(String message);
}

class Youtuber implements Subject {
    private String youtuberName;
    private ArrayList<Observer> subscribers;

    public Youtuber(String youtuberName) {
        this.youtuberName = youtuberName;
        subscribers = new ArrayList<Observer>();
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(String videoName) {
        for (Observer subscriber : subscribers) {
            subscriber.update(youtuberName, videoName);
        }
    }

    public void videoName(String videoName) {
        System.out.println(youtuberName + " has uploaded " + videoName + " video on his channel");
        notifyObservers(videoName);
    }
}

class Subscriber implements Observer {
    private String subscriberName;

    public Subscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public void update(String youtuberName, String videoName) {
        System.out.println(subscriberName + ", you have to see an amazing video by " + youtuberName + " whose video's name is " + videoName);
    }
}

public class observerpattern {
    public static void main(String args[]) {
        
        Youtuber tSeries = new Youtuber("T-Series");
        Subscriber AKP = new Subscriber("AKP");
        Subscriber jatin = new Subscriber("jatin");
        Subscriber shubham = new Subscriber("shubham");
        Subscriber abhisht = new Subscriber("abhisht");
        
        tSeries.subscribe(shubham);
        tSeries.subscribe(jatin);
        
        tSeries.videoName("Romantic Song");
       
    }
}
