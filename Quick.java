public class Quick{
  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
public static int partitionO ( int [] data, int start, int end){
  int ranInd = (int) (Math.random() * (end+1 -start) + start); //generate a random index
  int pivot = data[ranInd];
  //switch the first value with the pivot value to compare
  int first = data[start];
  data[start] = pivot;
  data[ranInd] = first;
  ranInd = start;
  /*while (start + 1 < end){
    if (data[start+1] <= data[start]){ //if the next value is less than or equal to current/pivot
      data[start] = data[start+1];
      data[start+1] = pivot;
      start++;
    }
    else{
      //if the next value is greater than pivot
      int toPushBack = data[start+1];
      for (int i = start+1; i < data.length-1; i++){
        data[i] = data[i+1];//move all values up by one spot
      }
      data[data.length-1] = toPushBack;
      end--;
    }
  }
  if (data[end] < data[start]){
    data[start] = data[end];
    data[end] = pivot;
    start++;
  }
  return start;*/
  if (end == start) {//if there is only one value
    return start;
  }
  int l = start+1;
  int h = end;
  while (l != end){
    if (data[l] <= data[start]){//if the value is less that pivot
      l++;
    }
    else{//if the value is greater than pivot, sawp it with the end value
      int toPushBack = data[l];
      data[l] = data[end];
      data[end] = toPushBack;
      end--;
    }
  }
  if (data[l] <= pivot){ //comparing the last value
    //System.out.println("last value is l? : " + l + " and start/pivot is : " + start);
    data[start] = data[l];
    data[l] = pivot;
    return l;
  }
  else{
    //if the last value is greater than pivot:
    //pivot will swap with the value before that larger value
    data[start] = data[l-1];
    data[l-1] = pivot;
    return l-1;
  }
}

public static int partition1 ( int [] data, int start, int end){
  int ranInd = (int) (Math.random() * (end+1 -start) + start); //generate a random index
  int pivot = data[ranInd];
  //switch the first value with the pivot value to compare
  int first = data[start];
  data[start] = pivot;
  data[ranInd] = first;
  ranInd = start;//fresh the start back to beginning
  int back = end; //j is the last value
  if (end == start) {//if there is only one value
    return start;
  }
  int front = start+1;
  //start is the current loc of pivot; front is the front value needed to be compared; end is the back value;
  while (front != back){//before only one value left
    if (data[front] <= pivot){
      front++; //if the value is <= pivot, it stays in front and we move to next value to compare
    }
    else{
      int toPushBack = data[front];
      data[front] = data[back]; //switch the front value with the back value when front is larger than back.
      data[back] = toPushBack;
      back--;
    }
  }
  //front is now == to back
  if (data[front] <= pivot){
    data[start] = data[front];//if the last value is smaller, switch place with pivot that is in the start
    data[front] = pivot;
    return front;
  }
  else{
    data[start] = data[back-1]; //if last value is larger, switch the value before the last value with pivot
    data[back-1] = pivot;
    return back-1;
  }
}

public static int partition ( int [] data, int start, int end){
  int ranInd = (int) (Math.random() * (end+1 -start) + start); //generate a random index
  int pivot = data[ranInd];
  //switch the first value with the pivot value to compare
  int first = data[start];
  data[start] = pivot;
  data[ranInd] = first;
  ranInd = start;//fresh the start back to beginning
  int back = end; //j is the last value
  if (end == start) {//if there is only one value
    return start;
  }
  int front = start+1;
  //start is the current loc of pivot; front is the front value needed to be compared; end is the back value;
  while (front != back){//before only one value left
    if (data[front] < pivot){
      front++; //if the value is <= pivot, it stays in front and we move to next value to compare
    }
    else if(data[front] == pivot){
      int side = (int) (Math.random() * 2);
      if (side == 0){
        front++;
      }
      else{
        int goBack = data[front];
        data[front] = data[back];
        data[back] = goBack;
        back--;
      }
    }
    else{
      int toPushBack = data[front];
      data[front] = data[back]; //switch the front value with the back value when front is larger than back.
      data[back] = toPushBack;
      back--;
    }
  }
  //front is now == to back
  if (data[front] <= pivot){
    data[start] = data[front];//if the last value is smaller, switch place with pivot that is in the start
    data[front] = pivot;
    return front;
  }
  else{
    data[start] = data[back-1]; //if last value is larger, switch the value before the last value with pivot
    data[back-1] = pivot;
    return back-1;
  }
}

/*return the value that is the kth smallest value of the array.
*/
public static int quickselect(int []data, int k){
  //first try if random got it
  int start = 0;
  int end = data.length-1;
  int trial = partition(data, start, end);
  while (trial != k){
    if (trial < k){
      start = trial+1;
      trial = partition(data, start, end);
    }
    else{
      end = trial-1;
      trial = partition(data, start , end);
    }
  }
  return data[trial];
}

public static String printAry(int[] ary){
  String ans = "";
  for (int i = 0; i < ary.length; i++){
    ans += ans + ary[i] + ", ";
  }
  return ans;
}

/*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data){
   quicksort(data, 0, data.length-1);
 }

 public static void quicksort(int[] data, int lo, int hi){
   if (lo >= hi){
     return;
   }
   else{
     int pivot = partition(data, lo, hi);
     quicksort(data, lo, pivot-1);
     quicksort(data, pivot+1, hi);
   }

 }


}
