package software.ulpgc.bigdata.algebra.matrices.longint.matrix;

import java.util.List;

public class CoordinateMatrix {
    private final int numRows;
    private final int numCols;
    private final List<Coordinate> entries;

    public CoordinateMatrix(int numRows, int numCols, List<Coordinate> entries) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.entries = entries;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public List<Coordinate> getEntries() {
        return entries;
    }

}
