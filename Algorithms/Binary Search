
/*
 * ----------------------------------------------------
 * Binary Search (Iterative Version)
 * 					Comparisons
 * Worst Case: O(log n)
 * Best Case:O(1)
 * Average Case: O(log n)
 * ----------------------------------------------------
 */
int binary_search(Data *array, const int size, Data item) {
	int result, middle;
	int start = 0;
	int end = size - 1;
	while (start <= end) {
		middle = (start + end) / 2;
		result = compare_data(&array[middle], &item);
		if (result == 0)
			return middle;
		if (result == 1)
			end = middle - 1;
		else
			start = middle + 1;
	}
	return -1;
}

/*
 * ----------------------------------------------------
 * Binary Search (Recursive Version)
 * ----------------------------------------------------
 */
int binary_search_r_aux(Data *array, int start, int end, Data item) {
	if (start > end)
		return -1;

	int mid = start + (end - start) / 2;
	int result = compare_data(&array[mid], &item);
	if (result == 0)
		return mid;
	if (result == 1)
		return binary_search_r_aux(array, start, end - 1, item);
	return binary_search_r_aux(array, mid + 1, end, item);
}

int binary_search_r(Data *array, const int size, Data item) {
	assert(array);
	assert(size >= 1);
	return binary_search_r_aux(array, 0, size - 1, item);
}
/*
