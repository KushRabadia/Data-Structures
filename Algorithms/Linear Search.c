/*
 * ----------------------------------------------------
 * Linear Search (Iterative Version)
 * 					Comparisons
 * Worst Case: O(n)
 * Best Case: O(1)
 * Average Case: O(n)
 * ----------------------------------------------------
 */
int linear_search(Data *array, const int size, Data item) {
	assert(array);
	assert(size >= 1);
	int result = -1;
	for (int i = 0; i < size; i++) {
		if (compare_data(&array[i], &item) == 0) {
			result = i;
			break;
		}
	}
	return result;
}

/*
 * ----------------------------------------------------
 * Linear Search (Recursive Version)
 * ----------------------------------------------------
 */
int linear_search_r_aux(Data *array, int start, int end, Data item) {
	if (start > end)
		return -1;
	if (compare_data(&array[start], &item) == 0)
		return start;
	return linear_search_r_aux(array, start + 1, end, item);
}

int linear_search_r(Data *array, const int size, Data item) {
	assert(array);
	assert(size >= 1);

	return linear_search_r_aux(array, 0, size - 1, item);
}
