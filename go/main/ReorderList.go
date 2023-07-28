package main

type ListNode struct {
	Val  int
	Next *ListNode
}

// time O(n), space O(1)
func reorderList(head *ListNode) {

	var list []*ListNode

	end := head
	for end != nil {
		list = append(list, end)
		end = end.Next
	}

	left := head
	for i := len(list) - 1; i > (len(list)-1)/2; i-- {
		next := left.Next
		left.Next = list[i]
		left.Next.Next = next
		left = next
	}
	left.Next = nil
}
