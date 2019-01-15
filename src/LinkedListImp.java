class SListNode<T>{
    private T value;
    private SListNode<T> next;

    public SListNode(T value){
        this.value=value;
        this.next=null;
    }

    public void setNext(SListNode<T> next){
        this.next=next;
    }

    public SListNode<T> getNext(){
        return next;
    }

    public T getValue(){
        return value;
    }

    public String toString(){
        if(value == null){
            return "null";
        }
        else {
            return value.toString();
        }
    }

}

class SList<T>{
    SListNode<T> head=new SListNode<T>(null);

    public String toString(){
        if(head.getNext()==null){
            return "empty list";
        }else{
            SListIterator<T> it=iterator();
            String output="head -> ";
            while (it.hasNext()){
                output+= it.next().getValue() + " -> ";
            }
            return output+"null";
        }
    }

    SListIterator<T> iterator(){
        return new SListIterator<T>(head);
    }


}

class SListIterator<T>{
    SListNode<T> head;
    SListNode<T> currentNode;

    public SListIterator(SListNode<T> head){
        this.head=head;
        this.currentNode=head;
    }

    public boolean hasNext(){
        if(currentNode.getNext()==null)
            return false;
        else
            return true;
    }

    public SListNode<T> getCurrentNode(){
        return currentNode;
    }

    public SListNode<T> next(){
        return currentNode=currentNode.getNext();

    }

    public SListNode<T> nextNode(){
        return currentNode.getNext();

    }

    public void insert(T value){
        if(head==null){
            head=new SListNode(null);
            currentNode=new SListNode(value);
            head.setNext(currentNode);
        }else{
            SListNode<T> newNode=new SListNode<T>(value);
            currentNode.setNext(newNode);
            currentNode=newNode;
        }
    }

    public void remove(T value){
        SListIterator<T> traverse=new SListIterator<T>(head);
        boolean flag=false;
        while(traverse.hasNext() && flag==false){
            if(traverse.nextNode().getValue()==value){
                traverse.getCurrentNode().setNext(traverse.nextNode().getNext());
                flag=true;
            }
            traverse.next();
        }
    }

}

public class LinkedListImp {
    public static void main(String[] args) {
        SList<Integer> sList=new SList<Integer>();
        SListIterator<Integer> sListIterator=sList.iterator();

        System.out.println(sList);
        sListIterator.insert(2);

        System.out.println(sList);
        sListIterator.insert(3);

        System.out.println(sList);
        sListIterator.insert(4);

        System.out.println(sList);

        sListIterator.remove(5);
        System.out.println(sList);

        sListIterator.remove(2);

        System.out.println(sList);
        sListIterator.remove(3);

        System.out.println(sList);

    }
}
