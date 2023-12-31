package software.ulpgc.bigdata.algebra.matrices.longint.test;

import org.junit.jupiter.api.Test;
import software.ulpgc.bigdata.algebra.matrices.longint.Matrix;
import software.ulpgc.bigdata.algebra.matrices.longint.matrix.DenseMatrix;
import software.ulpgc.bigdata.algebra.matrices.longint.matrix.CompressedColumnMatrix;
import software.ulpgc.bigdata.algebra.matrices.longint.matrix.CompressedRowMatrix;
import software.ulpgc.bigdata.algebra.matrices.longint.operators.matrixmultiplication.DenseMatrixMultiplication;
import software.ulpgc.bigdata.algebra.matrices.longint.operators.matrixmultiplication.SparseMatrixMultiplication;
import software.ulpgc.bigdata.algebra.matrices.longint.reader.MatrixFileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MatrixMultiplicationTest {

    @Test
    public void testMatrixMultiplications() {
        try {
            String fileName = "mc2depi.mtx";
            DenseMatrix denseMatrix1 = new DenseMatrix(MatrixFileReader.readMatrixFromFile(fileName));
            DenseMatrix denseMatrix2 = new DenseMatrix(MatrixFileReader.readMatrixFromFile(fileName));

            CompressedRowMatrix crsMatrix = new CompressedRowMatrix(denseMatrix1);
            CompressedColumnMatrix ccsMatrix = new CompressedColumnMatrix(denseMatrix2);

            long startTimeSparse = System.currentTimeMillis();
            Matrix resultSparseMatrix = SparseMatrixMultiplication.multiply(crsMatrix, ccsMatrix);
            long endTimeSparse = System.currentTimeMillis();
            long executionTimeSparse = (endTimeSparse - startTimeSparse) / 1000;

            assertNotNull(resultSparseMatrix);
            System.out.println("Execution time SparseMultiplication: " + executionTimeSparse + " s");

            long startTimeDense = System.currentTimeMillis();
            Matrix resultDenseMatrix = DenseMatrixMultiplication.multiply(denseMatrix1, denseMatrix2);
            long endTimeDense = System.currentTimeMillis();
            long executionTimeDense = (endTimeDense - startTimeDense) / 1000;

            assertNotNull(resultDenseMatrix);
            System.out.println("Execution time DenseMultiplication: " + executionTimeDense + " s");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
