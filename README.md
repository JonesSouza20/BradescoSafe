# 🏦 A3Bradesco — Sistema Bancário Didático para Mitigação de Golpes

## 📖 Descrição do Projeto

O **A3Bradesco** é um projeto acadêmico e didático, desenvolvido em **Java (Swing)**, que simula operações bancárias em uma aplicação desktop. O objetivo principal é **demonstrar práticas de segurança, gestão de contas bancárias e mecanismos de prevenção a fraudes**, permitindo a criação de contas, autenticação de usuários e operações simuladas de movimentação financeira.

Este projeto também é utilizado como ferramenta para **analisar e ilustrar situações comuns de engenharia social e golpes financeiros**, reforçando a importância da validação de dados e proteção contra acessos não autorizados.

---

# 🎯 Finalidade e Objetivos

- 🛡️ **Simular um ambiente bancário controlado para testes de segurança.**
- 🔍 **Demonstrar técnicas de prevenção contra golpes e fraudes digitais.**
- 📚 **Servir como estudo de caso para validação de dados sensíveis, boas práticas de autenticação e uso seguro de bancos de dados.**
- 💳 **Proporcionar uma interface de fácil uso para ilustrar riscos comuns e como mitigá-los.**

---

# 📚 Funcionalidades

✔️ Cadastro de usuários com validação de CPF, RG e e-mail  
✔️ Geração automática de número de conta bancária e conta corrente associada  
✔️ Autenticação via login e senha  
✔️ Simulação de operações bancárias como:
- Transferência entre contas
- Solicitação de empréstimos
- Confirmação via token de segurança

✔️ Validação de dados em tempo real  
✔️ Simulação de tentativa de golpe e estratégias de mitigação  
✔️ Registro e armazenamento seguro (didático) dos dados no banco de dados PostgreSQL

---

# 🗂️ Estrutura do Projeto

A3Bradesco/

├── src/
│ └── br/
│ └── com.a3bradesco/
│ ├── controller/
│ ├── model/
│ ├── view/
│ └── util/
├── resources/
└── README.md

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Swing (Java GUI)**
- **PostgreSQL**
- **JDBC**
- **Maven** (opcional)
- **NetBeans e IntelliJ IDEA**

---

# 🔒 Segurança e Mitigação de Golpes

O projeto enfatiza:

- Validação rigorosa de dados sensíveis no cadastro
- Bloqueio de CPFs já cadastrados
- Verificação de formato e preenchimento de campos obrigatórios
- Uso de tokens de segurança em operações críticas
- Simulação de golpes via interface e estratégias de mitigação
- Armazenamento de senhas com futura implementação de hash seguro (melhoria planejada)

---

# ▶️ Como Executar

1. Clone o projeto:
   ```bash
   git clone https://github.com/anamancilha/A3Bradesco

Configure o banco de dados PostgreSQL utilizando o script disponível em: resources/database.sql

Atualize a string de conexão no arquivo:

src/br/com/a3bradesco/util/ConexaoDataBase.java


Compile e execute o projeto via sua IDE de preferência (NetBeans ou IntelliJ IDEA).

# 📌 Observação

Este projeto é didático e acadêmico, não sendo destinado para uso em produção real de sistemas bancários. Seu foco está na demonstração de práticas seguras e conscientização sobre fraudes digitais.

# 👨‍💻 Autores

    Ana Mancilha
    https://github.com/anamancilha

    Pedro Rafael
    https://github.com/Pedrocom

    Jones Souza
    https://github.com/JonesSouza20