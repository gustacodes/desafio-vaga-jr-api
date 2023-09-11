# Instruções de Uso da API REST (Parte 2)

Instruções de uso da API REST A seguir, você encontrará instruções sobre como usar os endpoints adicionais fornecidos pelo `UserController` para gerenciar colaboradores (usuários).

## Endpoints do UserController

### Registrar um Colaborador

#### Página de Registro

- **Endpoint:** `/colaborador/registrar`
- **Método:** GET
- **Descrição:** Exibe a página de registro de um colaborador.

#### Registrar Colaborador

- **Endpoint:** `/colaborador/registrar`
- **Método:** POST
- **Descrição:** Registra um novo colaborador com os dados fornecidos no corpo da solicitação. Certifica-se de que o colaborador tenha pelo menos 1 e no máximo 3 campos de aprendizado (`learning`) preenchidos.
- **Exemplo de Uso:** `POST http://seuservidor.com/colaborador/registrar`
- **Corpo da Solicitação:** Deve incluir os dados do colaborador no formato JSON.

### Listar Todos os Colaboradores

#### Listar Todos os Colaboradores Registrados

- **Endpoint:** `/registros`
- **Método:** GET
- **Descrição:** Retorna uma lista de todos os colaboradores registrados no sistema.
- **Exemplo de Uso:** `GET http://seuservidor.com/registros`
- **Resposta:** Retorna uma lista de colaboradores em formato JSON.

### Validar Colaborador

#### Página de Validação de Colaborador

- **Endpoint:** `/colaborador/validar/{id}`
- **Método:** GET
- **Descrição:** Exibe a página de validação de um colaborador específico com base no ID fornecido.

#### Validar Colaborador

- **Endpoint:** `/colaborador/validar/{id}`
- **Método:** POST
- **Descrição:** Marca um colaborador como validado com base no ID fornecido.
- **Exemplo de Uso:** `POST http://seuservidor.com/colaborador/validar/{id}`

## Exemplos de Uso

### Página de Registro de Colaborador

```
GET http://seuservidor.com/colaborador/registrar
```

### Registrar um Novo Colaborador

```
POST http://seuservidor.com/colaborador/registrar
Corpo da Solicitação:
{
    "nome": "Nome do Colaborador",
    "email": "email@exemplo.com",
    "learning": ["Java", "Spring Boot", "Hibernate"]
}
```

### Listar Todos os Colaboradores Registrados

```
GET http://seuservidor.com/registros
```

### Página de Validação de Colaborador

```
GET http://seuservidor.com/colaborador/validar/{id}
```

### Validar um Colaborador

```
POST http://seuservidor.com/colaborador/validar/{id}
```

Lembre-se de substituir `http://seuservidor.com` pela URL real do seu servidor onde a API está hospedada.

Estas são as instruções de uso adicionais para o `UserController`. Certifique-se de ajustar os detalhes da implementação e das rotas de acordo com o seu ambiente de desenvolvimento e requisitos específicos do projeto.