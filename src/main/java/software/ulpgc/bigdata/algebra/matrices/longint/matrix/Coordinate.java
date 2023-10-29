package software.ulpgc.bigdata.algebra.matrices.longint.matrix;

public record Coordinate(int row, int col, double value) {
    public Coordinate(int row, int col, double value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getValue() {
        return value;
    }
}
