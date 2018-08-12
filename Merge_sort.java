/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge_sort;

import java.util.Scanner;

/**
 *
 * @author purushottam
 */
public class Merge_sort {

    public static void merge(int []arr,int lower,int mid,int high)
    {
        int n1 = mid - lower+1;
        int n2 = high - mid;
        int []left_arr = new int[n1];           //creating temporary array
        int []right_arr = new int[n2];
        
        for(int i = 0;i<n1;i++){
            left_arr[i] = arr[lower+i];            //manually copying the array element
        }
       
        for(int j = 0;j<n2;j++){
            right_arr[j] = arr[mid+j+1];
        }
       
        int i = 0,j=0,k=lower;
        
        while(i<n1 && j<n2){                                //merging the element from temp array to original array
                if(left_arr[i]<right_arr[j]){
                    arr[k++] = left_arr[i++];                  
                }
                else{
                    arr[k++] = right_arr[j++];                
                }
            }
        
        while(i<n1){
            arr[k++] = left_arr[i++];
        }
        
        while(j<n2){
            arr[k++] = right_arr[j++];
        }
    }
    
    public static void merge_sorting(int []arr,int low,int high)
    {
        if(low<high){
        int mid = (high+low)/2;
        merge_sorting(arr,low,mid);                          //recursivelly sorting the array element
        merge_sorting(arr,mid+1,high);
        merge(arr,low,mid,high);                            //calling merge method
        }
        
        
    }
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("****************Enter number of Elements to sort*********************");
            int n =sc.nextInt();
            int []arr = new int[n];
            System.out.println("****************Enter Elements to sort*********************");
            for(int i = 0;i<n;arr[i++] = sc.nextInt());
            System.out.println("****************Elements before sorting are*********************");
            for(int i =0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println("\n****************************************************************");
            Merge_sort.merge_sorting(arr,0,n-1);
            System.out.println("****************Elements after sorting are*********************");
            for(int i =0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println("\n****************************************************************");
            sc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
}
