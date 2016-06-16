package benkyokai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	//List<Student> students 学生のリスト
	//String 名前、String 学籍番号（入学年度+個人番号）、List<String> 履修科目、Map<String, Integer> 履修科目と点数
	//名前、学籍番号、科目と点数
	//奥田、2016001、(数学、70)(英語、70)
	//安部、2016002、(数学、80)(英語、60)(化学、75)
	//手島、2016003、(数学、60)(英語、85)(化学、70)
	//堀内、2015001、(数学、65)(英語、75)(化学、80)(物理、70)
	//川西、2015002、(数学、75)(英語、55)(化学、60)(物理、75)
	
	List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
	
	System.out.println("学生のリストを表示");
	//拡張for文
	for(Student student : students) {
		System.out.println(student.toString());
	}
	//forEach を使って書いてみる
//	students.forEach(new Consumer<Student>(){
//		@Override
//	...
//	});
	//ラムダ式を使って書いてみる
//	students.forEach(student -> 
//	...

	System.out.println("英語の点数が80点以上の生徒はいますか？");
	boolean exists = false;
//	exists = students.stream()
//			...
	System.out.println(exists);
	
	System.out.println("数学の平均点は？");
	double ave = 0;
//	dve = students.stream()
//			...	
	System.out.println(ave);

	System.out.println("2016年入学で数学の点数順に並べられた生徒の名前のリストは？");
	List<String> studentsOrderByPerformanceOfMath = new ArrayList<>();
//	studentsOrderByPerformanceOfMath = students.stream()
//			...;
	
	studentsOrderByPerformanceOfMath.forEach(student -> System.out.println(student));

	}
}

