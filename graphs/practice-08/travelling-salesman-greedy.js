class WeightedGraph {
  constructor() {
    this.vertices = new Map();
  }

  addVertex(vertex) {
    this.vertices.set(vertex, new Map());
  }

  addEdge(vertex1, vertex2, weight) {
    this.vertices.get(vertex1).set(vertex2, weight);
    this.vertices.get(vertex2).set(vertex1, weight);
  }
}

function nearestNeighbor(graph, startVertex) {
  const numVertices = graph.vertices.size;
  const visited = new Set();
  const path = [startVertex];
  let totalWeight = 0;

  visited.add(startVertex);

  for (let i = 0; i < numVertices - 1; i++) {
    const currentVertex = path[path.length - 1];
    let nearestVertex = null;
    let minDistance = Infinity;

    for (const [neighbor, weight] of graph.vertices.get(currentVertex)) {
      if (!visited.has(neighbor) && weight < minDistance) {
        minDistance = weight;
        nearestVertex = neighbor;
      }
    }

    path.push(nearestVertex);
    totalWeight += minDistance;
    visited.add(nearestVertex);
  }

  const startVertexEdgeWeight = graph.vertices.get(startVertex).get(path[path.length - 1]);
  path.push(startVertex); // Complete the cycle
  totalWeight += startVertexEdgeWeight;

  return { path, totalWeight };
}

function findBestTour(graph) {
  let bestPath = null;
  let bestWeight = Infinity;

  for (const startVertex of graph.vertices.keys()) {
    const { path, totalWeight } = nearestNeighbor(graph, startVertex);

    if (totalWeight < bestWeight) {
      bestPath = path;
      bestWeight = totalWeight;
    }
  }

  return { path: bestPath, totalWeight: bestWeight };
}

const graph = new WeightedGraph();
graph.addVertex('A');
graph.addVertex('B');
graph.addVertex('C');
graph.addVertex('D');
graph.addVertex('E');

graph.addEdge('A', 'B', 1);
graph.addEdge('A', 'C', 3);
graph.addEdge('A', 'E', 4);
graph.addEdge('B', 'C', 3);
graph.addEdge('B', 'D', 1);
graph.addEdge('C', 'D', 6);
graph.addEdge('C', 'E', 2);
graph.addEdge('D', 'E', 7);

const { path, totalWeight } = findBestTour(graph);
console.log("Optimal path:", path);
console.log("Total weight:", totalWeight);