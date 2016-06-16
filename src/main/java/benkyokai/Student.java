package benkyokai;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.lang3.tuple.Pair;

public class Student {
	private String name;
	private String no;
	private List<String> lessons;
	private Map<String, Integer> performancies = new HashMap<>();
	
	public Student(String name, String no, List<String> lessons) {
		super();
		this.name = name;
		this.no = no;
		this.lessons = lessons;
		lessons.forEach(lesson -> {
			this.performancies.put(lesson, 0);
		});
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNo() {
		return no;
	}
	
	public void setNo(String no) {
		this.no = no;
	}
	
	public List<String> getLessons() {
		return lessons;
	}
	
	public void setLessons(List<String> lessons) {
		this.lessons = lessons;
		lessons.forEach(lesson -> {
			if(!this.performancies.containsKey(lesson)) {
				this.performancies.put(lesson, 0);
			}
		});
	}

	public Map<String, Integer> getPerformances() {
		return performancies;
	}
	
	public void setPerformance(String lesson, Integer performance) {
		if(this.performancies.containsKey(lesson)) {
			this.performancies.replace(lesson, performance);
		} else {
			this.performancies.put(lesson, performance);
		}	
	}

    public void setPerformances(Pair<String, Integer>... performances) {
	    Stream.of(performances).forEach(p -> this.setPerformance(p.getKey(), p.getValue()));
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", no=" + no + ", lessons=" + lessons + ", performances=" + performancies
				+ "]";
	}
	
	
}
