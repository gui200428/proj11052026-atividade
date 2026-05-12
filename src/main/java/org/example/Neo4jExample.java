package org.example;

import org.neo4j.driver.*;
import org.neo4j.driver.Record;

import static org.neo4j.driver.Values.parameters;

public class Neo4jExample implements AutoCloseable {

    private final Driver driver;

    public Neo4jExample(String uri, String user, String password) {
        driver = (Driver) GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    @Override
    public void close() {
        driver.close();
    }

    // Relações de jogos
    public void initRelacoes(){
        try (Session session = driver.session()){
            session.writeTransaction(tx -> {
                tx.run("""
                    CREATE (a:Game {nome: 'Chrono trigger'})
                    CREATE (b:Game {nome: 'Street fighter alpha 3'})
                    CREATE (c:Game {nome: 'Final fight 3'})
                    CREATE (d:Game {nome: 'Melty Blood AACC'})
                    CREATE (e:Game {nome: 'Super Mario World'})
                    CREATE (f:Game {nome: 'Cadillac & Dinosaurs'})
                    CREATE (g:Game {nome: 'Art of Fighting'})
                    CREATE (h:Game {nome: 'Street Rage'})
                    CREATE (i:Game {nome: 'Super Mario RPG'})
                    CREATE (j:Game {nome: 'Sonic the Hedgehog'})
                    CREATE (k:Game {nome: 'Mortal Kombat'})
                    CREATE (l:Game {nome: 'Donkey Kong Country'})
                    
                    // Relações antigas
                    CREATE (a)-[:Action]->(b)
                    CREATE (a)-[:Action]->(c)
                    CREATE (b)-[:Fighting]->(c)
                    
                    // Conectando os jogos de Luta
                    CREATE (b)-[:Fighting]->(d)
                    CREATE (b)-[:Fighting]->(g)
                    CREATE (b)-[:Fighting]->(k)
                    
                    // Conectando os jogos de Beat 'em up / Ação
                    CREATE (c)-[:Action]->(f)
                    CREATE (c)-[:Action]->(h)
                    
                    // Conectando os RPGs
                    CREATE (a)-[:RPG]->(i)
                    
                    // Conectando os jogos de Plataforma
                    CREATE (e)-[:Platform]->(j)
                    CREATE (e)-[:Platform]->(l)
                    
                    // Conectando por Franquia
                    CREATE (e)-[:Franchise]->(i)
                """);
                return null;
            });
        }
    }

    // Conexôes
    public void listarGames(String nome){
        try (Session session = driver.session()) {
            Result result = session.run("""
                MATCH (p:Game {nome: $nome})-[:Action]->(action)
                RETURN action.nome AS nome
            """, parameters("nome", nome));

            System.out.println("Jogos conectados pela relação Action a partir de " + nome + ":");
            while (result.hasNext()) {
                Record record = result.next();
                System.out.println("- " + record.get("nome").asString());
            }
        }
    }

    public static void main(String[] args) {
        try (Neo4jExample app = new Neo4jExample(
                "bolt://localhost:7687",
                "neo4j",
                "senha123")) {

            app.initRelacoes();

            app.listarGames("Chrono trigger");
        }
    }
}