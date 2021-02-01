/*
Question :
There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?
Also note start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Example 1:

Input:
N = 6
S[] = {1,3,0,5,8,5}
F[] = {2,4,6,7,9,9}
Output: 
4
Explanation:
Four meetings can be held with
given start and end timings.

Example 2:

Input:
N = 8
S[] = {75250, 50074, 43659, 8931, 11273,
27545, 50879, 77924}
F[] = {112960, 114515, 81825, 93424, 54316,
35533, 73383, 160252}
Output: 
3
Explanation:
Only three meetings can be held with given start and end timings.
*/

//Solution in JAVA

// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class Driverclass {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Meeting().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class meeting
{
    int start;
    int end;
    int pos;
     
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class mycomparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting o1, meeting o2) 
    {
        if (o1.end < o2.end)
        {
             
            // Return -1 if second object is
            // bigger then first
            return -1;
        }
        else if (o1.end > o2.end)
         
            // Return 1 if second object is
            // smaller then first
            return 1;
             
        return 0;
    }
}

class Meeting {
    
    static int maxMeet(ArrayList<meeting> al,int s)
    {
        ArrayList<Integer> m = new ArrayList<>();
     
        int time_limit = 0;
         
        mycomparator mc = new mycomparator(); 
         
        // Sorting of meeting according to 
        // their finish time.
        Collections.sort(al, mc);
         
        // Initially select first meeting. 
        m.add(al.get(0).pos);
         
        // time_limit to check whether new  
        // meeting can be conducted or not. 
        time_limit = al.get(0).end;
         
        // Check for all meeting whether it  
        // can be selected or not. 
        for(int i = 1; i < al.size(); i++)
        {
            if (al.get(i).start > time_limit)
            {
                 
                // Add selected meeting to arraylist
                m.add(al.get(i).pos);
                 
                // Update time limit
                time_limit = al.get(i).end;
            }
        }
        return m.size();
    }
    
    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i = 0; i < n; i++)
            meet.add(new meeting(start[i], end[i], i));
             
        // Function call 
        return maxMeet(meet, meet.size());
    }
}

/*
Time Complexity : O(N*LogN)
Auxilliary Space Complexity : O(N)
*/
