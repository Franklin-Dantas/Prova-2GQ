package attDois;

import java.util.Scanner;

public class provaGQ {

	public static void imprimeMapa(int[][] mapa) {
		System.out.println("   0  1  2  3  4  5  6  7  8  9 -- X");
		for (int i = 0; i < mapa.length; i++) {// linha
			System.out.print(i);
			for (int j = 0; j < mapa[0].length; j++) {// coluna
				if (mapa[i][j] == 15) {
					System.out.print("  " + "0");
				} else if (mapa[i][j] == -1) {
					System.out.print("  " + "#");
				} else if (mapa[i][j] == 1) {
					System.out.print("  " + "@");
				} else {
					System.out.print("  " + mapa[i][j]);
				}
			}
			System.out.println(" ");
		}
	}

	public static boolean verificaMovimento(int[][] mapa, int x, int y, int finalX, int finalY) {
		if (finalX < 10 && finalY < 10 && finalX > -1 && finalY > -1) {
			if (mapa[finalX][finalY] != -1) {
				if (finalY == y - 1 && finalX == x) {
					return true;
				} else if (finalY == y + 1 && finalX == x) {
					return true;
				} else if (finalX == x - 1 && y == finalY) {
					return true;
				} else if (finalX == x + 1 && y == finalY) {
					return true;
				}
			}
		}
		return false;
	}

	public static int calculaPontos(int[][] mapa, int x, int y) {
		if (mapa[x][y] == -1) {
			return -1;
		} else if (mapa[x][y] == 5) {
			return 5;
		} else if (mapa[x][y] == 15) {
			return 15;
		} else
			return 0;
	}

	public static void main(String[] args) {
		String jogarN = "sim";
		while(jogarN.equals("sim")){
		int yInicial = 0, xInical = 0, yFinal, xFinal, marcaV = 0, marcaE = 0, pontosT = 0, contJ = 0;
		String nome, nomeV;
		Scanner s = new Scanner(System.in);
		int[][] mapa = new int[10][10];
		
		mapa[0][0] = 1;
		// 10 89 70 41 43 7
		mapa[1][0] = 5;
		mapa[8][9] = 5;
		mapa[7][0] = 5;
		mapa[4][1] = 5;
		mapa[4][3] = 5;
		// 20 17 28 02 40
		mapa[2][0] = 15;
		mapa[1][7] = 15;
		mapa[2][8] = 15;
		mapa[0][2] = 15;
		mapa[4][0] = 15;
		
			
		System.out.println("Bem Vindo ao novo game da MOKIA!");
		System.out.println("Para jogar Snake 2.0");
		System.out.println("Você vai precisar se cadastrar.");
		System.out.println("Digite seu nome:");
		nome = s.nextLine();
		while (nome.length() < 7) {
			System.out.println("O nome deve ter pelo menos 7 letras!");
			nome = s.nextLine();
		}
		System.out.println("Digite seu nome novamente para validar");
		nomeV = s.nextLine();
		while (nomeV.length() != nome.length()) {
			System.out.println("O nome invalido, nome deve estar cadastrado!");
			nome = s.nextLine();
		}
		while (marcaV < 5) {
			imprimeMapa(mapa);
			contJ++;
			do {
				System.out.println("Digite a coordenada Y para onde você deseja ir: ");
				yFinal = s.nextInt();
				System.out.println("Digite a coordenada X para onde você deseja ir: :");
				xFinal = s.nextInt();
				verificaMovimento(mapa, yInicial, xInical, yFinal, xFinal);

				if (verificaMovimento(mapa, yInicial, xInical, yFinal, xFinal) == false) {
					System.out.println("Você agora esta na posição x=" + yInicial + " e y=" + xInical
							+ " , você não pode ir para essa possição!");
				}
			} while (verificaMovimento(mapa, yInicial, xInical, yFinal, xFinal) == false);

			int valorP = calculaPontos(mapa, yFinal, xFinal);

			if (valorP == 5 || valorP == 15) {
				pontosT = pontosT + valorP;

				if (valorP == 5) {
					System.out.println("Você fez pegou uma pontuação visivel");
					marcaV++;
				} else {
					System.out.println("Você fez pegou uma pontuação visivel");
					marcaE++;
				}
			}
			mapa[yInicial][xInical] = -1;
			mapa[yFinal][xFinal] = 1;
			yInicial = yFinal;
			xInical = xFinal;
		}
		System.out.println("#############################################################################################################");
		System.out.println("Parabéns " + nome + " seu score de : %.2f" + (pontosT / contJ) + " , no total de " + contJ + " jogadas.");
		System.out.println("Você fez um total de : " + pontosT + " ,sendo um total de '" + marcaE + "' marcações escondidas" + "e '" + marcaE + "' marcações visiveis");
		System.out.println("#############################################################################################################");
		System.out.println("");
		System.out.println("Para jogar novamente digite 'sim' ou se deseja sair digite 'não'.");
		jogarN = s.next();
	}
		System.out.println("Obrigado por jogar!");
	}
}
