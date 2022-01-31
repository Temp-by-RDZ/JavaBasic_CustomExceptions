package TRDZ.tasks;

import java.util.Scanner;

public class Initialization {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[][] Matrix=create_Matrix();	//Создаем матрицу
		show_Matrix(Matrix);				//Отображаем матрицу в полном виде
		System.out.println("\nМатрица отправляется в Обработчик сумм значений матриц 4х4...\n");
		Analyze_4x4(Matrix);				//Отправляем матрицу на обработку
		System.out.println("Конец работы.");
		}

	/**
	 * Модуль суммирующий все элементы строковой Матрицы 4х4
	 * @param Matrix поступающая матрица
	 */
	public static void Analyze_4x4(String[][] Matrix) {
		try {Checker.isValid(Matrix);}
		catch (Exception exception) {
			System.out.println("Ошибка передачи матрицы в обработчик!");
			System.out.println(exception.getMessage());
			return;
			}
		int Summ=0;
		for (int i=0; i<Matrix.length; i++) {
			for (int j=0; j<Matrix[i].length; j++) {
				try {Checker.isNumeric_V1(Matrix[i][j],i,j);}
				catch (MatrixException exception) {
					System.out.println("При обработке элемента["+(i+1)+"]["+(j+1)+"] произошла ошибка");
					System.out.println(exception.getMessage());
					System.out.printf("Данные о ошибке: x=%d y=%d el=%s где маска ошибки %s\n\n",exception.get_X(),exception.get_y(),Matrix[i][j],exception.get_Result());
					continue;
					}
				Summ+=Integer.parseInt(Matrix[i][j]);
				}
			}
		System.out.println("\nСумма элементов матрицы равна "+Summ);
		}

	/**
	 * Создание строковой матрицы
	 * @return матрица
	 */
	public static String[][] create_Matrix() {
		int weight=0;
		int height=0;
		while (!((weight > 0) && (height > 0))) {
		weight=0;
		height=0;
			boolean error = false;
			System.out.println("Введите маштабность вашей матрицы через пробел>>>");
			if (scanner.hasNextInt()) { //Проверка на некоректный ввод
				height = scanner.nextInt();
				if (scanner.hasNextInt()) {weight = scanner.nextInt();}
				else {error = true; scanner.nextLine();}
				}
			else {error = true; scanner.nextLine();}
			try	{Checker.inRange(error,weight,height);}
			catch (Exception exception) {
				System.out.println("Ошибка ввода размерности!");
				System.out.println(exception.getMessage()+"\n");
				}
			}
		String[][] Matrix=new String[weight][height];
		for (int i=0; i<Matrix.length; i++) {
			for (int j=0; j<Matrix[i].length; j++) {
				System.out.println("Введите значение ["+(i+1)+"]["+(j+1)+"] матрицы");
				Matrix[i][j]=scanner.next();
				}
			}
		return Matrix;
		}

	/**
	 * Отображение матрицы
	 * @param Matrix матрица
	 */
	public static void show_Matrix(String[][] Matrix) {
		System.out.println("Матрица:");
		for (String[] line : Matrix) {
			for (String element : line) {System.out.printf("%-5s",element);}
			System.out.println("");
			}
		}

	}
