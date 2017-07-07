package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Find the first circular tour that visits all petrol pumps
 * =========================================================
 * Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.
        1. The amount of petrol that every petrol pump has.
        2. Distance from that petrol pump to the next petrol pump.

 * Calculate the first point from where a truck will be able to complete the circle (The truck will
 * stop at each petrol pump and it has infinite capacity). Expected time complexity is O(n). Assume
 * for 1 litre petrol, the truck can go 1 unit of distance.

 * For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump
 * value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make a
 * circular tour is 2nd petrol pump. Output should be “start = 1” (index of 2nd petrol pump).
 *
 *
 * A Simple Solution: is to consider every petrol pumps as starting point and see if there is a possible
 * tour. If we find a starting point with feasible solution, we return that starting point. The worst
 * case time complexity of this solution is O(n^2).

 * We can use a Queue to store the current tour. We first enqueue first petrol pump to the queue, we
 * keep enqueueing petrol pumps till we either complete the tour, or current amount of petrol becomes
 * negative. If the amount becomes negative, then we keep dequeueing petrol pumps till the current amount
 * becomes positive or queue becomes empty.

 * Instead of creating a separate queue, we use the given array itself as queue. We maintain two index
 * variables start and end that represent rear and front of queue.
 *
 *
 * Created by agebriel on 7/6/17.
 */
public class CircularTourToVisitPetrolPumps
{
	private static class PetrolPump
	{
		public int petrol, distance;
		public PetrolPump(int p, int d)
		{
			petrol = p;
			distance = d;
		}
	}

	// The function returns starting point if there is a possible solution,
	// otherwise returns -1
	private static int printTour(PetrolPump[] arr)
	{
		// Consider first petrol pump as a starting point
		int start = 0;
		int end = 1;

		int curr_petrol = arr[start].petrol - arr[start].distance;

    /* Run a loop while all petrol pumps are not visited.
      And we have reached first petrol pump again with 0 or more petrol */
		while (end != start || curr_petrol < 0)
		{
			// If current amount of petrol in truck becomes less than 0, then
			// remove the starting petrol pump from tour
			while (curr_petrol < 0 && start != end)
			{
				// Remove starting petrol pump. Change start
				curr_petrol -= curr_petrol;
				start = (start + 1)%arr.length;

				// If 0 is being considered as start again, then there is no
				// possible solution
				if (start == 0)
					return -1;
			}

			// Add a petrol pump to current tour
			curr_petrol += arr[end].petrol - arr[end].distance;

			end = (end + 1)%arr.length;
		}

		// Return starting point
		return start;
	}

	public static void main(String[] args)
	{
		//PetrolPump arr[] = {new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3)};
		//PetrolPump arr[] = {new PetrolPump(3, 6), new PetrolPump(6, 4), new PetrolPump(7, 3)};
		PetrolPump arr[] = {new PetrolPump(4, 6), new PetrolPump(6, 5),
			new PetrolPump(7, 3), new PetrolPump(4, 5)};

		int start = printTour(arr);

		if(start == -1)
			System.out.println("No solution");
		else
			System.out.println("Start = " + start);
	}
}
