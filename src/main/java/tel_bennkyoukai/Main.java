package tel_bennkyoukai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

	Student student1 = new Student("鈴木", "2016001", Arrays.asList("Math", "English"));
	student1.setPerformance("Math", 70);
	student1.setPerformance("English", 70);
	Student student2 = new Student("田中", "2016002", Arrays.asList("Math", "English"));		
	student2.setPerformance("Math", 80);
	student2.setPerformance("English", 60);
	Student student3 = new Student("斎藤", "2016003", Arrays.asList("Math", "English"));		
	student3.setPerformance("Math", 60);
	student3.setPerformance("English", 85);
	Student student4 = new Student("小林", "2015001", Arrays.asList("Math", "English"));		
	student4.setPerformance("Math", 75);
	student4.setPerformance("English", 75);

	//生徒のリスト
	//名前、生徒番号、履修科目と点数
	//鈴木、2016001、(数学、70)(英語、70)
	//田中、2016002、(数学、80)(英語、60)
	//斎藤、2016003、(数学、60)(英語、85)
	//小林、2015001、(数学、75)(英語、75)
	
	List<Student> students = Arrays.asList(student1, student2, student3, student4);
	
	System.out.println("生徒のリストを表示");
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
//	students.forEach(student -> ...
	
	System.out.println("2016年入学で数学の点数順に並べられた生徒の名前のリストは？");

	List<String> studentsOrderByPerformanceOfMath = new ArrayList<>();
//	studentsOrderByPerformanceOfMath = students.stream()
//			...;
	
	studentsOrderByPerformanceOfMath.forEach(student -> System.out.println(student));
	
	System.out.println("英語の点数が80点以上の生徒はいますか？");
	boolean exists = false;
//	exists = students.stream()
//			...
	
	System.out.println(exists);
	
	}
}

