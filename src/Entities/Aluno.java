package Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Utilities.StudentOrderByHeigh;
import Utilities.StudentOrderByName;

public class Aluno extends StudentOrderByHeigh {

	private String nome;
	private Integer idade;
	private Double altura;

	public Aluno() {

	}

	public Aluno(String nome, Integer idade, Double altura) {
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

	/**Método de leitura e conversão do arquivo CSV para uma lista */
	public List<Aluno> parseList() {

		List<Aluno> listAluno = new ArrayList<Aluno>();
		
		//Caminho do Arquivo
		String path = "C:/eclipse-workspace/OrdenacaoArray/alunos.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// Descarta a primeira linha que seria o cabeçalho
			String line = br.readLine();

			line = br.readLine();
			
			while (line != null) {
				
				// Filtrando contéudo do csv e transformando em vetor
				String[] vect = line.split("[;]");
				
				for (int i = 0; i < vect.length; i++) {
                    //Trocar a , por . no vetor
                    vect[i] = vect[i].replace(",", ".");
                }
				
				//Atribuição e conversão de dados se necessário do String para tipos da classe
				String nome = vect[0];
				Integer idade = Integer.parseInt(vect[1]);
				Double altura = Double.parseDouble(vect[2]);

				//Criação de um novo objeto
				Aluno aluno = new Aluno(nome, idade, altura);
				//Adicionando objeto na lista
				listAluno.add(aluno);
				//Lendo uma nova linha para o próximo registro
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

	public List<Aluno> orderByHeigh(List<Aluno> list){
		
		Comparator<Aluno> comparatorAluno = new StudentOrderByHeigh();
		Collections.sort(list, comparatorAluno);
		
		for(int i=0; i< list.size(); i++) {
			System.out.println("Nome: " + list.get(i).getNome());
			System.out.println("Idade: "+list.get(i).getIdade());
			System.out.println("Altura: "+list.get(i).getAltura());
		}
		 
		return list;
	}
	
	public List<Aluno> orderByName(List<Aluno> list){
		
		Comparator<Aluno> comparatorAluno = new StudentOrderByName();
		Collections.sort(list, comparatorAluno);
		
		for(int i=0; i< list.size(); i++) {
			System.out.println("Nome: " + list.get(i).getNome());
			System.out.println("Idade: "+list.get(i).getIdade());
			System.out.println("Altura: "+list.get(i).getAltura());
		}
		 
		return list;
	}	
	
}
