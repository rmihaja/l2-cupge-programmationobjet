package piles;

public class MaPileEntiers implements IPileEntiers {

    protected int[] intPile;
    protected int size;

    public MaPileEntiers(int length) {
        this.intPile = new int[length];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.intPile.length == this.size;
    }

    public int get() {
        assert(!this.isEmpty()) : "Error: Pile is empty";
        return this.intPile[0];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.intPile.length;
    }

    public boolean add(int value) {
        if (!this.isFull()) {
            this.intPile[size] = value;
            this.size++;
            return true;
        }
        return false;
    }

    public boolean remove() {
        if (!this.isEmpty()) {
            this.size--;
            for (int i = 0; i < this.size; i++) {
                this.intPile[i] = this.intPile[i + 1];
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < this.size - 1; i++) {
            result += this.intPile[i] + ", ";
        }
        return result + this.intPile[this.size - 1] + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof MaPileEntiers)) {
            return false;
        }
        MaPileEntiers pile = (MaPileEntiers) o;
        if (this.size() != pile.size())
            return false;

        boolean isEqual = true;
        for (int i = 0; i < this.size() && isEqual; i++) {
            if (this.intPile[i] != pile.intPile[i]) {
                isEqual = false;
            }
        }
        return isEqual;
    }
}