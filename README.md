# 📚 Biblioteca - Projeto Java

Este é um projeto de **Biblioteca** com conexão ao banco de dados, implementando o gerenciamento de **livros**, **revistas** e **artigos**. O sistema permite a criação, alteração, exclusão e listagem desses itens com filtros por **título**, **gênero literário** e **nome completo do autor**.

## 🎯 Objetivo do Projeto

O objetivo deste projeto é implementar o gerenciamento de **livros**, **revistas** e **artigos** com armazenamento em banco de dados. As funcionalidades incluem:

### 📖 Livros:
- Cadastro de livros com título, gênero literário, um ou mais autores, editora e data de publicação.
- Filtros para a listagem dos livros por título, gênero literário e nome completo do autor.
- Edição e exclusão de livros.

### 📘 Revistas:
- Cadastro de revistas com editora, número da edição, data de publicação e artigos.
- Artigos possuem título, texto da publicação e autores.
- Filtros para a listagem das revistas por título, gênero literário e nome completo do autor.
- Edição e exclusão de revistas.

### 📝 Artigos:
- Cadastro de artigos com título, texto da publicação e autores.
- Cada artigo pertence a uma revista.
- Filtros para a listagem de artigos por título e autor.

### 👤 Autores:
- Cadastro de autores com **nome completo**, data de nascimento e nacionalidade.

## ⚙️ Funcionalidades

- **Livros:**
  - Criação de um novo livro.
  - Alteração das informações do livro.
  - Exclusão de livros.
  - Listagem dos livros com filtros por título, gênero literário e nome completo do autor.

- **Revistas:**
  - Criação de uma nova revista.
  - Alteração das informações da revista.
  - Exclusão de revistas.
  - Listagem das revistas com filtros por título, gênero literário e nome completo do autor.

- **Artigos:**
  - Criação de um novo artigo.
  - Alteração das informações do artigo.
  - Exclusão de artigos.
  - Listagem dos artigos com filtros por título e autor.

## 🏗️ Tecnologias Utilizadas

- **Java** ☕
- **Spring Boot** 🚀
- **JPA (Java Persistence API)** 🔗
- **PostgreSQL** 🗄️

# 📥 Como Clonar um Repositório Git

## 🔓 Clonar um Repositório Público

Repositórios públicos estão disponíveis para qualquer pessoa acessar. Para clonar um repositório público, siga os passos:

1. 💾 Tenha o **Git** instalado em sua máquina. [👉 Baixe aqui](https://git-scm.com/downloads)
2. 📋 Copie a **URL do repositório** (exemplo: `https://github.com/usuario/repositorio.git`)
3. 🖥️ Abra o **terminal** (Prompt de Comando, PowerShell ou Terminal no Linux/Mac)
4. 📁 Navegue até a pasta onde deseja salvar o projeto:  
   ```bash
   cd caminho/para/pasta
   ```
   🧩 Rode o comando para clonar: git clone https://github.com/BrunoBeneduzi/BibliotecaProjeto.git

## 🔧 Como Rodar o Projeto

1. 💻 **IDE recomendada**: Qualquer IDE que suporte Java. Eu recomendo o **Eclipse** para facilitar o processo, pois foi utilizado neste projeto.

   1.1. [Como baixar o Eclipse?](https://www.youtube.com/watch?v=KWGIaWh71q4)

2. 🗄️ Este projeto utiliza o banco de dados **PostgreSQL**, mas você pode usar outro banco de sua preferência. Caso queira usar o **PostgreSQL**, siga as instruções abaixo:

   2.1. [Link para baixar o PostgreSQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)

   2.2. [Tutorial de como baixar o PostgreSQL](https://www.youtube.com/watch?v=UbX-2Xud1JA)

   2.3. Ao criar o banco de dados, defina o nome do database como **"BibliotecaProjeto"** (sem aspas).

3. 📝 No arquivo `application.properties`, altere o login e a senha de acordo com as configurações do seu banco. Exemplo:

   ```properties
   spring.datasource.username=postgres
   spring.datasource.password=1234
