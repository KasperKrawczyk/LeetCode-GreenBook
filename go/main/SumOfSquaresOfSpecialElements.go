package main

// time O(n), space O(1)
func sumOfSquares(nums []int) int {
	var ans = 0
	var length = len(nums)
	for i, el := range nums {
		if length%(i+1) == 0 {
			ans += el * el
		}
	}
	return ans
}
