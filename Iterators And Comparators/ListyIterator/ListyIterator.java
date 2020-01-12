import java.util.List;

public class ListyIterator {
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


}
