# Tutorial App MyPay: V0

O objetivo desse tutorial é se familiarizar com alguns componentes básicos de navegação e exibição de lista de intens.

**OBSERVAÇÃO:** Ao invés de copiar com "Ctrl+C", leia na origem e digite no destino

1. Altere os textos visíveis no app para a aplicação da sua equipe
   - Navegue pelas Activities e procure pelos textos a alterar
   - Alguns estarão em `strings.xml`
   - Outros estarão diretamente no layout
   - Outros no código `.kt`
   - Idealmente, todos os textos devem estar em `strings.xml`
2. Abra o arquivo `Servico.kt` e modifique o nome das classes e hierarquia para a solução da sua equipe
3. Na classe `TabelaPrecosAdapter`, altere o string-array, altere os tipos gerais de serviço para a sua equipe
4. Na activity `AlterarPrecosActivity`
   - Altere os servicos de exemplo para alguns da sua equipe
   - Em `setSpinner`, altere a filtragem de serviço geral para específico
5. Crie uma nova Activity `Novo Pedido` para visualização dos serviços a serem prestados, que abrirá ao clicar em "RECEBER", na tela principal
6. Implemente a ListView para exibir os itens de forma semelhante à listagem de preços, porém:
   -  O botão "EDITAR" deve ser trocado por "INCLUIR"
   - Acrescente alguns `TextView` para incluir informações específicas em cada item do tipo de serviço da sua equipe
7. Acrescente uma lista de `Servico` na classe `Pedido`, arquivo `models/Pedido.kt`
8. Crie uma `data class` `ItemPedido` no mesmo arquivo `models/Pedido.kt` com "nome", "observacao" e "preco"
9. Mantenha um objeto `Pedido` na Activity `Novo Pedido`
10. Faça com que o "INCLUIR" abra um `Dialog`  pedindo a quantidade
    - Inclua um novo `ItemPedido` preenchendo os campos com os valores do servico selecionado
11. O botão "SALVAR" deve ser trocado por "FINALIZAR PEDIDO"
    - Crie a Activity `ResumoPedido` exibindo a lista de itens com o botão "PAGAR" que **não fará nada**
    - Crie uma nova `ListView`, juntamente com um `PedidoAdapter` e implemente o que for necessário

