import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Iternary {
	static Map<String, PriorityQueue<String>> map;
	static LinkedList<String> result = new LinkedList<String>();
	public static List<String> findIternary(String[][] tickets){
		
		
		map = new HashMap<>();
		
		for(String[] ticket : tickets){
			map.putIfAbsent(ticket[0], new PriorityQueue<>());
			map.get(ticket[0]).add(ticket[1]);
		}
		
		
		dfs("JFK");
		
		return result;
	}
	
	public static void dfs(String start){
		
		PriorityQueue<String> arrivals = map.get(start);
		while (arrivals != null && !arrivals.isEmpty()){
			dfs(arrivals.poll());
		}
		result.addFirst(start);
		
		
		
	}
	
	
	public static void main(String[] agrs){
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		List<String> path = findIternary(tickets);
		
		path.forEach(x -> System.out.println(x));
	}
}
