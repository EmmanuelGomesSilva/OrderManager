# OrderManager

OrderManager é um sistema pessoal em Java para treinar CRUD e POO, com menus interativos no console. Permite cadastrar, listar, atualizar e remover clientes e pedidos, com validação básica de dados e controle de status.

## Funcionalidades

- Cadastrar, listar, atualizar e remover clientes
- Cadastrar, listar, atualizar e remover pedidos
- Validação básica de dados digitados pelo usuário
- Controle de status: Ativo/Inativo para clientes; Pendente/Pago/Cancelado para pedidos
- Menu interativo no console

## Estrutura do Projeto

- **model/**: Contém as classes `Cliente`, `Pedido` e os enums `StatusCliente` e `StatusPedido`
- **repository/**: `ClienteRepository` e `PedidoRepository` guardam os dados em memória
- **service/**: `ClienteService` e `PedidoService` com as regras de negócio
- **util/**: `InputHelper` para ler dados do usuário de forma mais fácil
- **App.java**: Classe principal que roda o programa

## Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/EmmanuelGomesSilva/OrderManager.git
```
2. Entre na pasta do projeto:
```bash
cd OrderManager
```
3. Compile todos os arquivos `.java`
```bash
javac src/com/ordermanager/*.java
```
4. Execute a aplicação:
```bash
java -cp src com.ordermanager.App
```


## Tecnologias Utilizadas

- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="25"/> Java 11
- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="25"/> IntelliJ IDEA


  
## Próximos Passos

- Substituir listas por banco de dados (JDBC ou JPA)
- Criar API REST para integração externa
- Implementar interface gráfica ou web
- Adicionar testes unitários

## Exemplo de Uso

Menu principal:
```
=== MENU PRINCIPAL ===
1 - Clientes
2 - Pedidos 
0 - Sair
Escolha uma opção: 1
```

Menu de clientes:
```
=== MENU CLIENTES ===
1 - Cadastrar cliente
2 - Listar clientes
3 - Atualizar cliente
4 - Remover cliente
0 - Voltar
Escolha uma opção: 1

Nome: João da Silva
Email: joao@email.com
Telefone: 99999-9999
Status do cliente: (1 - ATIVO / 2 - INATIVO) 1
Cliente cadastrado!
```

Listagem de clientes:
```
=== MENU CLIENTES ===
Escolha uma opção: 2
ID: 0 | Nome: João da Silva | Email: joao@email.com | Telefone: 99999-9999 | Status: ATIVO
```

Menu de Pedidos
```
=== MENU PEDIDOS ===
1 - Registrar pedido
2 - Listar pedidos
3 - Atualizar pedido
4 - Remover pedido
0 - Voltar
Escolha uma opção: 1

ID do pedido: 1122
ID do cliente: 0
Valor do pedido: 3500
Status do pedido: (1 - PENDENTE / 2 - PAGO / 3 - CANCELADO) 2
Pedido registrado!
```


    


