import java.sql.Connection;

import dao.factories.ConexaoFactory;
import dao.factories.ContatoMySqlDAO;
import dao.factories.IContatoDAO;
import domain.ContatoVO;
import repositories.ContatoMySqlRepository;
import repositories.IContatoRepository;
import services.ContatoService;
import services.IContadoService;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         * Este conjunto de instruções inicializaram as dependencias 
         * para o uso do serviço de contatos utilizando o repositório
         * com o SGBD MySQL.
         */
        Connection conexao = ConexaoFactory.getConexao();
        IContatoDAO dao = new ContatoMySqlDAO(conexao);
        IContatoRepository repository = new ContatoInMemoryRepository();

        IContadoService service = new ContatoService(repository);

        // Criar objeto ContatoVO e realizar chamada do metodo salvar do service
        ContatoVO c1 = new ContatoVO(
                null,
                "João Pedro Ferreira",
                "jpferreira@gmail.com",
                "19999997878",
                "jpferreira_li");

        // Chamada do metodo de persistencia
        // TODO: Descomente o trecho abaixo para persisitir em baco de dados e consulte o banco de dados
        service.salvar(c1);

        //TODO: Criar mais 2 contatos.
        ContatoVO c2 = new ContatoVO(
                null,
                "Pablo Rodrigues Goes",
                "pablo.goes@gmail.com",
                "19987659321",
                "goes_pablo");

        ContatoVO c3 = new ContatoVO(
                null,
                "Renato Junior",
                "juniorrenato@gmail.com",
                "19974435658",
                "juniorRe");

        service.salvar(c2);
        service.salvar(c3);

        //TODO: Exibir os contatos cadastrados
       List<ContatoVO> contatosCadastrados = service.buscarTodos();
        for (ContatoVO contato : contatosCadastrados) {
            System.out.println(contato);
        }

        // TODO: Remover o primeiro contatto criado.
        service.excluir(1);

        // TODO: Buscar e exibir o segundo contato criado com base no e-mail
        ContatoVO contatoEncontrado = service.buscarPorEmail("pablo.goes@gmail.com");
        if (contatoEncontrado != null) {
            System.out.println("Contato encontrado: " + contatoEncontrado);
        } else {
            System.out.println("Contato não encontrado.");
        }

        // TODO: Exibir os contatos cadastrados
        for(ContatoVO contato : contatosCadastados){
            System.out.println(contato);
        }

        // TODO: Altere o repositório MySQL pelo repositório em memória
    }
}
