# Tutorial App MyPay: V0

O objetivo desse tutorial é se familiarizar com alguns componentes básicos de navegação e exibição de lista de intens.

**OBSERVAÇÃO:** Ao invés de copiar com "Ctrl+C", leia na origem e digite no destino

1. [x] Altere os textos visíveis no app para a aplicação da sua equipe
   - [x] Navegue pelas Activities e procure pelos textos a alterar
   - [x] Alguns estarão em `strings.xml`
   - [x] Outros estarão diretamente no layout
   - [x] Outros no código `.kt`
   - [x] Idealmente, todos os textos devem estar em `strings.xml`
2. [x] Abra o arquivo `Servico.kt` e modifique o nome das classes e hierarquia para a solução da sua equipe
3. [x] Na classe `TabelaPrecosAdapter`, altere o string-array, altere os tipos gerais de serviço para a sua equipe
4. [x] Na activity `AlterarPrecosActivity`
   - [x] Altere os servicos de exemplo para alguns da sua equipe
   - [x] Em `setSpinner`, altere a filtragem de serviço geral para específico
5. [x] Crie uma nova Activity `Novo Pedido` para visualização dos serviços a serem prestados, que abrirá ao clicar em "RECEBER", na tela principal
6. [x] Implemente a ListView para exibir os itens de forma semelhante à listagem de preços, porém:
   - [x] O botão "EDITAR" deve ser trocado por "INCLUIR"
   - [x] Acrescente alguns `TextView` para incluir informações específicas em cada item do tipo de serviço da sua equipe
7. [x] Acrescente uma lista de `Servico` na classe `Pedido`, arquivo `models/Pedido.kt`
8. [x] Crie uma `data class` `ItemPedido` no mesmo arquivo `models/Pedido.kt` com "nome", "observacao" e "preco"
9. [x] Mantenha um objeto `Pedido` na Activity `Novo Pedido`
10. [x] Faça com que o "INCLUIR" abra um `Dialog`  pedindo a quantidade
    - [x] Inclua um novo `ItemPedido` preenchendo os campos com os valores do servico selecionado
11. [x] O botão "SALVAR" deve ser trocado por "FINALIZAR PEDIDO"
    - [x] Crie a Activity `ResumoPedido` exibindo a lista de itens com o botão "PAGAR" que **não fará nada**
    - [x] Crie uma nova ~~ListView~~ RecyclerView, juntamente com um `PedidoAdapter` e implemente o que for necessário

