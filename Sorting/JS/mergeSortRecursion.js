function mergeSort(arr) {
    function merge(A, start, end) {
        // Base case: leaf node
        if (start >= end) return;

        // Recursion case: internal node
        const mid = Math.floor(start + (end - start) / 2);
        merge(A, start, mid);
        merge(A, mid + 1, end);

        let i = start,
            j = mid + 1;
        const res = [];

        while (i <= mid && j <= end) {
            if (A[i] <= A[j]) {
                res.push(A[i]);
                i++;
            } else {
                res.push(A[j]);
                j++;
            }
        }

        while (i <= mid) {
            res.push(A[i]);
            i++;
        }
        while (j <= end) {
            res.push(A[j]);
            j++;
        }

        for (let k = start; k <= end; k++) {
            A[k] = res[k - start];
        }
    }

    merge(arr, 0, arr.length - 1);
    return arr;
}

const arr = [38, 27, 43, 3, 9, 82, 10];
mergeSort(arr);
console.log(arr);
