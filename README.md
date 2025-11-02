# ms-sinara-mongo

Microserviço responsável pelo gerenciamento de formulários, permissões e notificações do sistema **Sinara**, utilizando **Spring Boot** e **MongoDB**.

---

## Visão Geral

O **ms-sinara-mongo** lida com as collections:

- Formulários Padrão
- Formulários Personalizados
- Respostas de Formulários
- Permissões
- Notificações

Expõe endpoints REST para criação, listagem, atualização, exclusão e consultas específicas relacionadas a cada módulo.

---

## Modelo Conceitual - MongoDB
<img width="1920" height="1080" alt="formulario_personalisado (2)" src="https://github.com/user-attachments/assets/e9fab691-f260-4bed-b1d5-2ac4db25db51" />

---

## Estrutura de Pastas

```
src/
├── auxiliares/
├── config/
├── controller/
├── dto/
│ ├── request/
│ └── response/
├── exception/
├── model/
├── openAPI/
├── repository/
├── service/
└── validation/
```

---

## Endpoints

### 📄 Formulário Padrão (`FormularioPadraoController`)

| Método | Rota |
|:------:|:-----|
| GET    | /formulario-padrao/listar |
| GET    | /formulario-padrao/{id} |
| POST   | /formulario-padrao/inserir |
| DELETE | /formulario-padrao/excluir/{id} |
| GET    | /formulario-padrao/buscar-por-empresa/{idEmpresa} |
| GET    | /formulario-padrao/buscar-por-data/{data} |

### Formulário Personalizado (`FormularioPersonalizadoController`)

| Método | Rota |
|:------:|:-----|
| GET    | /formulario-personalizado/listar |
| GET    | /formulario-personalizado/{id} |
| POST   | /formulario-personalizado/inserir |
| DELETE | /formulario-personalizado/excluir/{id} |
| GET    | /formulario-personalizado/buscar-por-criador/{idEmpresa} |
| GET    | /formulario-personalizado/buscar-por-titulo/{titulo} |
| GET    | /formulario-personalizado/buscar-por-parte-titulo/{parteTitulo} |
| GET    | /formulario-personalizado/contar-por-criador/{idEmpresa} |
| GET    | /formulario-personalizado/buscar-status/{idForms} |
| GET    | /formulario-personalizado/buscar-formularios-pendentes-por-permissao/{idPermissao} |
| GET    | /formulario-personalizado/buscar-formularios-por-permissao/{idPermissao} |
| GET    | /formulario-personalizado/contar-formularios-pendentes/{idPermissao} |

### Notificações (`NotificacaoController`)

| Método | Rota |
|:------:|:-----|
| GET    | /notificacoes/listar |
| GET    | /notificacoes/{id} |
| POST   | /notificacoes/inserir |
| DELETE | /notificacoes/excluir/{id} |
| GET    | /notificacoes/buscar-por-usuario/{idEnvio} |
| GET    | /notificacoes/buscar-por-empresa/{idEmpresa} |

### Permissões (`PermissaoController`)

| Método | Rota |
|:------:|:-----|
| GET    | /permissoes/listar |
| GET    | /permissoes/{id} |
| POST   | /permissoes/inserir |
| PATCH  | /permissoes/atualizar/{id} |
| DELETE | /permissoes/excluir/{id} |
| GET    | /permissoes/buscar-por-empresa/{idEmpresa} |
| GET    | /permissoes/buscar-por-nome/{nome} |
| PATCH  | /permissoes/adicionar-ids-operario/{id} |
| PATCH  | /permissoes/remover-ids-operarios/{id} |

### Respostas de Formulários Personalizados (`RespostaFormularioPersonalizadoController`)

| Método | Rota |
|:------:|:-----|
| GET    | /resposta-formulario-personalizado/listar |
| GET    | /resposta-formulario-personalizado/{id} |
| POST   | /resposta-formulario-personalizado/inserir |
| DELETE | /resposta-formulario-personalizado/excluir/{id} |
| GET    | /resposta-formulario-personalizado/formulario-completo/{idForm} |
| GET    | /resposta-formulario-personalizado/contar-respostas-por-operario/{idOperario} |
| GET    | /resposta-formulario-personalizado/buscar-respondidos-por-permissao/{idPermissao} |
| GET    | /resposta-formulario-personalizado/buscar-ultimo-operario/{idEmpresa} |

---

## Tecnologias Utilizadas

- Java 21  
- Spring Boot 3+  
- MongoDB  
- Spring Data Mongo  
- Jakarta Validation  
- OpenAPI / Swagger 

---

## Documentação Swagger
A documentação interativa está disponível em:  
**[Swagger UI – ms-sinara-mongo](https://ms-sinara-mongo.onrender.com/swagger-ui/index.html)**
