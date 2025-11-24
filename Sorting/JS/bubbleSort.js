function bubbleSort(A){

    var swapped;
    m = A.length-1;
    do{
        swapped=false;
    for(var i= 0; i<m;i++){
        if(A[i]>A[i+1]){
            var temp=A[i];
            A[i]=A[i+1];
            A[i+1]=temp;
            swapped=true;
        }

    }
}while(swapped);
}

var a = [3, 203, 34, 746, 200, 984, 198, 764, 9];
bubbleSort(a);
console.log(a);