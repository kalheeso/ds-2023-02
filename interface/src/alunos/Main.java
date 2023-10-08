package alunos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<Aluno>();
		
		alunos.add(new Aluno("Matheus", "Geraldino de Melo", 20, 6.0, 202105048));
		alunos.add(new Aluno("Felipe", "Moreira", 21, 7.0, 202105032));
		alunos.add(new Aluno("Lucas", "Bernarder", 20, 8.0, 202105040));
		
		Collections.sort(alunos, AlunoComparators.AlunoNomeComparator);
	}

}
