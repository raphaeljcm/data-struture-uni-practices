class WeightedGraph {
  constructor() {
    this.adjacencyList = {};
  }

  addVertex(vertex) {
    if (!this.adjacencyList[vertex]) this.adjacencyList[vertex] = [];
  }

  addEdge(vertex1, vertex2, weight) {
    this.adjacencyList[vertex1].push({ node: vertex2, weight });
    this.adjacencyList[vertex2].push({ node: vertex1, weight });
  }

  getWeight(vertex1, vertex2) {
    const vertex = this.adjacencyList[vertex1].find((v) => v.node === vertex2);
    return vertex ? vertex.weight : null;
  }

  getTotalWeight(path) {
    let total = 0;
    
    for (let i = 0; i < path.length - 1; i++) {
      total += this.getWeight(path[i], path[i + 1]);
    }
    return total;
  }

  Dijkstra(start, finish) {
    const nodes = new PriorityQueue();
    const distances = {};
    const previous = {};
    let path = [] // para retornar no final
    let smallest;

    // constrói o estado inicial
    for (let vertex in this.adjacencyList) {
      if (vertex === start) {
        distances[vertex] = 0;
        nodes.enqueue(vertex, 0);
      } else {
        distances[vertex] = Infinity;
        nodes.enqueue(vertex, Infinity);
      }
      previous[vertex] = null;
    }
    // enquanto houver algo para visitar
    while (nodes.values.length) {
      smallest = nodes.dequeue().val;

      if (smallest === finish) {

        // acabou, constrói o caminho para retornar
        while (previous[smallest]) {
          path.push(smallest);
          smallest = previous[smallest];
        }
        break;
      }

      if (smallest || distances[smallest] !== Infinity) {
        for (let neighbor in this.adjacencyList[smallest]) {
          // encontra o vizinho mais próximo

          let nextNode = this.adjacencyList[smallest][neighbor];

          // calcula a nova distância para o nó vizinho
          let candidate = distances[smallest] + nextNode.weight;
          let nextNeighbor = nextNode.node;

          if (candidate < distances[nextNeighbor]) {
            // atualiza a nova menor distância para o vizinho
            distances[nextNeighbor] = candidate;

            // atualiza o nó anterior, como chegamos ao vizinho
            previous[nextNeighbor] = smallest;

            // enfilera na fila de prioridade com nova prioridade
            nodes.enqueue(nextNeighbor, candidate);
          }
        }
      }
    }

    const result = {
      path: path.concat(smallest).reverse(),
      totalWeight: this.getTotalWeight(path.concat(smallest)),
    }

    return result;
  }
}

class PriorityQueue {
  constructor() {
    this.values = [];
  }

  enqueue(val, priority) {
    let newNode = new Node(val, priority);
    this.values.push(newNode);
    this.bubbleUp();
  }

  bubbleUp() {
    let idx = this.values.length - 1;
    const element = this.values[idx];

    while (idx > 0) {
      let parentIdx = Math.floor((idx - 1) / 2);
      let parent = this.values[parentIdx];
      if (element.priority >= parent.priority) break;
      this.values[parentIdx] = element;
      this.values[idx] = parent;
      idx = parentIdx;
    }
  }

  dequeue() {
    const min = this.values[0];
    const end = this.values.pop();

    if (this.values.length > 0) {
      this.values[0] = end;
      this.sinkDown();
    }
    return min;
  }

  sinkDown() {
    let idx = 0;
    const length = this.values.length;
    const element = this.values[0];

    while (true) {
      let leftChildIdx = 2 * idx + 1;
      let rightChildIdx = 2 * idx + 2;
      let leftChild, rightChild;
      let swap = null;

      if (leftChildIdx < length) {
        leftChild = this.values[leftChildIdx];
        if (leftChild.priority < element.priority) {
          swap = leftChildIdx;
        }
      }

      if (rightChildIdx < length) {
        rightChild = this.values[rightChildIdx];
        if (
          (swap === null && rightChild.priority < element.priority) ||
          (swap !== null && rightChild.priority < leftChild.priority)
        ) {
          swap = rightChildIdx;
        }
      }

      if (swap === null) break;
      this.values[idx] = this.values[swap];
      this.values[swap] = element;
      idx = swap;
    }
  }
}

class Node {
  constructor(val, priority) {
    this.val = val;
    this.priority = priority;
  }
}

var graph = new WeightedGraph()
graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addVertex("D");
graph.addVertex("E");
graph.addVertex("F");
graph.addVertex("G");
graph.addVertex("H");
graph.addVertex("I");
graph.addVertex("J");

graph.addEdge("A", "B", 4);
graph.addEdge("A", "C", 5);
graph.addEdge("A", "D", 3);
graph.addEdge("B", "E", 8);
graph.addEdge("B", "F", 6);
graph.addEdge("C", "E", 4);
graph.addEdge("C", "F", 8);
graph.addEdge("C", "G", 7);
graph.addEdge("D", "F", 9);
graph.addEdge("D", "G", 11);
graph.addEdge("E", "H", 6);
graph.addEdge("E", "I", 9);
graph.addEdge("F", "H", 10);
graph.addEdge("F", "I", 12);
graph.addEdge("G", "I", 3);
graph.addEdge("H", "J", 7);
graph.addEdge("I", "J", 5);

console.log(graph.Dijkstra("A", "J"));




