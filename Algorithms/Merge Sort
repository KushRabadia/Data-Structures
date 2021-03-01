/*
 * ----------------------------------------------------
 * Algorithm name:		Merge Sort
 *
 * Time Complexity:
 * 					Comparisons
 * Worst Case:      O(n log n)
 * Best Case:       O(n log n)
 * Average Case:    O(n log n)
 *
 * Memory: O(n)
 * Notes: Merge is sort better than quick sort for big arrays
 *   Merge sort is stable
 * ----------------------------------------------------
 */

void merge(Data *array, int left, int middle, int right) {
	int i, j, k;
	int n1 = middle - left + 1;
	int n2 = right - middle;

	Data *L = (Data*) malloc(sizeof(Data) * n1);
	Data *R = (Data*) malloc(sizeof(Data) * n2);

	for (i = 0; i < n1; i++)
		L[i] = array[left + i];
	for (j = 0; j < n2; j++)
		R[j] = array[middle + 1 + j];

	i = 0;
	j = 0;
	k = left;

	while (i < n1 && j < n2) {
		if (compare_data(&L[i], &R[j]) == 2 || compare_data(&L[i], &R[j]) == 0)
			array[k] = L[i++];
		else
			array[k] = R[j++];
		k++;
	}

	while (i < n1)
		array[k++] = L[i++];
	while (j < n2)
		array[k++] = R[j++];

	free(L);
	L = NULL;
	free(R);
	R = NULL;
	return;

}

void merge_sort_aux(Data *array, int left, int right) {
	if (left >= right)
		return;
	int middle = (left + right) / 2;

	merge_sort_aux(array, left, middle);
	merge_sort_aux(array, middle + 1, right);
	merge(array, left, middle, right);
}

void merge_sort(int *array, const int size) {
	assert(array);
	assert(size >= 1);
	merge_sort_aux(array, 0, size - 1);
	return;
}
