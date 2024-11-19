package pegaPrea;

import Entidades.Entidade;

public class ChecaColisao {

    TelaDoJogo gp;

    public ChecaColisao(TelaDoJogo gp) {
        this.gp = gp;
    }

    public void checarPiso(Entidade entidade) {
        // Resetando a colisão
        entidade.collisionOn = false;

        int entidadeLeftX = entidade.entidadeX + entidade.colisaoEntidade.x;
        int entidadeRightX = entidade.entidadeX + entidade.colisaoEntidade.x + entidade.colisaoEntidade.width;
        int entidadeTopY = entidade.entidadeY + entidade.colisaoEntidade.y;
        int entidadeDownY = entidade.entidadeY + entidade.colisaoEntidade.y + entidade.colisaoEntidade.height;

        int entidadeLeftCol = Math.floorDiv(entidadeLeftX, gp.tileSize);
        int entidadeRightCol = Math.floorDiv(entidadeRightX, gp.tileSize);
        int entidadeTopRow = Math.floorDiv(entidadeTopY, gp.tileSize);
        int entidadeDownRow = Math.floorDiv(entidadeDownY, gp.tileSize);

        int tileNum1, tileNum2;

        switch (entidade.direction) {
            case ("up"):
                entidadeTopRow = Math.floorDiv(entidadeTopY - entidade.speed, gp.tileSize);
                tileNum1 = gp.controleAmbiente.numAmbientesPisos[entidadeLeftCol][entidadeTopRow];
                tileNum2 = gp.controleAmbiente.numAmbientesPisos[entidadeRightCol][entidadeTopRow];
                if (gp.controleAmbiente.ambientes[tileNum1].collision || gp.controleAmbiente.ambientes[tileNum2].collision) {
                    System.out.println("Colisão detectada à cima!");
                    entidade.collisionOn = true;
                }
                break;
            case ("down"):
                entidadeDownRow = Math.floorDiv(entidadeDownY + entidade.speed, gp.tileSize);
                tileNum1 = gp.controleAmbiente.numAmbientesPisos[entidadeLeftCol][entidadeDownRow];
                tileNum2 = gp.controleAmbiente.numAmbientesPisos[entidadeRightCol][entidadeDownRow];
                if (gp.controleAmbiente.ambientes[tileNum1].collision || gp.controleAmbiente.ambientes[tileNum2].collision) {
                    System.out.println("Colisão detectada à baixo!");
                    entidade.collisionOn = true;
                }
                break;
            case ("left"):
                entidadeLeftCol = Math.floorDiv(entidadeLeftX - entidade.speed, gp.tileSize);
                tileNum1 = gp.controleAmbiente.numAmbientesPisos[entidadeLeftCol][entidadeTopRow];
                tileNum2 = gp.controleAmbiente.numAmbientesPisos[entidadeLeftCol][entidadeDownRow];
                if (gp.controleAmbiente.ambientes[tileNum1].collision || gp.controleAmbiente.ambientes[tileNum2].collision) {
                    System.out.println("Colisão detectada à esquerda!");
                    entidade.collisionOn = true;
                }
                break;
            case ("right"):
                entidadeRightCol = Math.floorDiv(entidadeRightX + entidade.speed, gp.tileSize);
                tileNum1 = gp.controleAmbiente.numAmbientesPisos[entidadeRightCol][entidadeTopRow];
                tileNum2 = gp.controleAmbiente.numAmbientesPisos[entidadeRightCol][entidadeDownRow];
                if (gp.controleAmbiente.ambientes[tileNum1].collision || gp.controleAmbiente.ambientes[tileNum2].collision) {
                    System.out.println("Colisão detectada à direita!");
                    entidade.collisionOn = true;
                }
                break;
        }
    }
}
