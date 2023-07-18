package main

type TrieNode struct {
	children [26]*TrieNode
	isWord   bool
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func (root *TrieNode) insert(word string) {
	current := root
	for i := 0; i < len(word); i++ {
		child := current.children[word[i]-'a']
		if child == nil {
			child = &TrieNode{}
			current.children[word[i]-'a'] = child
		}
		current = child
	}
	current.isWord = true
}

// time O(n), space O(m), where n == len(word), m == len(forbidden.Join("", ""))
func longestValidSubstring(word string, forbidden []string) int {
	root := &TrieNode{}
	maxForbiddenLen := 10
	for _, forbiddenWord := range forbidden {
		root.insert(forbiddenWord)
	}
	right := len(word) - 1
	var ans int

	for left := len(word) - 1; left >= 0; left-- {
		curNode := root
		for i := left; i <= left+maxForbiddenLen && i <= right; i++ {
			child := curNode.children[word[i]-'a']
			if child == nil {
				break
			}

			if child.isWord {
				right = i - 1
				break
			}
			curNode = child
		}
		ans = max(ans, right-left+1)
	}
	return ans
}
