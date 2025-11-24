function insertionSort(A){
    // We start from second element
    for(var i=1;i<A.length;i++){
    currentElement = A[i];
    var j= i-1; // j will be our first element
    
    // We store the current element and compare it with previous element
    while ((j>=0)&&(currentElement<A[j])){
        A[j+1] = A[j];
        j--;
    }
    A[j+1] = currentElement; //change previous element to current element
    }
}

var a = [3, 203, 34, 746, 200, 984, 198, 764, 9];
insertionSort(a);
console.log(a);