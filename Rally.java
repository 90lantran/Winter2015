import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Rally {
	
	
	
	
	public static void main(String[] args){
		String s = "abc			d";
		String[] t = s.split("\t");
		for(String x : t) System.out.println(x);
		
		//Scanner sc = new Scanner(System.in);
		String fileName = "input.txt";
		
		Map<Integer, HashSet<String>> mission2Employee = new LinkedHashMap<>();
		Map<String, HashSet<Integer>> employee2Mission = new LinkedHashMap<>();
		Map<Integer, Integer> mission2OtherMission = new LinkedHashMap<Integer, Integer>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			br.readLine();
			String line;
			while((line = br.readLine()) != null){
				String[]  stringArr = line.split(" ");
				mission2Employee.putIfAbsent(Integer.parseInt(stringArr[0]), new HashSet<String>());
				mission2Employee.get(Integer.parseInt(stringArr[0])).add(stringArr[1]);
				
				employee2Mission.putIfAbsent(stringArr[1], new HashSet<Integer>());
				employee2Mission.get(stringArr[1]).add(Integer.parseInt(stringArr[0]));
			}
			printMap(mission2Employee);
			printMap(employee2Mission);
			for(Entry<Integer, HashSet<String>> entry : mission2Employee.entrySet()){
				HashSet<String> employees = entry.getValue();
				HashSet<Integer> otherMission = new HashSet<>();
				for(String name : employees){
					//otherMission += employee_Mission.get(name).size() - 1;
					otherMission.addAll(employee2Mission.get(name));
				}
				mission2OtherMission.put(entry.getKey(), otherMission.size() -1);
			}
			
			printMap(mission2OtherMission);
			
			br.close();
			
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e){
			
		}
	}
	
	private static <K,V>void printMap(Map<K, V> m){
		for (Entry<K, V> entry : m.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
			
		}
	}
}
