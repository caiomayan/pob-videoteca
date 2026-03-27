package appconsole;

// Import do manager do db4o

import com.db4o.ObjectContainer;

// Import das classes de negócio

import modelo.Genero;
import modelo.Video;
import util.Util;

public class Cadastrar {
    // Declaração da variável do manager do db4o para persistir os objetos
    private ObjectContainer manager;

    public Cadastrar() {
        // Conectar ao db4o
        Util.conectar();

        // Variável de manipulação dos objetos no banco
        manager = Util.getManager();

        System.out.println("Cadastrando");

        // Declaração dos gêneros e vídeos a serem cadastrados
        Genero documentario, acao, games, publicidade, comedia, futebol, jornalismo;
        Video ad_cocacola, como_jogar_cs, invasao_ucrania, standup, geopolitica_eua_x_ira, irl_motovlog, brasil_x_franca, governador_rj_renuncia_cargo;

        // Instanciando gêneros e vídeos
        documentario = new Genero("Documentário");
        acao = new Genero("Ação");
        games = new Genero("Games");
        publicidade = new Genero("Publicidade");
        comedia = new Genero("Comédia");
        futebol = new Genero("Futebol");
        jornalismo = new Genero("Jornalismo");

        ad_cocacola = new Video("Coca-Cola | Holidays Are Coming", "2025-11-03", "https://www.youtube.com/watch?v=Yy6fByUmPuE", "Livre");
        como_jogar_cs = new Video("Dicas de como iniciar e aprender a jogar o CS2 (Counter Strike 2)", "2023-09-28", "https://www.youtube.com/watch?v=INAt-aIZ28M", "14");
        invasao_ucrania = new Video("Especial: Ucrania - Arquivos de Guerra", "2023-02-24", "https://www.youtube.com/watch?v=SS6hLG4smf0", "14");
        standup = new Video("ALMA DE BRASILEIRO - Paul Cabannes (stand up - show completo)", "2026-03-26", "https://www.youtube.com/watch?v=BdTVDYUrCNM", "12");
        geopolitica_eua_x_ira = new Video("Entenda o conflito entre IRÃ e ESTADOS UNIDOS de uma FORMA SIMPLES", "2025-10-08", "https://www.youtube.com/watch?v=3D_vS0XlC1w", "12");
        irl_motovlog = new Video("SUSTOS DE MOTO (EP. 249)", "2026-03-23", "https://www.youtube.com/watch?v=m5iNeGIkTKo", "14");
        brasil_x_franca = new Video("BRASIL 1 X 2 FRANÇA | MELHORES MOMENTOS | AMISTOSO INTERNACIONAL | ge tv", "2026-03-26", "https://www.youtube.com/watch?v=MXFDz0uOSxM", "Livre");
        governador_rj_renuncia_cargo = new Video("JN: Governador do Rio de Janeiro, Cláudio Castro, do PL, renuncia ao cargo", "2026-03-23", "https://www.youtube.com/watch?v=W5iRrg8NpEg", "Livre");

        // Relacionamentos e persistência: adicionando gêneros aos vídeos, guardando no manager (store) e enviando para o banco o que foi guardado no manager (commit).

        governador_rj_renuncia_cargo.addGenero(jornalismo);
        manager.store(governador_rj_renuncia_cargo);
        manager.commit();

        brasil_x_franca.addGenero(futebol);
        manager.store(brasil_x_franca);
        manager.commit();

        ad_cocacola.addGenero(publicidade);
        manager.store(ad_cocacola);
        manager.commit();

        como_jogar_cs.addGenero(games);
        como_jogar_cs.addGenero(acao);
        manager.store(como_jogar_cs);
        manager.commit();

        invasao_ucrania.addGenero(documentario);
        invasao_ucrania.addGenero(acao);
        manager.store(invasao_ucrania);
        manager.commit();

        standup.addGenero(comedia);
        manager.store(standup);
        manager.commit();


        geopolitica_eua_x_ira.addGenero(documentario);
        manager.store(geopolitica_eua_x_ira);
        manager.commit();


        irl_motovlog.addGenero(acao);
        manager.store(irl_motovlog);
        manager.commit();

        // Desconectando do banco
        Util.desconectar();
        System.out.println("Término do cadastro");
    }

    public static void main(String[] args) {
        // Execução da aplicação
        new Cadastrar();
    }
}
