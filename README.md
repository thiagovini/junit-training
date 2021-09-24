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

Algumas informações sobre a implementação acima:

 - @EnableSwagger2 é a anotação que vai ativar o swagger no seu projeto Spring Boot

 - Dentro do @Bean estamos definindo um Docket,e é ele quem vai permitir configurarmos aspectos dos nossos endpoints apresentados ao swagger.

 - Por ultimo, os métodos chamado no docket, é necessário passar os parâmetros .any, isso fará com que qualquer api esteja disponível. Com isso, através das 		reflections (reflection é um pacote JAVA que nos possibilita chamar métodos e conhecer estrutura em tempo de execução sem que precisar conhecer as 		classes envolvidas quando estamos escrevento nosso código) a biblioteca ja consegue reconhecer os endpoints definidos na aplicação.

<h3 align="center">
    <a>Como utilizar</a>
</h3>

Após feita as configurações, de acordo com os meus métodos declarados no meu controller, essa é a interface do swagger:

![interface-swagger](https://user-images.githubusercontent.com/69025247/134717888-d27e4f3f-3b69-434a-aef7-a0d42049becb.jpeg)

Vou pegar como exemplo o método de registro de pessoas. Ao selecionar, perceba que o swagger ja irá lhe mostrar quais são os parametros esperados para que seja cadastrada uma pessoa corretamente

![cadastrar-pessoas](https://user-images.githubusercontent.com/69025247/134718288-5fb60e28-dbfa-481b-8743-fcab8f458c1d.jpeg)

Agora, iremos preencher as informações de cadastro de pessoas e executar o comando.

Clique no botão "Try it out", preencha as informações e depois clique no botão "Execute" e o swagger retornará o codigo de acordo com a sua api (200 success, 
500  Internal Server Error, etc...)

![messagens-retorno](https://user-images.githubusercontent.com/69025247/134719101-c1c542e9-618d-4e22-bd17-9c5049d06bce.jpeg)

