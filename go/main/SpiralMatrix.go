package main

import (
	"math"
)

// time O(v + e), space O(bm)
func spiralOrderRec(matrix [][]int) []int {
	arr := []int{}
	rec(matrix, &arr, 0, 0)
	return arr
}

func rec(matrix [][]int, arr *[]int, i, j int) {
	if i >= 0 && j >= 0 && i < len(matrix) && j < len(matrix[0]) && matrix[i][j] != math.MinInt {
		*arr = append(*arr, matrix[i][j])
		matrix[i][j] = math.MinInt

		if i == 0 || matrix[i-1][j] == math.MinInt {
			rec(matrix, arr, i, j+1)
		}
		rec(matrix, arr, i+1, j)
		rec(matrix, arr, i, j-1)
		rec(matrix, arr, i-1, j)
	}
}

// time O(n), space O(n)
func spiralOrder(matrix [][]int) []int {
	arr := []int{}
	iMin := 0
	iMax := len(matrix) - 1
	jMin := 0
	jMax := len(matrix[0]) - 1

	for iMin <= iMax && jMin <= jMax {
		// move right
		for j := jMin; j <= jMax; j++ {
			arr = append(arr, matrix[iMin][j])
		}
		iMin++
		// move down
		for i := iMin; i <= iMax; i++ {
			arr = append(arr, matrix[i][jMax])
		}
		jMax--
		if iMin <= iMax {
			// move left
			for j := jMax; j >= jMin; j-- {
				arr = append(arr, matrix[iMax][j])
			}
		}
		iMax--

		if jMin <= jMax {
			// move up
			for i := iMax; i >= iMin; i-- {
				arr = append(arr, matrix[i][jMin])
			}
		}
		jMin++
	}
	return arr
}
