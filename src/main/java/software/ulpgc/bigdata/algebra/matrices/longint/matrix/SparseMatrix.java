package software.ulpgc.bigdata.algebra.matrices.longint.matrix;

import software.ulpgc.bigdata.algebra.matrices.longint.Matrix;

public record SparseMatrix(CoordinateMatrix coordinateMatrix) implements Matrix {

    @Override
    public int size() {
        return coordinateMatrix.getNumRows();
    }

    @Override
    public long get(int i, int j) {
        return coordinateMatrix.getEntries().stream()
                .filter(entry -> entry.getRow() == i && entry.getCol() == j)
                .mapToLong(entry -> (long) entry.getValue())
                .findFirst()
                .orElse(0L);
    }

    @Override
    public int getNumRows() {
        return coordinateMatrix.getNumRows();
    }

    @Override
    public int getNumCols() {
        return coordinateMatrix.getNumCols();
    }
}
