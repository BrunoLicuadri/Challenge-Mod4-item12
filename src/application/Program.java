package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Lesson> lesson = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso?");
		int n = sc.nextInt();
		System.out.println();

		
		for (int i = 0; i<n; i++) {
			System.out.println("Dados da " + (1+i) + "aula: ");
			System.out.print("Conteúdo ou Tarefa (c/t)?: ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Título: ");
			String title = sc.nextLine();
			if (type == 'c') {
				System.out.print("url: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				
				lesson.add(new Video(title, url, seconds));
			}
			else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questCount = sc.nextInt();
				
				lesson.add(new Task(title, description, questCount));
			}
		}
			System.out.println();
			
			int totalSec = 0;
			for (Lesson sec : lesson) {
				totalSec += sec.duration();
			}
			
			System.out.println("DURAÇÃO TOTAL DO CURSO =" + totalSec);

		sc.close();

	}

}
