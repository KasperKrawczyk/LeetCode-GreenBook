package main

import (
	"sort"
)

// time O(sort(nums)), space O(n)
func maximumBeauty(nums []int, k int) int {
	sort.Ints(nums)
	length := len(nums)
	j := 0
	i := 0
	for i < length {
		if nums[i]-nums[j] > (k * 2) {
			j++
		}
		i++
	}
	return i - j
}
