#language:pt
Funcionalidade: Acessar vários componentes html

  Contexto:
    Dado que o usuário acessou o arquivo Campo de treinamento

  @Validar_campos_Nome_Sobrenome_e_Sexo_sao_obrigatorios_para_o_cadastro
  Esquema do Cenário: Validar campos Nome, Sobrenome e Sexo são obrigatórios para o cadastro
    Dado que o usuário não <campo>
    E preencheu os campos <preencher1> e <preencher2>
    Quando o usuário clicar no botão Cadastrar
    Então deve aparecer a mensagem de feedback <mensagem>
    Exemplos:
      | campo                       | mensagem                 | preencher1 | preencher2 |
      | preencheu o campo Nome      | Nome eh obrigatorio      | Sobrenome  | Sexo       |
      | preencheu o campo Sobrenome | Sobrenome eh obrigatorio | Nome       | Sexo       |
      | selecionou o campo Sexo     | Sexo eh obrigatorio      | Nome       | Sobrenome  |

  @Validar_o_cadastro_com_os_campos_obrigatorios_Nome_Sobrenome_Sexo
  Cenário: Validar o cadastro com os campos obrigatórios Nome, Sobrenome e Sexo
    Dado que o usuário preencheu os dados nos campos Nome, Sobrenome e selecionou o Sexo
    Quando o usuário clicar no botão Cadastrar
    Então deve mudar o Status para Cadastrado!

  @Realizar_cadastro_completo
  Cenário: Realizar cadastro completo - Considera-se o cadastro completo ao preencher os campos:
  Nome, Sexo, Comida favorita, Escolaridade, Prática de esportes e sugestões.
    Dado que o usuário preencheu todos os campos
    Quando o usuário clicar no botão Cadastrar
    Então o status deve apresentar todas as informações cadastradas