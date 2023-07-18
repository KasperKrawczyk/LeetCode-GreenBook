package main

import "fmt"

// time O(n), space O(n)
func minimumIndex(nums []int) int {
	length := len(nums)

	lSubFreq := map[int]int{}
	rSubFreq := map[int]int{}

	for _, el := range nums {
		rSubFreq[el]++
	}

	for i, _ := range nums {
		lSubFreq[nums[i]]++
		rSubFreq[nums[i]]--

		if lSubFreq[nums[i]]*2 > (i+1) && rSubFreq[nums[i]]*2 > (length-i-1) {
			return i
		}

	}
	return -1
}

func main() {
	fmt.Println(minimumIndex([]int{1, 2, 2, 2}))
}
