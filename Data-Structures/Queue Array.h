#ifndef SRC_QUEUE_ARRAY_H_
#define SRC_QUEUE_ARRAY_H_

# include "data.h"

#define True 1

#define False 0

typedef struct {
	Data *array;
	int front;
	int rear;
	int capacity;
} Queue;

Queue* create_queue(int capacity);
int is_empty_queue(Queue *q);
int len_queue(Queue *q);
int is_full_queue(Queue *q);
int insert_queue(Queue *q, Data *d);
Data* peek_queue(Queue *q);
Data* remove_queue(Queue *q);
void destroy_queue(Queue **q);
void print_queue(Queue *q);
int get_capacity_queue(Queue *q);

#endif /* SRC_QUEUE_ARRAY_H_ */
