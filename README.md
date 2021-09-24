# JUnite Training
this project is dedicated to the study of unit tests

<h4 align="center"> 
	🚧   Status Project 🚀 Building...  🚧
</h4>

🇧🇷

<p align="center">Para o desenvolvimento dessa api dedicada à implementação de testes unitários, aproveitei para utilizar ferramentas para o versionamento do 
banco de dados e para o consumo e documentação da api, que são: FlyWay e Swagger rescptivamente.</p>

<p align="center">Antes de mostrar como fazer a configuração de ambos, irei trazer algumas informações sobre as mesmas.</p>

<h1 align="center">
    <a>FlyWay</a>
</h1>

Flyway é um framework que permite o controle e gerenciamento da versão do banco de dados, com ele podemos controlar
os elementos que compõem uma determinado base, incluindo tabelas, sequências, views, etc.

Uma das principais vantagens de utilizar o flyway para o gerenciamento do banco de dados, é a organização e controle que ele trás para um ambiente de desenvolvimento, além de ser muito fácil de configurar e utilizar. 

<h3 align="center">
    <a>Implementação</a>
</h3>

Para implementar o flyway no seu projeto spring boot é muito simples. Se você esta iniciando um novo projeto, através do https://start.spring.io/ você consegue 
adicionar as dependencias no pom.xml automaticamente clicando em "add dependencies..." e buscar por "Flyway Migration". Caso contrário, você pegar a dependecia através do link https://mvnrepository.com/artifact/org.flywaydb/flyway-core e adicionar manualmente no seu pom.xml

<h3 align="center">
    <a>Como utilizar</a>
</h3>

Depois de ja estar com a dependência do flyway em seu projeto, e as configurações do seu banco de dados devidamente feita, para que o flyway faça as alterações corretamente, é necessário adicionar o arquivo com as alterações no diretório src/main/resources/db/migration do seu projeto. Importante ressaltar, que o nome
do arquivo deve começar com "V1__" (De acordo com sua versão... nesse exmplo como é o primeiro arquivo, logo, V1) e terminar com ".sql".

Exemplo:

	src/main/resources/db/migration/V1__criar_tabela_pessoa.sql
	src/main/resources/db/migration/V2__altera_tipo_campo_nome_tabela_pessoa.sql
	

<h1 align="center">
    <a>Swagger</a>
</h1>

<p>O swagger é uma applicação open source para consumo, descrição e vizualização de API. O ponto mais interessante nela, é que podemos evoluir a documentação e a 
implementação simutâneamente. Além disso, o swagger tem uma plataforma super intuitiva para que qualquer pessoa, mesmo que não teja conhecimento da implementação,
possa estar consumindo essa api, até porque os parâmetros esperados são explícitos na documentação.</p>

<h3 align="center">
    <a>Implementação</a>
</h3>

Diferente do flyway, não conseguimos adicionar as dependencias do swagger através do start.spring.io. Então, manualmente teremos que adicionar duas dependencias do springfox: springfox-swagger2 e springfox-swagger-ui, vocês poderão encontrar em https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 e https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui respectivamente.

Após adicionar as dependencias, é necessário habilitar o swagger na sua aplicação. No meu caso, eu criei um arquivo SwaggerConfig em um novo diretório de configuração no meu projeto src/main/java/br/com/training/junit/config/swagger/ com as informações abaixo:

![config-swagger](https://user-images.githubusercontent.com/69025247/134714163-77c24ca8-5ef0-4d23-bc13-23cdae7d2832.jpeg)

Ao executar a applicação vocês consiguirão abrir o swagger na porta padrão ou na porta configurada para a sua aplicação. No meu caso, vou conseguir acessar na porta 8081 no link http://localhost:8081/swagger-ui.html

<h3 align="center">
    <a>Como utilizar</a>
</h3>


