package files;

/**
 * FileCirculaire
 */
public class FileCirculaire implements IFileBornee {

    protected int first;
    protected int last;

    protected int length;
    protected int size;

    protected double[] data;

    public FileCirculaire(int length) {
        this.length = length;

        this.first = 0;
        this.last = 0;
        this.size = 0;

        this.data = new double[this.length];
    }

    public boolean add(double e) {
        if (this.isFull()) {
            return false;
        }
        this.data[this.last] = e;
        this.last = (this.last + 1) % this.length;
        this.size++;
        return true;
    }

    public boolean remove() {
        if (this.isEmpty()) {
            return false;
        }
        this.first = (this.first + 1) % this.length;
        this.size--;
        return true;
    }

    public boolean isEmpty() {
        return this.first == this.last && this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public double get() {
        return this.data[this.first];
    }

    public boolean isFull() {
        return this.size == this.length;
    }

    public int capacity() {
        return this.length;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < this.size - 1; i++) {
            result += this.data[(this.first + i) % this.length] + ", ";
        }
        return result + this.data[this.last - 1] + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileCirculaire)) {
            return false;
        }

        FileCirculaire fileCirculaire = (FileCirculaire) obj;
        if (fileCirculaire.size() != this.size()) {
            return false;
        }

        boolean isEqual = true;
        for (int i = 0; i < this.size && isEqual; i++) {
            isEqual = this.data[(this.first + i) % this.capacity()] == fileCirculaire.data[(fileCirculaire.first + i) % fileCirculaire.capacity()];
        }
        return isEqual;
    }
}