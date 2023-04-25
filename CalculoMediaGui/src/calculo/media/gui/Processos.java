package calculo.media.gui;

import java.awt.Color;
import java.util.ArrayList;

public class Processos {
	
	ArrayList<Pessoa> listaPessoa;
	public Processos() {
		listaPessoa = new ArrayList<Pessoa>();
	}
	
	public double calcularMedia(double n1, double n2, double n3) {
		double med = (n1 + n2 + n3)/3;
		
		return med;
	}

	public String calcularDefinitiva(double media) {
		
		if(media >= 3.5) {
			return "Passou";
		}
		else {
			return "Reprovou";
		}
		
	}

	public double calcularMedia(Pessoa est) {
		double med = (est.getNota1() + est.getNota2() + est.getNota3())/3;
		
		return med;
	}

	public void registrarEmBd(Pessoa estudante) {
		System.out.println("registrado no BD");
		
		//System.out.println(estudante);
		listaPessoa.add(estudante);
		
	}

	public void imprimirEstudantes() {
		for(Pessoa pessoa : listaPessoa) {
			System.out.println(pessoa);
		}
		
	}

	public Pessoa obterEstudante(String doc) {
		Pessoa p = null;
		for(Pessoa pessoa : listaPessoa) {
			if(pessoa.getDocumento().equals(doc)) {
				p =  pessoa;
			}
			
		}
		return p;
	}
}
