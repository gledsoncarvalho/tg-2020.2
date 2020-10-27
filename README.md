# tg-2020.2

MEMBROS:
- Brenno Santos Oliveira;
- Francisco José dos Santos Santana;
- Gledson de Carvalho Santos.

# Representação do grafo
- Descricao:
 1. Foi escolhido a lista de adjacência como estrutura para armazenar o grafo;

- Utilizando o projeto *Grafo*:
 1. Entrar na classe `Main`;
 2. Insira a lista de adjacência `.txt` no mesmo diretório do projeto;
 3. Altere o conteúdo da variável `"fileName"` com o mesmo nome do `.txt` adicionado no diretorio do projeto;
 4. E dar `Run File` no método `Grafo.print(grafo)`.


# Métodos Básicos
- Descricao:
 1. getAdjacentes: retorna a lista de adjacentes de um vértice passado como parâmetro;
 
 2. ehRegular: verifica se um determinado grafo é regular ou não. Deve retornar True ou False a depender do grafo;
 
 3. ehCompleto: verifica se um determinado grafo é completo ou não. Deve retornar True ou False a depender do grafo;
 
 4. ehConexo: verifica se um determinado grafo é conexo ou não. Deve retornar True ou False a depender do grafo. Deve utilizar busca em largura ou busca em profundidade para     fazer essa verificação.


- Utilizar o projeto *Grafos2*:
 1. Entrar na classe `Metodos`;
 
 2. Trocar o diretório do grafo na Classe `Metodos` da variável `diretorio` para o diretório do grafo;
 
 3. Escolher o método a ser usado, podendo ser o : `getAdjacentes`, `ehRegular`,`ehCompleto` ou `ehConexo`;
 
 4. Caso a escolha seja o `getAdjacentes`, a variável `adjacentes` terá que ser iniciada;
 
 5. Caso a escolha seja o `ehRegular`, retornará no console a mensagem `true` ou  `false`;
 
 6. Caso a escolha seja o `ehCompleto`, retornará no console a mensagem `true` ou  `false`;
 
 7. Caso a escolha seja o `ehConexo`, retornará no console a mensagem `true` ou  `false`.
  
 # Algoritmo de Dijkstra
 - Descricao:
 1. Implementação do algoritmo de Dijkstra que calcula o menor caminho de um vértice a outro no grafo;
 
 2. dijkstra: recebe como parâmetro um vértice e o algoritmo retorna o menor caminho deste para todos os demais vértices. Neste caso, deve-se imprimir na tela a menor distância para cada par de vértice e o caminho final entre eles;
 
 3. dijkstra2: recebe como parâmetro dois vértices e o algoritmo retorna o menor caminho somente entre estes dois vértices. Neste caso, deve-se imprimir na tela a menor distância entre eles e o caminho final.
 
 - Utilizando o projeto *Grafo*:
  1. Entrar na classe `Main`;
  
  2. Insira a lista de adjacência `.txt` no mesmo diretório do projeto;
  
  3. Altere o conteúdo da variável `"fileName"` com o mesmo nome do `.txt` adicionado no diretorio do projeto;
  
  4. Dar `Run File` no método `Grafo.dijkstra(grafo.get(1), grafo);`;
  
  5. Dar `Run File` no método `Grafo.dijkstra2(grafo.get(0), grafo.get(3), grafo)`.
 
 
 
  





