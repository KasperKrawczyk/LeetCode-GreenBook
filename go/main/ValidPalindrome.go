package main

import (
	"unicode"
)

// time O(n), space O(1)
func isPalindrome(s string) bool {

	i := 0
	j := len(s) - 1

	for i < j {
		leftRune := rune(s[i])
		rightRune := rune(s[j])

		if !unicode.IsLetter(leftRune) && !unicode.IsDigit(leftRune) {
			i++
		} else if !unicode.IsLetter(rightRune) && !unicode.IsDigit(rightRune) {
			j--
		} else if unicode.ToLower(leftRune) == unicode.ToLower(rightRune) {
			i++
			j--
		} else {
			return false
		}

	}

	return true

}
