package computer.science.chapter1.design_pattern.observer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TopicSubscriber implements Observer{
    private String name;
    private Subject topic;

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        System.out.println(name + ":: got message >> " + msg);
    }
}
