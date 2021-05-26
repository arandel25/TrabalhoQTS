package stepdefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import util.Componentes;

public class ComponentesStep {

    Componentes componentes = new Componentes();

    @Dado("que o usuário acessou o arquivo Campo de treinamento")
    public void que_o_usuário_acessou_o_arquivo_Campo_de_treinamento() {
        componentes.inicializa();
    }

    @Dado("que o usuário não preencheu o campo Nome")
    public void que_o_usuário_não_preencheu_o_campo_Nome() {
        componentes.validaTextFieldVazio("nome");
    }

    @Dado("preencheu os campos Sobrenome e Sexo")
    public void preencheu_os_campos_Sobrenome_e_Sexo() {
        componentes.testeTextField("sobrenome");
        componentes.validaTextField("sobrenome");
        componentes.testeRadioButton();
        componentes.validaRadioButton();
    }

    @Quando("o usuário clicar no botão Cadastrar")
    public void o_usuário_clicar_no_botão_Cadastrar() {
        componentes.clicarBotaoCadastrar();
    }

    @Então("deve aparecer a mensagem de feedback Nome eh obrigatorio")
    public void deve_aparecer_a_mensagem_de_feedback_Nome_eh_obrigatorio() {
        componentes.validarBotaoCadastrar("Nome eh obrigatorio");
        componentes.fechaNavegador();
    }

    @Dado("que o usuário não preencheu o campo Sobrenome")
    public void que_o_usuário_não_preencheu_o_campo_Sobrenome() {
        componentes.validaTextFieldVazio("sobrenome");
    }

    @Dado("preencheu os campos Nome e Sexo")
    public void preencheu_os_campos_Nome_e_Sexo() {
        componentes.testeTextField("nome");
        componentes.validaTextField("nome");
        componentes.testeRadioButton();
        componentes.validaRadioButton();
    }

    @Então("deve aparecer a mensagem de feedback Sobrenome eh obrigatorio")
    public void deve_aparecer_a_mensagem_de_feedback_Sobrenome_eh_obrigatorio() {
        componentes.validarBotaoCadastrar("Sobrenome eh obrigatorio");
        componentes.fechaNavegador();
    }

    @Dado("que o usuário não selecionou o campo Sexo")
    public void que_o_usuário_não_selecionou_o_campo_Sexo() {
        componentes.validaRadioButtonNaoSelecionado();
    }

    @Dado("preencheu os campos Nome e Sobrenome")
    public void preencheu_os_campos_Nome_e_Sobrenome() {
        componentes.testeTextField("nome");
        componentes.validaTextField("nome");
        componentes.testeTextField("sobrenome");
        componentes.validaTextField("sobrenome");
    }

    @Então("deve aparecer a mensagem de feedback Sexo eh obrigatorio")
    public void deve_aparecer_a_mensagem_de_feedback_Sexo_eh_obrigatorio() {
        componentes.validarBotaoCadastrar("Sexo eh obrigatorio");
        componentes.fechaNavegador();
    }

    @Dado("que o usuário preencheu os dados nos campos Nome, Sobrenome e selecionou o Sexo")
    public void que_o_usuário_preencheu_os_dados_nos_campos_Nome_Sobrenome_e_selecionou_o_Sexo() {
        componentes.testeTextField("nome");
        componentes.validaTextField("nome");
        componentes.testeTextField("sobrenome");
        componentes.validaTextField("sobrenome");
        componentes.testeRadioButton();
        componentes.validaRadioButton();
    }

    @Então("deve mudar o Status para Cadastrado!")
    public void deve_mudar_o_Status_para_Cadastrado() {
        componentes.validaStatusCadastrado();
        componentes.fechaNavegador();
    }

    @Dado("que o usuário preencheu todos os campos")
    public void que_o_usuário_preencheu_todos_os_campos() {
        componentes.preencheTodasInformacoes();
    }

    @Então("o status deve apresentar todas as informações cadastradas")
    public void o_status_deve_apresentar_todas_as_informações_cadastradas() {
        componentes.validaTodasInformacoesPreenchidas();
        componentes.validaInformacoesStatus();
        componentes.fechaNavegador();
    }
}