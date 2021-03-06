package code.prep.hackerrank.algorithms.dataStructures;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Problem Statement
 * For an upcoming programming contest, Roy is forming some teams from the n students of his university. 
 * A team can have any number of contestants.
 * 
 * Roy knows the skill level of each contestant. To make the teams work as a unit, he should ensure that 
 * there is no skill gap between the contestants of the same team. In other words, if the skill level of a 
 * contestant is x, then he has either the lowest skill level in his team or there exists another contestant 
 * with skill level of x−1 in the same team. Also, no two contestants of the same team should have same skill 
 * level. Note that a contestant can write buggy code and thus can have a negative skill level.
 * 
 * The more contestants on the team, the more problems they can attempt at a time. So, Roy wants to form 
 * teams such that the smallest team is as large as possible.
 * 
 * Input Format
 * The first line of input contains t (1≤t≤100), the number of test cases.
 * Each case contains an integer n (0≤n≤105), the number of contestants, followed by n space separated integers. 
 * The ith integer denotes the skill level of ith contestant. The absolute values of skill levels will not exceed 
 * 109.
 * The total number of contestants in all cases will not exceed 106.
 * 
 * Output Format
 * For each test case, print the size of smallest team in a separate line.
 * 
 * Sample Input
 * 4  
 * 7 4 5 2 3 -4 -3 -5  
 * 1 -4  
 * 4 3 2 3 1  
 * 7 1 -2 -3 -4 2 0 -1  
 * 
 * Sample Output
 * 3
 * 1
 * 1
 * 7
 * 
 *
 */

public class TeamFormation 
{
	private static ArrayList<Integer> buildTeam(ArrayList<Integer> team, int skill)
	{
		ArrayList<Integer> newTeam = new ArrayList<Integer>();
		newTeam.add(skill);
		
		for (int player : team)
		{
			if (skill == (player + 1))
			{
				newTeam.add(player);
			}
		}
		
		return newTeam;
	}
	
	private static boolean canBuildTeam(ArrayList<Integer> team, int skill)
	{
		boolean canBuildTeam = false;
		
		for (int player : team)
		{
			if (skill == (player + 1))
			{
				canBuildTeam = true;
				break;
			}
		}
		return canBuildTeam;
	}
	
	private static void printSmallestTeam(ArrayList<ArrayList<Integer>> teams)
	{
		int tmp;
		int smallest = teams.get(0).size();
		
		for (int i = 1; i < teams.size(); ++i)
		{
			tmp = teams.get(i).size();
			if (tmp < smallest)
			{
				smallest = tmp;
			}
		}
		
		System.out.println(smallest);
	}
	
	private static void findSmallestTeam(ArrayList<Integer> team)
	{
		ArrayList<ArrayList<Integer>> teams = new ArrayList<ArrayList<Integer>>();
		
		for (int player : team)
		{
			if (canBuildTeam(team, player))
			{
				teams.add(buildTeam(team, player));
			}
		}
		
		printSmallestTeam(teams);
	}

	public static void main(String[] args)
	{
		int  			   i, n, t;
		Scanner 		   scanner = new Scanner(System.in);
		ArrayList<Integer> team = new ArrayList<Integer>();
		
		t = scanner.nextInt();
		while (t > 0)
		{
			n 	 = scanner.nextInt();
			for (i = 0; i < n; ++i)
			{
				team.add(scanner.nextInt());
			}
			
			findSmallestTeam(team);
			--t;
		}
		
		scanner.close();
	}
}
