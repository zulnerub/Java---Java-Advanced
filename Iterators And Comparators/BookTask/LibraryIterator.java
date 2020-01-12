import java.util.Iterator;

public class LibraryIterator implements Iterator<Book> {

    private Book[] data;
    private int index = 0;

    public LibraryIterator(Book[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return this.index < data.length;
    }

    @Override
    public Book next() {
        return this.data[this.index++];
    }
}