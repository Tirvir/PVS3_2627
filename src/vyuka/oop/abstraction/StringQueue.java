package vyuka.oop.abstraction;

public class StringQueue {
    QueueLink first, last;

    void enqueue(String toAdd){
        QueueLink link = new QueueLink();
        link.data=toAdd;
        if (first.data.isBlank()){
            first = link;
            last = link;
        } else {
            last.next = link;
            last = link;
        }
    }
    String dequeue(){
        if (first==null) {
        return null;
        }
        else {
        String toReturn = first.data;
        first = first.next;
        return toReturn;

        }
    }

}
class QueueLink{
    String data;
    QueueLink next;
}
