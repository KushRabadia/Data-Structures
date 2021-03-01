/*
 * ----------------------------------------------------
 * Algorithm name:	Quick Sort
 *
 * Time Complexity:
 * 					Comparisons
 * Worst Case:   O(n^2)
 * Best Case:  O(n log n)
 * Average Case:  O(n log n)
 *
 * Memory: O(log n)
 * Notes: Average is better than selection & insertion sort
 *   sorting is not stable
 * ----------------------------------------------------
 */
int partition(Data *array, int start, int end) {
	Data pivot = array[end];
	int pivot_indx = start;
	for (int j = start; j < end; j++)
		if (compare_data(&array[j], &pivot) == 2) {
			swap_data(&array[pivot_indx], &array[j]);
			pivot_indx++;
		}
	swap_data(&array[pivot_indx], &array[end]);
	return pivot_indx;
}
void quick_sort_aux(Data *array, int start, int end) {
	if (start >= end)
		return;
	int pivot_indx = partition(array, start, end);
	quick_sort_aux(array, start, pivot_indx - 1);
	quick_sort_aux(array, pivot_indx + 1, end);
}
void quick_sort(Data *array, const int size) {
	assert(array);
	assert(size >= 1);
	quick_sort_aux(array, 0, size - 1);
	return;
}
