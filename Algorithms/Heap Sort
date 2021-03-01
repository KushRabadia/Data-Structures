/*
 * ----------------------------------------------------
 * Algorithm name:		Heap Sort
 *
 * Time Complexity:
 * 					Comparisons		Swaps
 * Worst Case:		O(log n)		O(log n)
 * Best Case:		O(1)			O(1)
 * Average Case:	O(log n)		O(log n)
 *
 * Memory: O(n)
 * * ----------------------------------------------------
 */
void heap_sort(Data *array, const int size) {
	Heap *h = create_heap(size);
	int i;
	for (i = 0; i < size; i++)
		insert_heap(h, &array[i]);

	for (i = 0; i < size; i++) {
		array[i] = *peek_heap(h);
		remove_heap(h);
	}

	destroy_heap(&h);

	return;
  

void heap_sort2(Data *array, const int size) {
	Heap *h = create_heap(size);
	int i;
	for (i = 0; i < size; i++)
		insert_heap(h, &array[i]);

	for (i = size - 1; i > -1; i--) {
		array[i] = *peek_heap(h);
		remove_heap(h);
	}

	destroy_heap(&h);

	return;
}
