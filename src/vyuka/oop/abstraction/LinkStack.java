package vyuka.oop.abstraction;

public class LinkStack implements MyStack{
    MyLink data;

    @Override
    public void push(String item) {
    MyLink curr = data;
    while(curr.getCurrent() != null){
        curr=curr.getNext();
    }
    data.setCurrent(item);
    data.setNext(new MyLink(null));
    }

    @Override
    public String pop() {
        return "";
    }

    @Override
    public String peek() {
        return "";
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
class MyLink{
    String current;
    MyLink next;

    public MyLink(String current){
        this.current=current;
    }
    public void setNext(MyLink next){
        this.next=next;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public MyLink getNext() {
        return next;
    }
}