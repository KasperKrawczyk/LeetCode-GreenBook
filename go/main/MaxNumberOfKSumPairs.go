package main

// time O(n), space O(n)
func maxOperations(nums []int, k int) int {
	count := 0
	frequencies := map[int]int{}

	for _, val := range nums {
		comp := k - val
		frequency, exists := frequencies[comp]
		if exists {
			if frequency == 1 {
				delete(frequencies, comp)
			} else {
				frequencies[comp] = frequency - 1
			}
			count++
		} else {
			valFrequency, valFrequencyExists := frequencies[val]
			if valFrequencyExists {
				frequencies[val] = valFrequency + 1
			} else {
				frequencies[val] = 1
			}
		}
	}

	return count

}
