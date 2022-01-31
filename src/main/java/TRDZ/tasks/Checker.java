package TRDZ.tasks;

public class Checker {

	/**
	 * Проверка размернгости матрицы на соотвествие условию
	 * @param error Флаг предварительной ошибки ввода
	 * @param weight количество столбцов
	 * @param height количество строк
	 * @throws Exception Обьявление ошибки размерности
	 */
	public static void inRange(boolean error,int weight, int height) throws Exception{
		if (error || (weight < 1) || (height < 1))
			{throw new Exception("Введено некоректное значение! Размерность должна быть числом большим 0");}
		}

	/**
	 * Проверка размернгости матрицы на соотвествие условию
	 * @param matrix Проверяемая матрица
	 * @throws Exception Обьявление ошибки размерности
	 */
	public static void isValid(String[][] matrix)  throws Exception {
		if (matrix.length!=4 || matrix[0].length!=4)
			{throw new Exception("Обработчик матриц 4х4 получил на вход матрицу другой размерности");}
		}

	/**
	 * Проверка строкового значения матрицы на возможность перевода в число V1
	 * @param element элемент
	 * @param i номер колонки элемента
	 * @param j номер строки элемента
	 * @throws MatrixException Обьявление ошибки с выгрузкой координат ошибки и выделением неверного фрагмента
	 */
	public static void isNumeric_V1(String element,int i, int j)  throws MatrixException {
		int e = 0;
		StringBuilder res = new StringBuilder(""); 	//Создаем хранилище для неправильных символов
		boolean error=false;
		if (element.charAt(0)== "-".charAt(0)) { //Проверяем на отрицательно значение
			res.append("_");
			e = 1;
			}
		for (; e < element.length(); e++) { 	//Проверяем все символы предпологаемого числа
			if ((((char)48) > element.charAt(e)) || (((char)57) < element.charAt(e))) {
				error=true;
				res.append(element.charAt(e));
				}
			else {
			res.append("_");}
			}
		if (error) throw new MatrixException("Значение ячейки элемента["+(1+i)+"]["+(1+j)+"] полностью или частично не явдяется числом.",i,j, res.toString());
		}

	/**
	 * Проверка строкового значения матрицы на возможность перевода в число V2
	 * @param element элемент
	 * @param i номер колонки элемента
	 * @param j номер строки элемента
	 * @throws MatrixException Обьявление ошибки с выгрузкой координат ошибки но без выделения неверного фрагмента
	 */
	public static void isNumeric_V2(String element,int i, int j)  throws MatrixException {
		try {Integer.parseInt( element );}
		catch( Exception ignored ) {
			throw new MatrixException("Значение ячейки элемента["+(1+i)+"]["+(1+j)+"] полностью или частично не явдяется числом.",i,j, "\"Данная версия проверки не поддерживает маску ошибки\"");
			}
		}

	/**
	 * Проверка строкового значения матрицы на возможность перевода в число с лучшей оптимизацией
	 * @param element элемент
	 * @param i номер колонки элемента
	 * @param j номер строки элемента
	 * @throws MatrixException Наибыстрейшее выявление бьявление ошибки с выгрузкой координат но без выделения неверного фрагмента
	 */
	public static void isNumeric_V3(String element,int i, int j)  throws MatrixException {
		int e = 0;
		if (element.charAt(0)== "-".charAt(0)) {e = 1;}
		for (; e < element.length(); e++) {
			if ((((char)48) > element.charAt(e)) || (((char)57) < element.charAt(e))) {
				throw new MatrixException("Значение ячейки элемента["+(1+i)+"]["+(1+j)+"] полностью или частично не явдяется числом.",i,j, "\"Данная версия проверки не поддерживает маску ошибки\"");
				}
			}
		}
	}
