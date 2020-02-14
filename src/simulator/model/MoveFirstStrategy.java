package simulator.model;

import java.util.ArrayList;
import java.util.List;

public class MoveFirstStrategy implements DequeuingStrategy {

	public MoveFirstStrategy() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Vehicle> dequeue(List<Vehicle> q) {
		
		List<Vehicle> l = new ArrayList<Vehicle>();
		l.add(q.get(0));
		
		return l;
	}

}
