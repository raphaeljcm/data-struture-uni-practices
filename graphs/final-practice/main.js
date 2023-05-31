import * as readline from 'node:readline';
import { stdin as input, stdout as output } from 'node:process';
import { promisify } from 'node:util';
import { CITIES, CITY_CONNECTIONS } from './const.js'
import { nearestNeighbor } from './nearestNeighbor.js'
import { WeightedGraph } from './graph.js'
import { formatToKm } from './utils.js'

const seedGraph = (graph) => {
  CITIES.forEach(city => graph.addVertex(city));
  CITY_CONNECTIONS.forEach(([ vertex1, vertex2, weight ]) => graph.addEdge(vertex1, vertex2, weight));
}

function main(city) {
  const graph = new WeightedGraph();
  seedGraph(graph);

  const { path, totalWeight } = nearestNeighbor(graph, city);
  console.log("Caminho completo: ", path.join(' -> '));
  console.log("Distância total: ", formatToKm(totalWeight));
}

async function getCity() {
  const rl = readline.createInterface({ input, output });
  let city = '';

  const question = promisify(rl.question).bind(rl);

  console.log('|----------------------------------------|');
  console.log('|     App de Planejamento de Viagem      |');
  console.log('|----------------------------------------|');
  console.log('|   Bem vindo ao Planejamento de Viagem! |');
  console.log('|----------------------------------------|');

  while (true) {
    const answer = await question('De qual cidade você irá partir? ');

    if (CITIES.includes(answer)) {
      city = answer;
      break;
    } else {
      console.log('|-----------------------------------------------|');
      console.log('|  Cidade inválida! Por favor, tente novamente. |');
      console.log('|-----------------------------------------------|');
    }
  }

  rl.close();
  main(city);
}

getCity();