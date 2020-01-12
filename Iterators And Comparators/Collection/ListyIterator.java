import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        this.index = 0;
    }

    public boolean move(){
        if (this.hasNext()){
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        return this.index < this.data.size() - 1;
    }

    public String print() throws IllegalAccessException{
        if (this.data.size() == 0){
            throw new IllegalAccessException("Invalid Operation!");
        }

        return this.data.get(this.index);
    }

    public void printAll(){
        for (String str : this) {
            System.out.print(str + " ");
        }
        System.out.println();
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public String next() {
                return data.get(index++);
            }
        };
    }
}
