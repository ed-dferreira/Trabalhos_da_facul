public static void salvarJogo() {
    try (FileWriter writer = new FileWriter("estado_do_jogo.txt")) {
        writer.write((vezMaiuscula ? 'M' : 'm') + "\n");
        writer.write(usadasMinusculas + "\n");
        writer.write(usadasMaiusculas + "\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                writer.write(tabuleiro[i][j]);
            }
            writer.write("\n");
        }
        System.out.println("Jogo salvo com sucesso!");
    } catch (IOException e) {
        System.out.println("Erro ao salvar o jogo: " + e.getMessage());
    }
}

public static void carregarJogo() {
    try (BufferedReader reader = new BufferedReader(new FileReader("estado_do_jogo.txt"))) {
        vezMaiuscula = reader.readLine().charAt(0) == 'M';
        usadasMinusculas = reader.readLine();
        usadasMaiusculas = reader.readLine();

        for (char c : usadasMinusculas.toCharArray()) {
            letrasMinusculasUsadas.add(c);
        }
        for (char c : usadasMaiusculas.toCharArray()) {
            letrasMaiusculasUsadas.add(c);
        }

        for (int i = 0; i < 3; i++) {
            String linha = reader.readLine();
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = linha.charAt(j);
            }
        }
        System.out.println("Jogo carregado com sucesso!");
    } catch (IOException e) {
        System.out.println("Erro ao carregar o jogo: " + e.getMessage());
    }
}
}
