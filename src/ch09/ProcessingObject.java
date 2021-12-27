package ch09;

public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> next;

    public void setNext(ProcessingObject<T> next) {
        this.next = next;
    }

    public T handle(T input){
        T result = handleObject(input);
        if(next!=null) return next.handle(result);
        return result;
    }

    protected abstract T handleObject(T input);


}
