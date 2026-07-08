import model.Aluno;
import service.AlunoService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Prova da primeira Unidade!");
        
        Aluno a = new Aluno();                  //questao 3 A
        a.setId(1);                         //questao 3 A
        a.setMatricula("2025001");   //questao 3 A
        a.setNome("João");                //questao 3 A
        a.setResponsavel("Pedro"); //questao 3 A
        a.setContato("77999310000");   //questao 3 A
        a.setEmail("joao@mail.com");    //questao 3 A

        System.out.println("Nome: " + a.getNome() + " telefone: " + a.getContato());
        
        System.out.println(a); //questao 2

        //AlunoService service = new AlunoService(); //questao 3
        //service.salvar();                          //questao 3 B

        //Aluno b = new Aluno("2025002", "Ana", "Maria", "77999310999", "joao@mail.com");
        //service.salvar(b);
        //service.excluir(1);

        //System.out.println(service.buscarTodos().toString());

        System.out.println("Fim da Prova!");
    }
}
