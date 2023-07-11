arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array):
    if len(array) <= 1: return array

    pivot = array[0]
    tail = array[1:]

    left_arr = [x for x in tail if x <= pivot]
    right_arr = [x for x in tail if x > pivot]

    return quick_sort(left_arr) + [pivot] + quick_sort(right_arr)

print(quick_sort(arr))
