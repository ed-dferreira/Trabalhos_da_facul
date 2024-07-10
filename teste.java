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



public static boolean verificarLetras(int linha, int coluna, char letra) {
    if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
        return false; // Posição fora do tabuleiro
    }

    if (tabuleiro[linha][coluna] == '-') { // Espaço vazio
        if (Character.isLetter(letra)) {
            if (vezMaiuscula && Character.isUpperCase(letra) && !letrasMaiusculasUsadas.contains(letra)) {
                tabuleiro[linha][coluna] = letra;
                letrasMaiusculasUsadas.add(letra);
                usadasMaiusculas += letra;
                return true;
            } else if (!vezMaiuscula && Character.isLowerCase(letra) && !letrasMinusculasUsadas.contains(letra)) {
                tabuleiro[linha][coluna] = letra;
                letrasMinusculasUsadas.add(letra);
                usadasMinusculas += letra;
                return true;
            }
        }
    } else { // Espaço ocupado
        char letraNoTabuleiro = tabuleiro[linha][coluna];
        if (vezMaiuscula && Character.isUpperCase(letra) && Character.isLowerCase(letraNoTabuleiro) &&
                letra > Character.toUpperCase(letraNoTabuleiro) && !letrasMaiusculasUsadas.contains(letra)) {
            tabuleiro[linha][coluna] = letra;
            letrasMaiusculasUsadas.add(letra);
            usadasMaiusculas += letra;
            return true;
        } else if (!vezMaiuscula && Character.isLowerCase(letra) && Character.isUpperCase(letraNoTabuleiro) &&
                Character.toUpperCase(letra) > letraNoTabuleiro && !letrasMinusculasUsadas.contains(letra)) {
            tabuleiro[linha][coluna] = letra;
            letrasMinusculasUsadas.add(letra);
            usadasMinusculas += letra;
            return true;
        }
    }

    return false;
}
}