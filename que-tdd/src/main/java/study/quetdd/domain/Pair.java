package study.quetdd.domain;

public class Pair {

    private String from;
    private String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public boolean equals(Object o){
        Pair pair = (Pair) o;
        return from.equals(pair.from) && to.equals(pair.to);
    }

    public int hashCode(){
        return 0;
    }
}
