export class WeightedGraph {
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