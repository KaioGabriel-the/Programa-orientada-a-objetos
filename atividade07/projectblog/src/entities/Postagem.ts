/**
 * Classe que representa uma postagem em um sistema de rede social ou blog.
 */
export class Postagem {
    // Variável estática que mantém o próximo ID a ser atribuído para cada nova instância da classe.
    private static nextId: number = 0;
    
    // ID único da postagem. É inicializado com 0, mas é atribuído na criação da postagem.
    public id: number = 0;

    // Texto da postagem, que pode ser acessado e modificado publicamente.
    public texto: string;

    // Quantidade de curtidas que a postagem recebeu, inicializada em 0.
    private qtdCurtida: number = 0;

    /**
     * Construtor da classe `Postagem`.
     * Atribui um ID único à postagem e inicializa o texto da postagem.
     * @param text O texto da postagem.
     */
    constructor(text: string) {
        // Atribui o próximo ID disponível à postagem e incrementa o contador `nextId`.
        this.id = Postagem.nextId;
        Postagem.nextId++;
        
        // Inicializa o texto da postagem com o valor passado como argumento.
        this.texto = text;
    }

    /**
     * Método que incrementa a quantidade de curtidas da postagem.
     */
    public curtir(): void {
        // Aumenta em 1 a quantidade de curtidas da postagem.
        this.qtdCurtida += 1;
    }

    /**
     * Método que retorna a quantidade de curtidas da postagem.
     * @returns A quantidade de curtidas.
     */
    public getCurtida(): number {
        // Retorna o número de curtidas da postagem.
        return this.qtdCurtida;
    }

    /**
     * Método que retorna uma representação em string da postagem.
     * @returns A string representando a postagem com o texto e a quantidade de curtidas.
     */
    public toString(): string {
        // Monta a string com as informações da postagem.
        let poste = `----- MENSAGEM -----\n${this.texto} \nCurtir: ${this.getCurtida()}`;

        // Retorna a string formatada.
        return poste;
    }
}
