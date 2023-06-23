/*
Q3. Minimum Platforms
Given arrival and departure times of all trains that reach a railway station. Find the minimum number
of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure
time can never be the same for a train but we can have arrival time of one train equal to departure time
of the other. At any given instance of time, same platform can not be used for both departure of a train
and arrival of another train. In such cases, we need different platforms.
__________________________________________________________________________________________________________________
Input 1:
n = 6
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output 1:
3
 */
import java.util.Arrays;
import java.util.Scanner;
            public class Main {
                static int Minimum_Track(int[] arrival, int[] leaving , int numberOfTrain){
                    Arrays.sort(arrival);
                    Arrays.sort(leaving);
                    int coming = 1,going = 0 , track = 1 , maximumTrack = 1;
                    while (coming < numberOfTrain && going < numberOfTrain){
                        if (arrival[coming] <= leaving[going]){
                            coming++;
                            track++;
                        } else if (arrival[coming] > leaving[going]) {
                            track--;
                            going++;
                        }
                        if (track > maximumTrack)
                            maximumTrack = track;
                    }
                    return  maximumTrack;
                }
                public static void main(String[] args) {
                    Scanner input = new Scanner(System.in);
                    int TotalNumberOfTrain,start;
                    System.out.println("Enter the Total number of train :");
                    TotalNumberOfTrain = input.nextInt();
                    System.out.println("Enter the arrival timing of train");
                    int[] arrivalTime = new int[TotalNumberOfTrain];
                    for (start = 0; start < arrivalTime.length; start++){
                        arrivalTime[start] = input.nextInt();
                    }
                    System.out.println("Enter the gaining time of train :");
                    int[] leavingTime = new int[TotalNumberOfTrain];
                    for (start = 0; start < arrivalTime.length; start++){
                        leavingTime[start] = input.nextInt();
                    }
                    System.out.println("Printing the result :");
                    System.out.println(Minimum_Track(arrivalTime,leavingTime,TotalNumberOfTrain));

                }
            }

