package Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Student.Utilities.StudentOrderByAge;
import Student.Utilities.StudentOrderByHeigh;
import Student.Utilities.StudentOrderByName;

public class Student {

	private String nome;
	private Integer idade;
	private Double altura;

	public Student() {

	}

	public Student(String nome, Integer idade, Double altura) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", altura=" + altura + "]";
	}

	/** M�todo de leitura e convers�o do arquivo CSV para uma lista */
	public List<Student> parseList() {

		List<Student> listAluno = new ArrayList<Student>();

		// Caminho do Arquivo
		String path = "C:/eclipse-workspace/OrdenacaoArray/alunos.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// Descarta a primeira linha que seria o cabe�alho
			String line = br.readLine();

			line = br.readLine();

			while (line != null) {

				// Filtrando cont�udo do csv e transformando em vetor
				String[] vect = line.split("[;]");

				for (int i = 0; i < vect.length; i++) {
					// Trocar a , por . no vetor
					vect[i] = vect[i].replace(",", ".");
				}

				// Atribui��o e convers�o de dados se necess�rio do String para tipos da classe
				String nome = vect[0];
				Integer idade = Integer.parseInt(vect[1]);
				Double altura = Double.parseDouble(vect[2]);

				// Cria��o de um novo objeto
				Student aluno = new Student(nome, idade, altura);
				// Adicionando objeto na lista
				listAluno.add(aluno);
				// Lendo uma nova linha para o pr�ximo registro
				line = br.readLine();
			}
//			for (Aluno a : listAluno) {
//				System.out.println("Aluno: " + a);
//			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return listAluno;
	}

	public List<Student> orderByHeigh(List<Student> list) {

		Comparator<Student> comparatorAluno = new StudentOrderByHeigh();
		Collections.sort(list, comparatorAluno);

		for (int i = 0; i < list.size(); i++) {
			printStudent(list, i);
		}

		return list;
	}

	public List<Student> orderByName(List<Student> list) {

		Comparator<Student> comparatorAluno = new StudentOrderByName();
		Collections.sort(list, comparatorAluno);

		for (int i = 0; i < list.size(); i++) {
			printStudent(list, i);
		}

		return list;
	}

	public List<Student> orderByAge(List<Student> list) {

		Comparator<Student> comparatorAluno = new StudentOrderByAge();
		Collections.sort(list, comparatorAluno);

		for (int i = 0; i < list.size(); i++) {
			printStudent(list, i);
		}

		return list;
	}

	public void printStudent(List<Student> list, int i) {
		String name = list.get(i).getNome();
		Integer age = list.get(i).getIdade();
		Double height = list.get(i).getAltura();
		String msg = String.format("Nome: %s: ,Idade: %s, Altura: %.2f", name, age, height);
		System.out.println(msg);
	}

}
