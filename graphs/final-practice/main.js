import * as readline from 'node:readline';
import { stdin as input, stdout as output } from 'node:process';
import { promisify } from 'node:util';

const VALID_CITIES = [
  "Belo Horizonte",
  "Contagem",
  "Uberlândia",
  "Juiz de Fora",
  "Ribeirão das Neves",
  "Betim",
  "Montes Claros",
  "Uberaba",
  "Governador Valadares",
  "Santa Luzia",
  "Ipatinga",
  "Sete Lagoas",
  "Divinópolis",
  "Poços de Caldas",
  "Ibirité"
];


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

function seedGraph(graph) {
  graph.addVertex("Belo Horizonte")
  graph.addVertex("Contagem")
  graph.addVertex("Uberlândia")
  graph.addVertex("Juiz de Fora")
  graph.addVertex("Ribeirão das Neves")
  graph.addVertex("Betim")
  graph.addVertex("Montes Claros")
  graph.addVertex("Uberaba")
  graph.addVertex("Governador Valadares")
  graph.addVertex("Santa Luzia")
  graph.addVertex("Ipatinga")
  graph.addVertex("Sete Lagoas")
  graph.addVertex("Divinópolis")
  graph.addVertex("Poços de Caldas")
  graph.addVertex("Ibirité")

  graph.addEdge('Belo Horizonte', 'Contagem', 19);
  graph.addEdge('Belo Horizonte', 'Uberlândia', 536);
  graph.addEdge('Belo Horizonte', 'Juiz de Fora', 261);
  graph.addEdge('Belo Horizonte', 'Ribeirão das Neves', 34);
  graph.addEdge('Belo Horizonte', 'Betim', 30);
  graph.addEdge('Belo Horizonte', 'Montes Claros', 425);
  graph.addEdge('Belo Horizonte', 'Uberaba', 475);
  graph.addEdge('Belo Horizonte', 'Governador Valadares', 317);
  graph.addEdge('Belo Horizonte', 'Santa Luzia', 24);
  graph.addEdge('Belo Horizonte', 'Ipatinga', 218);
  graph.addEdge('Belo Horizonte', 'Sete Lagoas', 75);
  graph.addEdge('Belo Horizonte', 'Divinópolis', 151);
  graph.addEdge('Belo Horizonte', 'Poços de Caldas', 462);
  graph.addEdge('Belo Horizonte', 'Ibirité', 21);

  graph.addEdge('Contagem', 'Belo Horizonte', 19);
  graph.addEdge('Contagem', 'Uberlândia', 523);
  graph.addEdge('Contagem', 'Juiz de Fora', 270);
  graph.addEdge('Contagem', 'Ribeirão das Neves', 27);
  graph.addEdge('Contagem', 'Betim', 17);
  graph.addEdge('Contagem', 'Montes Claros', 418);
  graph.addEdge('Contagem', 'Uberaba', 462);
  graph.addEdge('Contagem', 'Governador Valadares', 334);
  graph.addEdge('Contagem', 'Santa Luzia', 41);
  graph.addEdge('Contagem', 'Ipatinga', 235);
  graph.addEdge('Contagem', 'Sete Lagoas', 66);
  graph.addEdge('Contagem', 'Divinópolis', 139);
  graph.addEdge('Contagem', 'Poços de Caldas', 449);
  graph.addEdge('Contagem', 'Ibirité', 19);

  graph.addEdge('Uberlândia', 'Belo Horizonte', 536);
  graph.addEdge('Uberlândia', 'Contagem', 523);
  graph.addEdge('Uberlândia', 'Juiz de Fora', 785);
  graph.addEdge('Uberlândia', 'Ribeirão das Neves', 547);
  graph.addEdge('Uberlândia', 'Betim', 506);
  graph.addEdge('Uberlândia', 'Montes Claros', 627);
  graph.addEdge('Uberlândia', 'Uberaba', 106);
  graph.addEdge('Uberlândia', 'Governador Valadares', 851);
  graph.addEdge('Uberlândia', 'Santa Luzia', 558);
  graph.addEdge('Uberlândia', 'Ipatinga', 751);
  graph.addEdge('Uberlândia', 'Sete Lagoas', 596);
  graph.addEdge('Uberlândia', 'Divinópolis', 458);
  graph.addEdge('Uberlândia', 'Poços de Caldas', 474);
  graph.addEdge('Uberlândia', 'Ibirité', 524);

  graph.addEdge('Juiz de Fora', 'Belo Horizonte', 261);
  graph.addEdge('Juiz de Fora', 'Contagem', 271);
  graph.addEdge('Juiz de Fora', 'Uberlândia', 787);
  graph.addEdge('Juiz de Fora', 'Ribeirão das Neves', 286);
  graph.addEdge('Juiz de Fora', 'Betim', 280);
  graph.addEdge('Juiz de Fora', 'Montes Claros', 678);
  graph.addEdge('Juiz de Fora', 'Uberaba', 726);
  graph.addEdge('Juiz de Fora', 'Governador Valadares', 454);
  graph.addEdge('Juiz de Fora', 'Santa Luzia', 284);
  graph.addEdge('Juiz de Fora', 'Ipatinga', 426);
  graph.addEdge('Juiz de Fora', 'Sete Lagoas', 325);
  graph.addEdge('Juiz de Fora', 'Divinópolis', 322);
  graph.addEdge('Juiz de Fora', 'Poços de Caldas', 460);
  graph.addEdge('Juiz de Fora', 'Ibirité', 268);

  graph.addEdge('Ribeirão das Neves', 'Belo Horizonte', 33);
  graph.addEdge('Ribeirão das Neves', 'Contagem', 28);
  graph.addEdge('Ribeirão das Neves', 'Uberlândia', 552);
  graph.addEdge('Ribeirão das Neves', 'Juiz de Fora', 291);
  graph.addEdge('Ribeirão das Neves', 'Betim', 46);
  graph.addEdge('Ribeirão das Neves', 'Montes Claros', 398);
  graph.addEdge('Ribeirão das Neves', 'Uberaba', 491);
  graph.addEdge('Ribeirão das Neves', 'Governador Valadares', 334);
  graph.addEdge('Ribeirão das Neves', 'Santa Luzia', 33);
  graph.addEdge('Ribeirão das Neves', 'Ipatinga', 235);
  graph.addEdge('Ribeirão das Neves', 'Sete Lagoas', 46);
  graph.addEdge('Ribeirão das Neves', 'Divinópolis', 168);
  graph.addEdge('Ribeirão das Neves', 'Poços de Caldas', 478);
  graph.addEdge('Ribeirão das Neves', 'Ibirité', 44);

  graph.addEdge('Betim', 'Belo Horizonte', 25);
  graph.addEdge('Betim', 'Contagem', 15);
  graph.addEdge('Betim', 'Uberlândia', 384);
  graph.addEdge('Betim', 'Juiz de Fora', 205);
  graph.addEdge('Betim', 'Ribeirão das Neves', 33);
  graph.addEdge('Betim', 'Montes Claros', 310);
  graph.addEdge('Betim', 'Uberaba', 339);
  graph.addEdge('Betim', 'Governador Valadares', 282);
  graph.addEdge('Betim', 'Santa Luzia', 46);
  graph.addEdge('Betim', 'Ipatinga', 208);
  graph.addEdge('Betim', 'Sete Lagoas', 63);
  graph.addEdge('Betim', 'Divinópolis', 85);
  graph.addEdge('Betim', 'Poços de Caldas', 333);
  graph.addEdge('Betim', 'Ibirité', 22);

  graph.addEdge('Montes Claros', 'Belo Horizonte', 304);
  graph.addEdge('Montes Claros', 'Contagem', 296);
  graph.addEdge('Montes Claros', 'Uberlândia', 447);
  graph.addEdge('Montes Claros', 'Juiz de Fora', 487);
  graph.addEdge('Montes Claros', 'Ribeirão das Neves', 282);
  graph.addEdge('Montes Claros', 'Betim', 308);
  graph.addEdge('Montes Claros', 'Uberaba', 486);
  graph.addEdge('Montes Claros', 'Governador Valadares', 388);
  graph.addEdge('Montes Claros', 'Santa Luzia', 310);
  graph.addEdge('Montes Claros', 'Ipatinga', 377);
  graph.addEdge('Montes Claros', 'Sete Lagoas', 256);
  graph.addEdge('Montes Claros', 'Divinópolis', 390);
  graph.addEdge('Montes Claros', 'Poços de Caldas', 636);
  graph.addEdge('Montes Claros', 'Ibirité', 309);

  graph.addEdge('Uberaba', 'Belo Horizonte', 362);
  graph.addEdge('Uberaba', 'Contagem', 352);
  graph.addEdge('Uberaba', 'Uberlândia', 72);
  graph.addEdge('Uberaba', 'Juiz de Fora', 543);
  graph.addEdge('Uberaba', 'Ribeirão das Neves', 370);
  graph.addEdge('Uberaba', 'Betim', 342);
  graph.addEdge('Uberaba', 'Montes Claros', 486);
  graph.addEdge('Uberaba', 'Governador Valadares', 619);
  graph.addEdge('Uberaba', 'Santa Luzia', 383);
  graph.addEdge('Uberaba', 'Ipatinga', 545);
  graph.addEdge('Uberaba', 'Sete Lagoas', 382);
  graph.addEdge('Uberaba', 'Divinópolis', 312);
  graph.addEdge('Uberaba', 'Poços de Caldas', 259);
  graph.addEdge('Uberaba', 'Ibirité', 357);

  graph.addEdge('Governador Valadares', 'Belo Horizonte', 270);
  graph.addEdge('Governador Valadares', 'Contagem', 280);
  graph.addEdge('Governador Valadares', 'Uberlândia', 672);
  graph.addEdge('Governador Valadares', 'Juiz de Fora', 328);
  graph.addEdge('Governador Valadares', 'Ribeirão das Neves', 284);
  graph.addEdge('Governador Valadares', 'Betim', 292);
  graph.addEdge('Governador Valadares', 'Montes Claros', 386);
  graph.addEdge('Governador Valadares', 'Uberaba', 627);
  graph.addEdge('Governador Valadares', 'Santa Luzia', 260);
  graph.addEdge('Governador Valadares', 'Ipatinga', 77);
  graph.addEdge('Governador Valadares', 'Sete Lagoas', 311);
  graph.addEdge('Governador Valadares', 'Divinópolis', 373);
  graph.addEdge('Governador Valadares', 'Poços de Caldas', 620);
  graph.addEdge('Governador Valadares', 'Ibirité', 286);

  graph.addEdge('Santa Luzia', 'Belo Horizonte', 26);
  graph.addEdge('Santa Luzia', 'Contagem', 37);
  graph.addEdge('Santa Luzia', 'Uberlândia', 429);
  graph.addEdge('Santa Luzia', 'Juiz de Fora', 216);
  graph.addEdge('Santa Luzia', 'Ribeirão das Neves', 30);
  graph.addEdge('Santa Luzia', 'Betim', 48);
  graph.addEdge('Santa Luzia', 'Montes Claros', 308);
  graph.addEdge('Santa Luzia', 'Uberaba', 383);
  graph.addEdge('Santa Luzia', 'Governador Valadares', 253);
  graph.addEdge('Santa Luzia', 'Ipatinga', 187);
  graph.addEdge('Santa Luzia', 'Sete Lagoas', 55);
  graph.addEdge('Santa Luzia', 'Divinópolis', 128);
  graph.addEdge('Santa Luzia', 'Poços de Caldas', 366);
  graph.addEdge('Santa Luzia', 'Ibirité', 43);

  graph.addEdge('Ipatinga', 'Belo Horizonte', 196);
  graph.addEdge('Ipatinga', 'Contagem', 206);
  graph.addEdge('Ipatinga', 'Uberlândia', 598);
  graph.addEdge('Ipatinga', 'Juiz de Fora', 311);
  graph.addEdge('Ipatinga', 'Ribeirão das Neves', 210);
  graph.addEdge('Ipatinga', 'Betim', 218);
  graph.addEdge('Ipatinga', 'Montes Claros', 377);
  graph.addEdge('Ipatinga', 'Uberaba', 553);
  graph.addEdge('Ipatinga', 'Governador Valadares', 78);
  graph.addEdge('Ipatinga', 'Santa Luzia', 187);
  graph.addEdge('Ipatinga', 'Sete Lagoas', 229);
  graph.addEdge('Ipatinga', 'Divinópolis', 289);
  graph.addEdge('Ipatinga', 'Poços de Caldas', 528);
  graph.addEdge('Ipatinga', 'Ibirité', 212);

  graph.addEdge('Sete Lagoas', 'Belo Horizonte', 57);
  graph.addEdge('Sete Lagoas', 'Contagem', 50);
  graph.addEdge('Sete Lagoas', 'Uberlândia', 404);
  graph.addEdge('Sete Lagoas', 'Juiz de Fora', 240);
  graph.addEdge('Sete Lagoas', 'Ribeirão das Neves', 35);
  graph.addEdge('Sete Lagoas', 'Betim', 62);
  graph.addEdge('Sete Lagoas', 'Montes Claros', 255);
  graph.addEdge('Sete Lagoas', 'Uberaba', 382);
  graph.addEdge('Sete Lagoas', 'Governador Valadares', 303);
  graph.addEdge('Sete Lagoas', 'Santa Luzia', 55);
  graph.addEdge('Sete Lagoas', 'Ipatinga', 229);
  graph.addEdge('Sete Lagoas', 'Divinópolis', 143);
  graph.addEdge('Sete Lagoas', 'Poços de Caldas', 389);
  graph.addEdge('Sete Lagoas', 'Ibirité', 63);

  graph.addEdge('Divinópolis', 'Belo Horizonte', 107);
  graph.addEdge('Divinópolis', 'Contagem', 97);
  graph.addEdge('Divinópolis', 'Uberlândia', 356);
  graph.addEdge('Divinópolis', 'Juiz de Fora', 251);
  graph.addEdge('Divinópolis', 'Ribeirão das Neves', 114);
  graph.addEdge('Divinópolis', 'Betim', 86);
  graph.addEdge('Divinópolis', 'Montes Claros', 391);
  graph.addEdge('Divinópolis', 'Uberaba', 311);
  graph.addEdge('Divinópolis', 'Governador Valadares', 364);
  graph.addEdge('Divinópolis', 'Santa Luzia', 128);
  graph.addEdge('Divinópolis', 'Ipatinga', 289);
  graph.addEdge('Divinópolis', 'Sete Lagoas', 145);
  graph.addEdge('Divinópolis', 'Poços de Caldas', 304);
  graph.addEdge('Divinópolis', 'Ibirité', 102);

  graph.addEdge('Poços de Caldas', 'Belo Horizonte', 465);
  graph.addEdge('Poços de Caldas', 'Contagem', 456);
  graph.addEdge('Poços de Caldas', 'Uberlândia', 446);
  graph.addEdge('Poços de Caldas', 'Juiz de Fora', 379);
  graph.addEdge('Poços de Caldas', 'Ribeirão das Neves', 353);
  graph.addEdge('Poços de Caldas', 'Betim', 325);
  graph.addEdge('Poços de Caldas', 'Montes Claros', 630);
  graph.addEdge('Poços de Caldas', 'Uberaba', 258);
  graph.addEdge('Poços de Caldas', 'Governador Valadares', 602);
  graph.addEdge('Poços de Caldas', 'Santa Luzia', 366);
  graph.addEdge('Poços de Caldas', 'Ipatinga', 528);
  graph.addEdge('Poços de Caldas', 'Sete Lagoas', 384);
  graph.addEdge('Poços de Caldas', 'Divinópolis', 300);
  graph.addEdge('Poços de Caldas', 'Ibirité', 340);

  graph.addEdge('Ibirité', 'Belo Horizonte', 21);
  graph.addEdge('Ibirité', 'Contagem', 20);
  graph.addEdge('Ibirité', 'Uberlândia', 401);
  graph.addEdge('Ibirité', 'Juiz de Fora', 199);
  graph.addEdge('Ibirité', 'Ribeirão das Neves', 34);
  graph.addEdge('Ibirité', 'Betim', 23);
  graph.addEdge('Ibirité', 'Montes Claros', 312);
  graph.addEdge('Ibirité', 'Uberaba', 356);
  graph.addEdge('Ibirité', 'Governador Valadares', 278);
  graph.addEdge('Ibirité', 'Santa Luzia', 42);
  graph.addEdge('Ibirité', 'Ipatinga', 203);
  graph.addEdge('Ibirité', 'Sete Lagoas', 65);
  graph.addEdge('Ibirité', 'Divinópolis', 103);
  graph.addEdge('Ibirité', 'Poços de Caldas', 349);
}

const formatToKm = (number) => 
  new Intl.NumberFormat('pt-BR', { style: 'unit', unit: 'kilometer' }).format(number)

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

    if (VALID_CITIES.includes(answer)) {
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