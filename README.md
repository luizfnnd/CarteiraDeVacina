# Carteira de Vacinação - Objetivo, Aprendizado e Execução

## Objetivo
Criar um algoritmo capaz de gerar uma carteira de vacinação com base nos dados fornecidos pelo usuário.

## Aprendizado
- **Class Scanner**: Responsável pela entrada de dados fornecidos pelo usuário.
- **Class ArrayList/List, HashMap/Map**: Usados para armazenar e manipular dados de forma eficiente.
- **Getter e Setter**: Métodos de acesso que garantem a segurança dos atributos e facilitam a manutenção do código.

## Execução
O algoritmo segue três fluxos principais de processo: **Cadastro de Ficha**, **Visualizar Ficha** e **Finalização do Programa**.

### Cadastro de Ficha:
1. Inserir dados pessoais (nome completo, data de nascimento, CPF).
2. Inserir dados sobre a vacina (nome da vacina, data de aplicação e número de doses).
3. Os dados fornecidos são armazenados no `HashMap` **fichas** e um ID é atribuído ao paciente.

### Visualizar Ficha:
1. O usuário informa o ID do paciente.
2. Se o ID informado estiver presente no `HashMap` **fichas**, a carteira de vacinação é retornada, contendo os dados pessoais e as informações das vacinas aplicadas.

### Finalização do Programa:
1. Um menu será exibido, e o programa será finalizado caso o usuário pressione **0**.

## Correção/Melhorias no código
### V1.1 – CORREÇÃO – 22/11/2024
Corrigido o conflito na entrada de dados do usuário. O erro ocorreu devido a criação de múltiplos objetos Scanner dentro de cada método. A correção foi eliminar os objetos Scanner dentro dos métodos e instanciar apenas um, fora do bloco main.

