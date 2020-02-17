package _200214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	int idx, vote, num;

	public Student(int idx, int num, int vote) {
		super();
		this.idx = idx;
		this.num = num;
		this.vote = vote;
	}

	public int getNum() {
		return this.num;
	}

	@Override
	public int compareTo(Student s) { // 학생 번호를 증가하는 순으로
		if (this.num < s.getNum())
			return -1;
		else if (this.vote > s.getNum()) {
			return 1;
		}
		return 0;
	}
}

public class BJ11713_후보추천하기_김민건 {
	static int N, recommend;
	static ArrayList<Student> photo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 사진 틀
		recommend = Integer.parseInt(br.readLine()); // 추천 번호
		photo = new ArrayList<>();

		boolean check = false;
		int idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < recommend; i++) {
			int num = Integer.parseInt(st.nextToken());

			// 사진틀에 있는 경우 검사
			for (Student s : photo) {
				if (s.num == num) { // 걸려있는 번호인 경우
					s.vote++; // vote 증가
					check = false;
					break;
				}
			}

			// 걸려있지 않은 번호인 경우
			if (check) {
				// 걸 수 있는 자리가 없는 경우
				if (photo.size() == N) {
					Collections.sort(photo, new Comparator<Student>() {
						@Override
						public int compare(Student s1, Student s2) {
							if (s1.vote == s2.vote) // 투표수가 동일한 경우
								return s1.idx - s2.idx;
							else // 동일 하지 않는 경우
								return s1.vote - s2.vote;
						}
					});
					photo.remove(0); // 위의 두경우 모두 오름차순
					photo.add(new Student(idx, num, 1));
					idx++;
				} else {
					// 걸 수 있는 곳이 있는 경우
					photo.add(new Student(idx, num, 1));
					idx++;
				}
			}
			check = true;
		}
		Collections.sort(photo);

		for (int i = 0; i < photo.size(); i++) {
			if (i == photo.size() - 1)
				System.out.print(photo.get(i).num + "");
			else
				System.out.print(photo.get(i).num + " ");
		}
	}
}
