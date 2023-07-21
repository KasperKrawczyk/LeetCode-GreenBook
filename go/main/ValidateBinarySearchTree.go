package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// time O(n), space O(1)
func isValidBST(root *TreeNode) bool {
	return isValidRecursive(root, nil, nil)
}

func isValidRecursive(node *TreeNode, curMinNode *TreeNode, curMaxNode *TreeNode) bool {

	if node == nil {
		return true
	}

	if curMinNode != nil && node.Val <= curMinNode.Val {
		return false
	}

	if curMaxNode != nil && node.Val >= curMaxNode.Val {
		return false
	}

	return isValidRecursive(node.Left, curMinNode, node) && isValidRecursive(node.Right, node, curMaxNode)
}
