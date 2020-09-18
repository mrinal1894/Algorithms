------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: matrix multipication
PURPOSE OF PROJECT:n by n matrix multiplication, here n is a power of two, so zeros can be padded for n that are not power of two
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS: n is the size of the square matrix which is the input given as an argument to the main function.
		   n is first coverted to the nearest power of 2, greater than n.
		   the program ask for the inputs A[i][j] and B[i][j].
		   the matrix_muiplication uses simple recursions to solve matrix. multiplication
		   the matrix_multiplication program time varies as n^3.
		   the srassens algorithm program reduces the complexity to n^(log 7)
		   there is also a matrix_mul in which the matrices are subdivided using two array indicating the index of rows and columns and is 
		   faster than the matrix multiplication_algorithm in which new smaller arrays are created while subdividing.

