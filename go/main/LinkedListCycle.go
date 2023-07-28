package main

import "math"

func hasCycle(head *ListNode) bool {
	for head != nil {
		if head.Val == math.MinInt {
			return true
		}
		head.Val = math.MinInt
		head = head.Next
	}
	return false
}
