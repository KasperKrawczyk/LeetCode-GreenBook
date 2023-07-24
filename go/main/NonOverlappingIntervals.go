package main

import (
	"math"
	"sort"
)

// time O(n long n), space O(n)
func eraseOverlapIntervals(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1] < intervals[j][1]
	})

	curMin := math.MinInt
	count := 0
	for _, interval := range intervals {
		if interval[0] >= curMin {
			curMin = interval[1]
		} else {
			count++
		}
	}
	return count
}
