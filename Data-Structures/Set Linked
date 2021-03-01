from copy import deepcopy

class _Set_Node:

    def __init__(self, value, next_):
        """
        -------------------------------------------------------
        Initializes a Set node that contains a copy of value
        and a link to another Set node.
        Use: node = _Set_Node(value, _next)
        -------------------------------------------------------
        Parameters:
            value - value for node (?)
            next_ - another Set node (_Set_Node)
        Returns:
            a new _Set_Node object (_Set_Node)
        -------------------------------------------------------
        """
        self._value = deepcopy(value)
        self._next = next_


class Set:

    def __init__(self):
        """
        -------------------------------------------------------
        Initializes an empty Set.
        Use: set = Set()
        -------------------------------------------------------
        Returns:
            A new Set object (Set)
        -------------------------------------------------------
        """
        self._front = None

    def __len__(self):
        """
        -------------------------------------------------------
        Returns the number of values in the Set.
        Use: n = len(set)
        -------------------------------------------------------
        Returns:
            the number of values in the Set (int)
        -------------------------------------------------------
        """
        curr = self._front
        count = 0
        while curr is not None:
            curr = curr._next
            count += 1
       
        return count

    def is_empty(self):
        """
        -------------------------------------------------------
        Determines if the Set is empty.
        Use: b = set.is_empty()
        -------------------------------------------------------
        Returns:
            True if the Set is empty, False otherwise.
        -------------------------------------------------------
        """
        # your code here
        return self._front is None

    def add(self, value):
        """
        ---------------------------------------------------------
        Adds value to the end of the Set, allows only one copy of value.
        Use: inserted = set.add(value)
        -------------------------------------------------------
        Parameters:
            value - a comparable data element (?)
        Returns:
            True if value is inserted, False otherwise (boolean)
        -------------------------------------------------------
        """
        # your code here
        inserted = False
        node = _Set_Node(value, None)
        if self._front is None:
            inserted = True
            self._front = node
        else:
            curr = self._front
            while curr._value != value:
                if curr._next == None:
                    inserted = True
                    curr._next = node
                curr = curr._next
        return inserted
           

    def _linear_search(self, key):
        """
        -------------------------------------------------------
        Searches for the first occurrence of key in set.
        Private helper method.
        Use: prev, curr = self._linear_search(key)
        -------------------------------------------------------
        Parameters:
            key - a partial data element (?)
        Returns:
            prev - pointer to the node prev to the node containing key (_setNode)
            curr - pointer to the node containing key (_setNode)
        -------------------------------------------------------
        """
        # your code here
        prev = None
        curr = self._front
        while curr is not None and curr._value != key:
            prev = curr
            curr = curr._next
        return prev, curr

    def find(self, key):
        """
        -------------------------------------------------------
        Finds and returns a copy of the first value in set that matches key.
        Use: value = lst.find(key)
        -------------------------------------------------------
        Parameters:
            key - a partial data element (?)
        Returns:
            value - a copy of the full value matching key, otherwise None (?)
        -------------------------------------------------------
        """
        # your code here
        curr = self._linear_search(key)
        if curr is None:
            value = None
        else:
            value = curr._value
        return value

    def remove(self, key):
        """
        -------------------------------------------------------
        Finds, removes, and returns the value in set that matches key.
        Returns None if no matching value.
        Use: value = set.remove(key)
        -------------------------------------------------------
        Parameters:
            key - a partial data element (?)
        Returns:
            value - the full value matching key, otherwise None (?)
        -------------------------------------------------------
        """
        # your code here
        prev, curr = self._linear_search(key)
        if curr is None:
            value = None
        else:
            value = curr._value
            if prev is None:
                self._front = curr._next
            else:
                prev._next = curr._next
           
        return value

    def __contains__(self, key):
        """
        ---------------------------------------------------------
        Determines if the Set contains key.
        Use: b = key in set
        -------------------------------------------------------
        Parameters:
            key - a comparable data element (?)
        Returns:
            True if the Set contains key, False otherwise.
        -------------------------------------------------------
        """
        curr = self._linear_search(key)
        if curr is None:
            containing = False
        else:
            containing = True
        return containing

    def reverse(self):
        """
        -------------------------------------------------------
        Reverses the order of the elements in set.
        Use: source.reverse()
        -------------------------------------------------------
        Returns:
            None
        -------------------------------------------------------
        """
        # your code here
        previous = None
        current = self._front
       
        while current is not None:
            temp = current._next
            current._next = previous
            previous = current
            current = temp
           
        self._front = previous

        return

    def split_th(self):
        """
        -------------------------------------------------------
        Splits source into two parts. target1 contains the first half,
        target2 the second half. curr set becomes empty.
        Uses Tortoise/Hare algorithm.
        Use: target1, target2 = source.split_th()
        -------------------------------------------------------
        Returns:
            target1 - a new set with >= 50% of the original set (Set)
            target2 - a new set with <= 50% of the original set (Set)
        -------------------------------------------------------
        """
        # your code here
        target1 = Set()
        target2 = Set()
       
        if self._front is None:
            target1._front = None
            target2._front = None
        else:
            target1._front = self._front
            tortoise = self._front
            hare = self._front._next
           
            while hare is not None and hare._next is not None:
                tortoise = tortoise._next
                hare = hare._next._next
               
            target2._front = tortoise._next
            tortoise._next = None
            self._front = None
           
        return target1, target2
    
    temp_table = self._table
    # Increase the number of slots and define them.
    self._slots = self._slots * 2 + 1
    self._table = []

    for _ in range(self._slots):
        self._table.append(new_slot())

    # Copy old data to new slots.
    while len(temp_table) > 0:
        old_slot = temp_table.pop(0)

        while not old_slot.is_empty():
            value = old_slot.remove_front()
            slot = self._find_slot(value)
            slot.insert(value)

    def combine(self, source1, source2):
        """
        -------------------------------------------------------
        Combines two source sets into the curr target set.
        When finished, the contents of source1 and source2 are interlaced
        into target and source1 and source2 are empty.
        Order of source values is preserved.
        (iterative algorithm)
        Use: target.combine(source1, source2)
        -------------------------------------------------------
        Parameters:
            source1 - an linked set (Set)
            source2 - an linked set (Set)
        Returns:
            None
        -------------------------------------------------------
        """
        # your code here
        curr1 = source1._front
        curr2 = source2._front
       
        while curr1 is not None and curr2 is not None:
            self.add(curr1._value)
            curr1 = curr1._next
            self.add(curr2._value)
            curr2 = curr2._next

        while curr1 is not None:
            self.add(curr1._value)
            curr1 = curr1._next

        while curr2 is not None:
            self.add(curr2._value)
            curr2 = curr2._next

        source1._front = None
        source2._front = None

        return  
           

    def __iter__(self):
        """
        USE FOR TESTING ONLY
        -------------------------------------------------------
        Generates a Python iterator. Iterates through the set
        from first to last items.
        Use: for v in set:
        -------------------------------------------------------
        Returns:
            yields
            value - the next value in the set (?)
        -------------------------------------------------------
        """
        curr = self._front

        while curr is not None:
            yield curr._value
            curr = curr._next
