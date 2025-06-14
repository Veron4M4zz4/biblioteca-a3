# 📚 Libratech

**Libratech** é um sistema de gerenciamento de biblioteca acadêmica desenvolvido em Java, com persistência de dados em SQLite. O projeto tem como objetivo gerenciar o cadastro de usuários (alunos e professores), controle de livros e registros de empréstimos e devoluções, promovendo organização e praticidade em ambientes educacionais.

---

## ⚙️ Tecnologias Utilizadas

- 💻 Java 17+
- 🗃️ SQLite (via JDBC)
- 📦 DB Browser for SQLite (visualização do banco)
- 🔧 VS Code
- 🌐 Git + GitHub

---

## 📁 Estrutura do Projeto

biblioteca-a3/
├── bin/ # Arquivos compilados (.class)
├── dao/ # Classes de acesso ao banco de dados (DAO)
├── emprestimos/ # Classe que representa o empréstimo
├── lib/ # Bibliotecas externas (JARs)
├── models/ # Classes do domínio (Usuario, Aluno, Professor, Livro, etc.)
├── services/ # Classes que gerenciam a lógica de negócio
├── ITAU.db # Arquivo de banco de dados SQLite
├── Main.java # Ponto de entrada do sistema
└── README.md # Documentação do projeto


---

## 🧠 Funcionalidades

- Cadastro e listagem de usuários (alunos e professores)
- Cadastro e gerenciamento de livros
- Empréstimos e devoluções com regras específicas
  - Professores são isentos de multa
  - Alunos têm multa de 0,5 por dia de atraso
- Validações robustas de entrada de dados
- Persistência dos dados no banco `ITAU.db`

---

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/libratech.git
   cd libratech
   
javac -cp ".;lib/*" Main.java
java -cp ".;lib/*" Main
