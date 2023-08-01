package main

// time O(n * m), space O(n)
func groupAnagrams(strs []string) [][]string {
	m := map[[26]int][]string{}

	for _, s := range strs {
		counted := countSort(s)
		m[counted] = append(m[counted], s)
	}

	var ans [][]string

	for key := range m {
		ans = append(ans, m[key])
	}
	return ans
}

func countSort(s string) [26]int {
	arr := [26]int{}

	for _, r := range s {
		arr[r-'a']++
	}

	return arr
}
