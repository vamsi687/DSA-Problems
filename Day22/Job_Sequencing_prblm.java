/*
Question :
Given a set of N jobs where each job i has a deadline and profit associated to it. Each job takes 1 unit of time to complete and only
one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the 
maximum profit and the number of jobs done.

Note: Jobs will be given in the form (Job id, Deadline, Profit) associated to that Job.

Example 1:

Input:
N = 4
Jobs = (1,4,20)(2,1,10)(3,1,40)(4,1,30)
Output:
2 60
Explanation:
2 jobs can be done with
maximum profit of 60 (20+40).

Example 2:

Input:
N = 5
Jobs = (1,2,100)(2,1,19)(3,2,27)
(4,1,25)(5,1,15)
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).
*/

//Solution in JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            //function call
            int[] res = new solve().JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}

class myComparator implements Comparator<Job>
{
    @Override
    public int compare(Job j1,Job j2)
    {
        //to sort in decreasing order
        if(j1.profit > j2.profit)
            return -1;
        else if(j1.profit < j2.profit)
            return 1;
        return 0;
    }
}


class solve{  
    
    // return an array of size 2 having the 0th element equal to the count
    // and 1st element equal to the maximum profit
    int[] JobScheduling(Job arr[], int n)
    {
        List<Job> jobList = Arrays.asList(arr);
        myComparator comp = new myComparator();
        //sort in decreasing order based on the comparator
        Collections.sort(jobList,comp);
        int count=0,profit = 0;
        //to track the slots available
        boolean[] slot = new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            //Find a free slot for this job, start from the last possible slot
            for(int j=Math.min(n-1,jobList.get(i).deadline-1);j>=0;j--)
            {
                //if slot available, increment the count and profit and assign the job to that slot by making it to true
                if(slot[j] == false)
                {
                    count++;
                    profit += jobList.get(i).profit;
                    slot[j] = true;
                    break;
                }
            }
        }
        return new int[]{count,profit};
    }
}

