function mergeSortIterative(arr) {
    const n = arr.length;
    const temp = new Array(n);

    for (let currSize = 1; currSize < n; currSize *= 2) {
        for (let leftStart = 0; leftStart < n - 1; leftStart += 2 * currSize) {
            const mid = Math.min(leftStart + currSize - 1, n - 1);
            const rightEnd = Math.min(leftStart + 2 * currSize - 1, n - 1);

            merge(arr, leftStart, mid, rightEnd, temp);
        }
    }

    return arr;
}

function merge(arr, left, mid, right, temp) {
    let i = left,
        j = mid + 1,
        k = left;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }

    while (i <= mid) {
        temp[k++] = arr[i++];
    }

    while (j <= right) {
        temp[k++] = arr[j++];
    }

    for (let p = left; p <= right; p++) {
        arr[p] = temp[p];
    }
}

const arr = [38, 27, 43, 3, 9, 82, 10];
mergeSortIterative(arr);
console.log(arr);
