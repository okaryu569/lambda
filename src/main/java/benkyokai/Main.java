package benkyokai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class Main {

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {

	Student student1 = new Student("奥田", "2016001", Arrays.asList("Math", "English"));
	student1.setPerformances(Pair.of("Math", 70), Pair.of("English", 70));
	Student student2 = new Student("安部", "2016002", Arrays.asList("Math", "English", "Chemistry"));
	student2.setPerformances(Pair.of("Math", 80), Pair.of("English", 60), Pair.of("Chemistry", 75));
	Student student3 = new Student("手島", "2016003", Arrays.asList("Math", "English", "Chemistry"));		
	student3.setPerformances(Pair.of("Math", 60), Pair.of("English", 85), Pair.of("Chemistry", 70));
	Student student4 = new Student("堀内", "2015001", Arrays.asList("Math", "English", "Chemistry", "Pysics"));     
	student4.setPerformances(Pair.of("Math", 65), Pair.of("English", 75), Pair.of("Chemistry", 80), Pair.of("Pysics", 70));
	Student student5 = new Student("川西", "2015002", Arrays.asList("Math", "English", "Chemistry", "Pysics"));			
	student5.setPerformances(Pair.of("Math", 75), Pair.of("English", 55), Pair.of("Chemistry", 60), Pair.of("Pysics", 75));
	
	//List<Student> students 学生のデータのリスト
	//String 名前、String 学籍番号（入学年度+個人番号）、List<String> 履修科目、Map<String, Integer> 履修科目と点数
	//名前、学籍番号、科目と点数
	//奥田、2016001、(数学、70)(英語、70)
	//安部、2016002、(数学、80)(英語、60)(化学、75)
	//手島、2016003、(数学、60)(英語、85)(化学、70)
	//堀内、2015001、(数学、65)(英語、75)(化学、80)(物理、70)
	//川西、2015002、(数学、75)(英語、55)(化学、60)(物理、75)
	
	List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
	
	System.out.println("01, 学生のリストを表示してください");
	//拡張for文
	for(Student student : students) {
		System.out.println(student.toString());
	}
	//forEach を使って書いてみる　(匿名メソッド)
	students.forEach(new Consumer<Student>(){
		@Override
		public void accept(Student student) {
			System.out.println(student.toString());

		}
	});
	//forEach を使って書いてみる　(ラムダ式)
	students.forEach(student -> System.out.println(student.toString()));

	System.out.println("02, 英語の点数が80点以上の生徒はいますか？");
	boolean exists;
	exists = students.stream()
			.anyMatch(student -> student.getPerformances().get("English") >= 80 );			
	System.out.println(exists);
	
	System.out.println("03, 数学の最高点をとったのは誰ですか？");
	Student st;
	st = students.stream()
			.collect(Collectors.maxBy((student, st2) -> student.getPerformances().get("Math") - st2.getPerformances().get("Math")))
			.get();		
	System.out.println(st);
	
	System.out.println("04, 科目情報を取り除き、名前と学籍番号だけのリストを作ってください");
	List<Pair<String, String>> list01 = new ArrayList<>();
	list01 = students.stream()
			.map(student -> Pair.of(student.getName(), student.getNo()))
			.collect(Collectors.toList());			
	list01.forEach(pair -> System.out.println(pair.toString()));
	
	System.out.println("05, 2016年入学で,数学の点数順に並べられた,生徒の名前のリストを作ってください");
	List<String> list02 = new ArrayList<>();
	list02 = students.stream()
			.filter(student -> student.getNo().startsWith("2016"))
			.sorted(Comparator.comparing(student -> student.getPerformances().get("Math")))
			.map(student -> student.getName())
			.collect(Collectors.toList());			
	list02.forEach(name -> System.out.println(name));	

	System.out.println("EX, 3科目以上受講している人の名前と平均点のリストを作ってください");
	List<Pair<String, Double>> listEX = new ArrayList<>(); //余裕のある人は List<Pair<String, Double>> ではなく Map<String, Double> にしてみましょう
	listEX = students.stream()
			.filter(student -> student.getLessons().size() >= 3)
			.map(student -> Pair.of(student.getName(), 
					student.getPerformances().values().stream().collect(Collectors.averagingDouble(p -> p))))
			.collect(Collectors.toList());
			
	listEX.forEach(pair -> System.out.println(pair.toString()));
    }
}

