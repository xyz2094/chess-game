
# ChessGameMVC ♟️

Um jogo de xadrez desenvolvido em Java com interface gráfica Swing, utilizando o padrão de arquitetura MVC (Model-View-Controller). O projeto conta com funcionalidades completas de jogabilidade, sistema de ranking de jogadores e persistência de estado das partidas.

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Swing** — para construção da interface gráfica
- **Arquitetura MVC** — separação de responsabilidades entre modelo, visualização e controle
- **Serialização** — para persistência de dados
- **Coleções Java** — para gerenciamento de ranking e histórico de partidas

## 🎮 Funcionalidades

- Modo de jogo para dois jogadores locais
- Interface gráfica com tabuleiro interativo
- Validação de movimentos conforme as regras do xadrez
- Detecção de xeque e xeque-mate
- Sistema de salvamento e carregamento de partidas
- Ranking de jogadores com base nas vitórias acumuladas
- Reinício de partidas e reset de ranking

## 📁 Estrutura do Projeto

```
ChessGameMVC/
├── src/
│   ├── model/         # Lógica do jogo e peças
│   ├── view/          # Interface gráfica Swing
│   ├── controller/    # Controle das ações do usuário
│   ├── persistence/   # Serialização e arquivos de estado
│   └── Main.java      # Inicialização do jogo
├── resources/         # Ícones e assets visuais
└── README.md
```

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/vittordallacqua/ChessGameMVC.git
   cd ChessGameMVC
   ```

2. Compile o projeto:
   ```bash
   javac -d bin src/**/*.java
   ```

3. Execute o jogo:
   ```bash
   java -cp bin Main
   ```

Ou, se estiver utilizando uma IDE (como IntelliJ ou Eclipse), basta importar o projeto como Java Project e rodar a classe `Main`.

## 💾 Persistência

As partidas e o ranking de jogadores são salvos em arquivos locais por meio da serialização de objetos. Ao reiniciar o jogo, é possível continuar de onde parou ou iniciar uma nova partida.

## 📌 TODOs

- [ ] Implementar modo contra IA
- [ ] Melhorar o design da interface com componentes personalizados
- [ ] Suporte a jogadas especiais (roque, en passant, promoção)
- [ ] Exportação de partidas em formato PGN

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
