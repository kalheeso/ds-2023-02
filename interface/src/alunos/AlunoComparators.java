package alunos;
import java.util.Comparator;

public class AlunoComparators {
	
    public static Comparator<Aluno> AlunoNomeComparator = new Comparator<Aluno>() {

		@Override
		public int compare(Aluno o1, Aluno o2) {
			return o1.getNome().compareTo(o2.getNome());
		}
    };
    
    public static Comparator<Aluno> AlunoIdadeComparator = new Comparator<Aluno>() {

		@Override
		public int compare(Aluno o1, Aluno o2) {
			return o1.getIdade() - o2.getIdade();
		}
    };
    
    public static Comparator<Aluno> AlunoSobrenomeComparator = new Comparator<Aluno>() {

		@Override
		public int compare(Aluno o1, Aluno o2) {
			return o1.getSobrenome().compareTo(o2.getSobrenome());
		}
    };
    
    public static Comparator<Aluno> AlunoMatriculaComparator = new Comparator<Aluno>() {

		@Override
		public int compare(Aluno o1, Aluno o2) {
			return o1.getMatricula() - o2.getMatricula();
		}
    };
    
    public static Comparator<Aluno> AlunoMediaComparator = new Comparator<Aluno>() {

		@Override
		public int compare(Aluno o1, Aluno o2) {
			return (int) (o1.getMedia() - o2.getMedia());
		}
    };
}
