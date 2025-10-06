# Sistema de Gerenciamento de Academia

Este projeto é uma **API RESTful** desenvolvida em **Java 21** com **Spring Boot 3.5.6** e banco de dados **H2**, criada para gerenciar **alunos, planos, treinos e pagamentos** de uma academia.  
O sistema permite o **cadastro, consulta, atualização e exclusão** dessas entidades, seguindo regras de negócio específicas para manter a integridade dos dados.

---

## Funcionalidades Principais

- **Gerenciamento de alunos:** cadastro, listagem, atualização e inativação.  
- **Gerenciamento de pagamentos:** registro de pagamentos com data e status automático.  
- **Gerenciamento de planos:** criação, consulta, atualização e exclusão de planos.  
- **Gerenciamento de treinos:** vinculação de treinos a alunos e controle de exclusão.  

---

## Estrutura de Pacotes

```plaintext
src/
 ├── controller/
 │   ├── AlunoController.java
 │   ├── PagamentoController.java
 │   ├── PlanoController.java
 │   └── TreinoController.java
 │
 ├── dto/
 │   ├── AlunoRequestAlterarDTO.java
 │   ├── AlunoRequestRegistroDTO.java
 │   ├── AlunoResponseDTO.java
 │   ├── AlunoResponseListDTO.java
 │   ├── PagamentoRequest.java
 │   ├── PagamentoResponse.java
 │   ├── PlanoRequest.java
 │   ├── PlanoResponse.java
 │   ├── TreinoRequest.java
 │   └── TreinoResponse.java
 │
 ├── mapper/
 │   ├── AlunoMapper.java
 │   ├── PagamentoMapper.java
 │   ├── PlanoMapper.java
 │   └── TreinoMapper.java
 │
 ├── model/
 │   ├── enums/
 │   │   ├── FormaPagamento.java
 │   │   ├── NivelTreino.java
 │   │   ├── StatusAluno.java
 │   │   └── StatusPagamento.java
 │   ├── Aluno.java
 │   ├── AlunoTreinoVinculo.java
 │   ├── Pagamento.java
 │   ├── Plano.java
 │   └── Treino.java
 │
 ├── repository/
 │   ├── AlunoRepository.java
 │   ├── PagamentoRepository.java
 │   ├── PlanoRepository.java
 │   └── TreinoRepository.java
 │
 └── service/
     ├── AlunoService.java
     ├── PagamentoService.java
     ├── PlanoService.java
     └── TreinoService.java
```

---

## Passos para Rodar Localmente

### Pré-requisitos

Antes de começar, certifique-se de ter instalado:

* Java 21+
* Maven 3.9+
* Spring Boot 3.5.6
* Banco de Dados H2
* Spring Data JPA

---

## **Endpoints Disponíveis**

### **Aluno (`/api/v2/aluno`)**

* `GET /api/v2/aluno/{id}` — Buscar um aluno pelo ID
* `GET /api/v2/aluno` — Listar todos os alunos
* `POST /api/v2/aluno` — Registrar um novo aluno
* `PUT /api/v2/aluno` — Atualizar os dados de um aluno

### **Pagamento (`/api/v2/pagamento`)**

* `GET /api/v2/pagamento/{id}` — Listar todos os pagamentos de um aluno pelo ID
* `POST /api/v2/pagamento` — Registrar um novo pagamento para um aluno

### **Plano (`/api/v2/plano`)**

* `GET /api/v2/plano/{id}` — Buscar um plano pelo ID
* `GET /api/v2/plano` — Listar todos os planos
* `POST /api/v2/plano` — Registrar um novo plano
* `PUT /api/v2/plano` — Atualizar os dados de um plano
* `DELETE /api/v2/plano/deletar/{id}` — Deletar um plano pelo ID

### **Treino (`/api/v2/treino`)**

* `GET /api/v2/treino/{id}` — Buscar um treino pelo ID
* `GET /api/v2/treino` — Listar todos os treinos
* `POST /api/v2/treino` — Registrar um novo treino
* `PUT /api/v2/treino` — Atualizar os dados de um treino
* `DELETE /api/v2/treino/deletar/{id}` — Deletar um treino pelo ID


---

## 👨‍💻 Autor

**Pedro Spíndola**
🔗 [LinkedIn](https://www.linkedin.com/in/pedro-henrique-spindola?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app)

---

## 📜 Licença

Este projeto é de uso livre para fins educacionais.
