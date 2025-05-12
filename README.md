## Biblioteca
projeto biblioteca com conexão ao banco de dados, contendo 4 classes, e um sistema de filtro, cadastro, ediçao e atualização

Objetivo do projeto:
Biblioteca: Com armazenamento em um banco de dados implementar o gerenciamento de

livros e revistas, onde: os livros possuem título, gênero literário, um ou mais autores, editora

e data de publicação; A revista possui editora, número da edição, data de publicação e

artigos, que por sua vez, possuem título, o texto da publicação e autores. Os autores devem

ter nome, sobrenome, data de nascimento e nacionalidade.

4.1. Criação de um novo livro, alteração das informações do livro, exclusão e a listagem

dos livros com os filtros de título, gênero literário e sobrenome do autor ;

4.2. Criação de uma nova revista, alteração das informações da revista, exclusão e a

listagem com os filtros de título, gênero literário e sobrenome do autor ;

## Como rodar o projeto:
1 - Pode ser usado qualquer IDE que rode java, eu recomendo o eclipse, que foi o que utilizei nesse projeto.

1.1 - como baiaxr: https://www.youtube.com/watch?v=KWGIaWh71q4 <- esse video mostra como baixar a IDE, o link para o download está na bio do video.

2 - Utilizei do banco PostGreSQL, mas você pode usar o que preferir, mas caso queira usar o postGreSQL abaixo vai as informações para baixar.

2.2 - Link para baixar o PostGreSQL: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

2.3 - tutorial de como baixar PostGreSQL: https://www.youtube.com/watch?v=UbX-2Xud1JA

2.4 - Quando for criar o banco de dados, coloque o nome do database de: "BibliotecaProjeto" <- sem as aspas

2.5 - Em application.properties você vai precisar alterar o login e senha de acordo com o que você configurou no seu banco, exemplo abaixo:

spring.datasource.username=postgres

spring.datasource.password=1234

2.6 - Feito isso é só dar play no projeto, que as tabelas vão ser criadas automaticamente e o banco vai ser populado por alguns informações.

2.7 - Dentro da pasta SRC/MAIN/JAVA, vai ter um .TXT com o seguinte nome "informacoes do banco de dados", nele vai ter as informações que 
foram para o banco de dados no momento em que voce deu play, vão ser uteis caso você queira fazer testes de listam, exclusão e edição sem precisar cadastrar, 
mas caso queira cadastrar manualmente, vai ter o MenuCadastro que vai te guiar no cadastro.
