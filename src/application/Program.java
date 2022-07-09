package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> lessons = new ArrayList<>();

		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		System.out.println();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados da " + i + "a aula:");
			System.out.print("Conte�do ou tarefa (c/t)? ");
			char ct = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("T�tulo: ");
			String title = sc.nextLine();
			if (ct == 'c') {
				System.out.print("URL do v�deo: ");
				String url = sc.nextLine();
				System.out.print("Dura��o em segundos: ");
				int seconds = sc.nextInt();

				lessons.add(new Video(title, url, seconds));
			} else {
				System.out.print("Descri��o: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de Quest�es: ");
				int questionCount = sc.nextInt();

				lessons.add(new Task(title, description, questionCount));
			}
			System.out.println();

		}
		int total = 0;
		for (Lesson les : lessons) {
			total += les.duration();
		}
		System.out.printf("DURA��O TOTAL DO CURSO = %d segundos", total);

		sc.close();
	}

}
