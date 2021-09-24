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
<p>
Flyway é um framework que permite o controle e gerenciamento da versão do banco de dados, com ele podemos controlar
os elementos que compõem uma determinado base, incluindo tabelas, sequências, views, etc.</p>

<p>Uma das principais vantagens de utilizar o flyway é a organização que ele trás para um ambiente de desenvolvimento, além de ser muito fácil de configurar e
o utilizar. Além disso, podemos criar os arquivos nomeando com a sequencia das alteraçãos, uma descritivo e a data, facilitando a identificação das alterações. Inclusive a padronização da nomeação dos aquivos para que o flyway consiga fazer a leitura corretamente, é começar com o versionamento sequencial das alteraçãos, por exemplo: </p>

<p>V1__criar_tabela_pessoa_20_09_2021.sql</p>
<p>V2__alterando_tabela_pessoa_23_09_2021.sql</p>

<h1 align="center">
    <a>Swagger</a>
</h1>

<p>O swagger é uma applicação open source para consumo, descrição e vizualização de API. O ponto mais interessante nele, é que podemos evoluir a documentação e a 
implementação simutâneamente. Além disso, o swagger tem uma plataforma super intuitiva para que qualquer pessoa, mesmo que não teja conhecimento da implementação,
possa estar consumindo essa api, até porque os parâmetros esperados são explícitos na documentação.</p>
