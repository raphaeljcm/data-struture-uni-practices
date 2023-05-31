export function nearestNeighbor(graph, startVertex) {
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

  const startVertexEdgeWeight = graph.vertices.has(startVertex) && graph.vertices.get(startVertex).has(path[path.length - 1])
    ? graph.vertices.get(startVertex).get(path[path.length - 1])
    : Infinity;

  if (startVertexEdgeWeight !== Infinity) {
    path.push(startVertex); // Complete the cycle
    totalWeight += startVertexEdgeWeight;
  } else {
    // No valid tour found, return null
    return null;
  }

  return { path, totalWeight };
}