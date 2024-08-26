# Numeric Matrix Processor

This project consists of stages to perform a variety of operations on matrices including
addition, multiplication, finding the determinant, and dealing with inverse matrices.

## Stage 1/6: Addition
For two matrices to be added, they must have an equal number of rows and columns. 
The sum of matrices `A`and`B`will be a matrix with the same number of rows and columns as`A`or`B`.

In this stage, our reads two matrices from the input,
in such a way that the first line contains the number of rows `n` and the number of columns`m`.
Then `n`lines follow, each containing`m`integers representing one row of the matrix.

Stage implementation: [MatrixAddition.kt](src/matrixprocessor/MatrixAddition.kt)

Example 

Input:

    4 5
    1 2 3 4 5
    3 2 3 2 1
    8 0 9 9 1
    1 3 4 5 6
    4 5
    1 1 4 4 5
    4 4 5 7 8
    1 2 3 9 8
    1 0 0 0 1
 Output:

    2 3 7 8 10
    7 6 8 9 9
    9 2 12 18 9
    2 3 4 5 7


## Stage 2/6: Multiplication by number
In this stage, the multiplication of a matrix by a constant is implemented.

The first line of the input contains the number of rows and the number of columns of the matrix.
The next lines contain rows of the matrix. The last line contains the constant.

Stage implementation: [MatrixMultiplier.kt](src/matrixprocessor/MatrixMultiplier.kt)

Example:

Input:

    3 3
    1 2 3
    4 5 6
    7 8 9
    3

Output:
    
    3 6 9
    12 15 18
    21 24 27

## Stage 3/6: Matrix by matrix multiplication
In this stage: 
- The program is upgraded to run until the user chooses exit option from the menu.
- The menu consist of three matrix operations; addition, matrix by constant multiplication, and matrix by matrix multiplication.
- All matrix operations now support floating point numbers as well, with the ability to determine if the provided matrix is an integer matrix or a floating-point-numbers matrix.
- If the operation is not supported on provided matrices, an error message is output to the user.

Stage implementation: [MatricesCalculator.kt](src/matrixprocessor/MatricesCalculator.kt)

**Example 1:**

    1. Add matrices
    2. Multiply matrix by a constant
    3. Multiply matrices
    0. Exit
    Your choice: > 1
    Enter size of first matrix: > 4 5
    Enter first matrix:
    > 1 2 3 4 5
    > 3 2 3 2 1
    > 8 0 9 9 1
    > 1 3 4 5 6
    Enter size of second matrix: > 4 5
    Enter second matrix:
    > 1 1 4 4 5
    > 4 4 5 7 8
    > 1 2 3 9 8
    > 1 0 0 0 1
    The result is:
    2 3 7 8 10
    7 6 8 9 9
    9 2 12 18 9
    2 3 4 5 7
    
    1. Add matrices
    2. Multiply matrix by a constant
    3. Multiply matrices
    0. Exit
    Your choice: > 0

**Example 2:**

    1. Add matrices
    2. Multiply matrix by a constant
    3. Multiply matrices
    0. Exit
    Your choice: > 2
    Enter size of matrix: > 2 2
    Enter matrix:
    > 1.5 7.0
    > 6.0 5.0
    Enter constant: > 0.5
    The result is:
    0.75 3.5
    3.0 2.5
    
    1. Add matrices
    2. Multiply matrix by a constant
    3. Multiply matrices
    0. Exit
    Your choice: > 0