package files;

import java.util.ArrayList;

/**
 * FileArrayList
 */
public class FileArrayList implements IFileNonBornee {

    protected ArrayList<Double> data;

    public FileArrayList() {
        data = new ArrayList<Double>();
    }

    public boolean add(double e) {
        this.data.add(e);
        return true;
    }

    public boolean remove() {
        if (this.isEmpty()) {
            return false;
        }
        this.data.remove(0);
        return true;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.data.size();
    }

    public double get() {
        assert (!this.isEmpty()) : "Error: File is empty";
        return this.data.get(0);
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < this.size() - 1; i++) {
            result += this.data.get(i) + ", ";
        }
        return result + this.data.get(this.size() - 1) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileArrayList)) {
            return false;
        }

        FileArrayList fileArrayList = (FileArrayList) obj;
        if (this.size() != fileArrayList.size()) {
            return false;
        }

        boolean isEqual = true;
        for (int i = 0; i < this.size() && isEqual; i++) {
            isEqual = this.data.get(i).equals(fileArrayList.data.get(i));
        }
        return isEqual;

        // ? autre implémentation possible
        // return this.data.equals(fileArrayList.data);
    }
}