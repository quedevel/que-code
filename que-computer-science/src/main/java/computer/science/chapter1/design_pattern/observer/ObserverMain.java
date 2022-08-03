package computer.science.chapter1.design_pattern.observer;

public class ObserverMain {
    public static void main(String[] args) {
        Topic topic = new Topic();
        Observer a = new TopicSubscriber("a", topic);
        Observer b = new TopicSubscriber("b", topic);
        Observer c = new TopicSubscriber("c", topic);
        topic.register(a);
        topic.register(b);
        topic.register(c);

        topic.postMessage("post message !!");
        /*
        Message sent to Topic: post message !!
        a:: got message >> post message !!
        b:: got message >> post message !!
        c:: got message >> post message !!
        */
    }
}
