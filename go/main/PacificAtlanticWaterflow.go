package main

import "math"

var dirs = [][]int{
	{0, -1},
	{1, 0},
	{0, 1},
	{-1, 0},
}

func pacificAtlantic(heights [][]int) [][]int {
	if len(heights) == 0 || heights == nil {
		return nil
	}
	h := len(heights)
	w := len(heights[0])
	pacific := make([][]int, h)
	atlantic := make([][]int, h)
	for i := 0; i < h; i++ {
		pacific[i] = make([]int, w)
		atlantic[i] = make([]int, w)
	}

	for i := 0; i < w; i++ {
		dfs(math.MinInt, pacific, heights, 0, i)
		dfs(math.MinInt, atlantic, heights, h-1, i)
	}
	for i := 0; i < h; i++ {
		dfs(math.MinInt, pacific, heights, i, 0)
		dfs(math.MinInt, atlantic, heights, i, w-1)
	}
	var ans [][]int
	for i := 0; i < h; i++ {
		for j := 0; j < w; j++ {
			if pacific[i][j] == 1 && atlantic[i][j] == 1 {
				ans = append(ans, []int{i, j})
			}
		}
	}
	return ans
}

func dfs(prevHeight int, canSeeOcean [][]int, heights [][]int, curH int, curW int) {
	h := len(heights)
	w := len(heights[0])

	if curH >= h || curH < 0 || curW >= w || curW < 0 || prevHeight > heights[curH][curW] || canSeeOcean[curH][curW] == 1 {
		return
	}
	canSeeOcean[curH][curW] = 1
	curHeight := heights[curH][curW]
	dfs(curHeight, canSeeOcean, heights, curH-1, curW)
	dfs(curHeight, canSeeOcean, heights, curH, curW+1)
	dfs(curHeight, canSeeOcean, heights, curH+1, curW)
	dfs(curHeight, canSeeOcean, heights, curH, curW-1)

}
