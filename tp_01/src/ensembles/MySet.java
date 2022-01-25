package ensembles;

import java.util.ArrayList;
import java.util.Random;

public class MySet {

    protected ArrayList<Double> doubleSet;

    public MySet() {
        this.doubleSet = new ArrayList<Double>();
    }

    public MySet(MySet set) {
        this.doubleSet = set.doubleSet;
    }

    public double get(int index) {
        assert (!this.isEmpty()) : "Error: Set is empty";
        return this.doubleSet.get(index);
    }

    public boolean contains(double value) {
        return this.doubleSet.contains(value);
    }

    public void add(double value) {
        if (!this.contains(value)) {
            this.doubleSet.add(value);
        }
    }

    public boolean remove(double value) {
        return this.doubleSet.remove(value);
    }

    public boolean isEmpty() {
        return this.doubleSet.isEmpty();
    }

    public int size() {
        return this.doubleSet.size();
    }

    public void clear() {
        this.doubleSet.clear();
    }

    public double random() {
        Random random = new Random();
        if (!this.isEmpty()) {
            return this.doubleSet.get(random.nextInt(this.doubleSet.size()));
        } else
            return 0;
    }

    @Override
    public String toString() {
        return this.doubleSet.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof MySet))
        return false;
        MySet set = (MySet) o;

        boolean isEqual = true;
        if ((this.isEmpty() && !set.isEmpty()) || (!this.isEmpty() && set.isEmpty())) {
            isEqual = false;
        }
        for (int i = 0; i < this.size() && isEqual; i++) {
            if (!set.contains(this.get(i))) {
                isEqual = false;
            }
        }
        for (int i = 0; i < set.size() && isEqual; i++) {
            if (!this.contains(set.get(i))) {
                isEqual = false;
            }
        }
        return isEqual;
    }
}
