public class Quick{
  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
public static int partition ( int [] data, int start, int end){
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
/*return the value that is the kth smallest value of the array.
*/
public static int quickselect(int []data, int k){
  return 1;
}


}
