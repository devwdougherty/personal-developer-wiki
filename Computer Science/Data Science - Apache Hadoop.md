Para contribuir faça um Fork e submeta para Pull Request!

# Arquitetura Hadoop

*Imagens tiradas dos cursos gratuitos de Big Data Fundamentals e Data Science Fundamentals da Data Science Academy*
*https://www.datascienceacademy.com.br/*

## Cluster

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-01.png)

## Arquitetura Node/Slave

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-02.png)

# Serviços

## Serviços Base do Hadoop

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-03.png)

### Objetivo dos serviços

- **NameNode:** Serviço principal. Irá gerenciar o armazenamento distribuído. 
- **Secondary NameNode:** Trabalha em paralelo com o NameNode. 
- **DataNode:** Serviço que armazena os dados. Bloco de dados. 
- **JobTracker:** Responsável por disparar o job de processamento MapReduce. Irá ser executado sobre os dados armazenados no HDFS. 
- **TaskTracker:** Nó escravo (Node), irá executar os jobs.

## Serviços no Cluster

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-04.png)

Flow

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-05.png)

**Passo 2 - Desenvolver o modelo de mapeamento e redução e disparar o job.**

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-06.png)

## Arquitetura da Configuração Hadoop

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-07.png)

## Arquitetura HDFS

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-08.png)

- Os serviços **NameNode** e **Secondary NameNode**, constituem os serviços **Master**. Os serviços **DataNode** são os slaves (nós escravos). 

- O serviço **Master** é responsável por aceitar os Jobs das aplicações clientes e garantir que os dados requeridos para a operação sejam carregados e segregados em pedaços de blocos de dados. 

- O HDFS permite que os dados sejam armazenados em arquivos. Um arquivo é dividido em um ou mais blocos que são armazenados e replicados pelos **DataNodes**. Os blocos de dados são então distribuídos para o sistema de **DataNodes** dentro do cluster. Isso garante que as réplicas de dados sejam mantidas. 

- As réplicas de cada bloco de dados são distribuídas em computadores em todo o cluster para permitir o acesso de dados confiável e de forma rápida.

## Arquitetura MapReduce

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-09.png)
**Processo:** MapReduce -> Listas Ordenadas -> Listas Ordenadas ainda menores

### Operaçoes do MapReduce

#### 2 Operaçoes Principais:

**Operação 1:** Mapeamento (map). Os dados são separados em pares (key-value pairs), transformados e filtrados. Após isso, são distribuiídos para os nodes e processados.
**Operação 2:** Redução (reduce). Os dados são agregados em datasets menores.  Os dados resultantes do processo de redução são transformados no formato padrão chave-valor (key-value), onde a chave (key) funciona como o identificador do registro e o valor (value) é o dado (conteúdo) que é identificado pela chave. 

![alt text](https://github.com/devwdougherty/personal-developer-wiki/blob/master/Computer%20Science/arquiteturaHadoop-10.png)

### Processo do MapReduce

**Início do processo:** Requisição feita pelo cliente e o job é submetido -> Job Tracker se encarrega de coordenar a distribuição do job -> **Mapeamento dos dados** -> Os dados de entrada são primeiramente distribuídos em pares key-values (programa desenvolvido pelo cientista de dados) -> divididos em fragmentos -> atribuídos a tarefas de mapeamento -> essas tarefas irão rodar no TaskTracker.
